package com.ally.controller;

import com.ally.exception.RecordNotFoundException;
import com.ally.model.SearchAuctionItems;
import com.ally.model.auctionitem.AuctionItem;
import com.ally.model.auctionitem.AuctionItems;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auction-items")
public class AuctionItemController {

  @PostMapping()
  public ResponseEntity<AuctionItem> createNewAuctionItem(@RequestBody AuctionItem auctionItem) {
    return new ResponseEntity(HttpStatus.OK);
  }

  @PostMapping("/search")
  public ResponseEntity<AuctionItems> getListOfFilteredAuctionItem(
      @RequestBody SearchAuctionItems searchFilter) {
    return null;
  }

  @GetMapping("/{page}")
  public ResponseEntity<AuctionItems> getListOfAuctionItem(@PathVariable("page") long page)
      throws RecordNotFoundException {
    return null;
  }

  @GetMapping("/single-item/{id}")
  public ResponseEntity<AuctionItem> getAuctionItem(@PathVariable("id") long id)
      throws RecordNotFoundException {
    return new ResponseEntity("I'm a Get Test", HttpStatus.OK);
  }

  @DeleteMapping("/single-item/{id}")
  public ResponseEntity<String> deleteAuctionItem(@PathVariable("id") long id)
      throws RecordNotFoundException {
    return new ResponseEntity(HttpStatus.OK);
  }

}
