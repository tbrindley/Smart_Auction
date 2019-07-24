package com.ally.service.impl;

import com.ally.exception.InvalidMaxBidException;
import com.ally.model.Bid.Bid;
import com.ally.model.Bid.SingleBid;
import com.ally.model.auctionitem.Item;
import com.ally.repository.BidRepository;
import com.ally.repository.ItemRepository;
import com.ally.repository.SingleBidRepository;
import com.ally.service.BidService;
import java.math.BigDecimal;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BidServiceImpl implements BidService {

  @Autowired
  private BidRepository bidRepository;

  @Autowired
  private SingleBidRepository singleBidRepository;

  @Autowired
  private EntityManager entityManager;

  @Autowired
  private ItemRepository itemRepository;

  @Override
  public ResponseEntity<String> placeBid(Bid bid) throws InvalidMaxBidException {
    Item bidItem = bid.getItem();

    if (!isBidGreaterThanReservePrice(bid)) {
      throw new InvalidMaxBidException(bid.getMaxAutoBidAmount(), bidItem.getReservePrice());
    }
    //TODO:  Make it so users can't compete against themselves
    Bid competingBid = getCompetingBid(bidItem);

    if (isFirstBid(competingBid)) {
      placeFirstBid(bid, bidItem);
      return new ResponseEntity<>("Bid successfully placed", HttpStatus.OK);
    }

    if (isBidTheHighestMaxBid(bid, competingBid)) {
      saveTransation(bid, competingBid, bidItem);
      notifyUserOfBidStatus(competingBid);

    } else {
      saveTransation(competingBid, bid, bidItem);
      String response = "Your bid is not greater than the max bid of a competitor";
      return new ResponseEntity<>(response, HttpStatus.OK);
    }
    return new ResponseEntity<String>("Bid successfully placed", HttpStatus.OK);
  }


  //----------------
  //--helper methods
  //----------------
  private boolean isFirstBid(Bid competingBid) {
    return competingBid == null;
  }

  private boolean isBidGreaterThanReservePrice(Bid bid) {
    return bid.getItem().getReservePrice().compareTo(bid.getMaxAutoBidAmount()) < 0;
  }

  private boolean isBidTheHighestMaxBid(Bid bid, Bid competingBid) {
    return competingBid.getMaxAutoBidAmount().compareTo(bid.getMaxAutoBidAmount()) < 0;
  }

  private void saveTransation(Bid highBid, Bid lowBid, Item bidItem
  ) {
    //TODO:  Fix edge case where $1 auto-add takes user over max bid
    if (highBid.getCurrentBid().compareTo(lowBid.getMaxAutoBidAmount()) < 0) {
      Session session = entityManager.unwrap(Session.class);

      //settingCurrentBidAmount for bid
      BigDecimal newCurrentBid = lowBid.getMaxAutoBidAmount().add(new BigDecimal(1));
      highBid.setCurrentBid(newCurrentBid);
      session.merge(highBid);

      //Creating log of transation
      createSingleBidRecord(highBid, bidItem);

      //updating current price on the item
      bidItem.setCurrentPrice(newCurrentBid);
      session.merge(bidItem);
    }
  }

  private void createSingleBidRecord(Bid highBid, Item bidItem) {
    SingleBid newlyPlacedBid = SingleBid.builder()
        .bidAmount(highBid.getCurrentBid())
        .itemId(bidItem.getId())
        .userId(highBid.getUser().getId()).build();
    singleBidRepository.save(newlyPlacedBid);
  }

  private void placeFirstBid(Bid bid, Item bidItem) {
    BigDecimal newCurrentBid = bidItem.getReservePrice().add(new BigDecimal(1));
    bidItem.setCurrentPrice(newCurrentBid);

    Session session = entityManager.unwrap(Session.class);
    session.merge(bidItem);

    bid.setCurrentBid(newCurrentBid);
    session.merge(bid);

    createSingleBidRecord(bid, bidItem);


  }

  private Bid getCompetingBid(Item bidItem) {
    return bidRepository
        .findTopByItemEqualsAndMaxAutoBidAmountGreaterThanOrderByMaxAutoBidAmountDesc(bidItem,
            bidItem.getReservePrice());
  }

  private void notifyUserOfBidStatus(Bid bid) {
    //TODO:  Implement Twillio to text user their bid has been beat
  }

}
