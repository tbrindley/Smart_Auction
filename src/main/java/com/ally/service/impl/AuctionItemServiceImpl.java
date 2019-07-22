/*
package com.ally.service.impl;

import com.ally.exception.RecordNotFoundException;
import com.ally.model.SearchAuctionItems;
import com.ally.model.auctionitem.AuctionItem;
import com.ally.service.AuctionItemService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AuctionItemServiceImpl implements AuctionItemService {

  @Autowired
  AuctionItemService auctionItemService;

  private static final Logger logger = LoggerFactory.getLogger(AuctionItemServiceImpl.class);


  @Override
  public ResponseEntity<AuctionItem> getAuctionItem(long id) throws RecordNotFoundException {
    long startTime = System.currentTimeMillis();
    logger.info("Getting Auction Item: " + id);

    return null;
  }

  @Override
  public ResponseEntity<AuctionItem> addAuctionItem(AuctionItem auctionItem) {
    return null;
  }

  @Override
  public ResponseEntity<String> deleteAuctionItem(long id) throws RecordNotFoundException {
    return null;
  }

  @Override
  public ResponseEntity<List<AuctionItem>> getAuctionItems(SearchAuctionItems searchAuctionItems)
      throws RecordNotFoundException {
    return null;
  }
}
*/
