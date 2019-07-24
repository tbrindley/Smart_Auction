package com.ally.controller;

import com.ally.model.Bid.Bid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bids")
public class BidController {

  @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity placeBid(@RequestBody Bid bid) {
    return new ResponseEntity(HttpStatus.OK);
  }

}
