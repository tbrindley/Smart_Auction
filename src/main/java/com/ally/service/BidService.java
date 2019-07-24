package com.ally.service;

import com.ally.exception.InvalidMaxBidException;
import com.ally.model.Bid.Bid;
import org.springframework.http.ResponseEntity;

public interface BidService {

  ResponseEntity<String> placeBid(Bid bid) throws InvalidMaxBidException;

}
