package com.ally.controller;

import com.ally.model.Bid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bids")
public class BidController {

  @PostMapping
  public ResponseEntity placeBid(@RequestBody Bid bid) {
    return new ResponseEntity(HttpStatus.OK);
  }

}
