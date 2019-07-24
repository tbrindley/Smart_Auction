package com.ally.service;

import com.ally.exception.RecordNotFoundException;
import com.ally.model.Bid.SingleBid;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

public interface SingleBidService {

  void placeSingleBid(SingleBid singleBid);

  ResponseEntity<String> deleteBid(long id) throws RecordNotFoundException;

  ResponseEntity<SingleBid> getSingleBid(long id) throws RecordNotFoundException;

  ResponseEntity<Page<SingleBid>> searchSingleBids();
}
