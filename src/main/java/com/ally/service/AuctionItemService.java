package com.ally.service;


import com.ally.exception.RecordNotFoundException;
import com.ally.model.SearchAuctionItems;
import com.ally.model.auctionitem.AuctionItem;
import java.util.List;
import org.springframework.http.ResponseEntity;


public interface AuctionItemService {

  ResponseEntity<AuctionItem> getAuctionItem(long id) throws RecordNotFoundException;

  ResponseEntity<AuctionItem> addAuctionItem(AuctionItem auctionItem);

  ResponseEntity<String> deleteAuctionItem(long id) throws RecordNotFoundException;

  ResponseEntity<List<AuctionItem>> getAuctionItems(SearchAuctionItems searchAuctionItems)
      throws RecordNotFoundException;

}
