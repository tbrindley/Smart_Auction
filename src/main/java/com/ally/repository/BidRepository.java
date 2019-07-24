package com.ally.repository;


import com.ally.model.Bid.Bid;
import com.ally.model.auctionitem.Item;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BidRepository extends JpaRepository<Bid, Long> {

  List<Bid> findAllByItemEqualsAndMaxAutoBidAmountGreaterThan(Item item,
      BigDecimal reservedPrice);
}
