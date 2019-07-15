package com.ally.controller;

import com.ally.model.auctionitem.AuctionItem;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auction-items")
public class AuctionItemController {

  @PostMapping()
  public ResponseEntity<AuctionItem> createNewAuctionItem(AuctionItem auctionItem) {
    return new ResponseEntity(HttpStatus.OK);
  }

  @GetMapping()
  public ResponseEntity<String> getMappingTest() {
    return new ResponseEntity("I'm a Get Test",HttpStatus.OK);
  }

}
