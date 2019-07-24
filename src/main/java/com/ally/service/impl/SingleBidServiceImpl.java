package com.ally.service.impl;

import com.ally.exception.RecordNotFoundException;
import com.ally.model.Bid.SingleBid;
import com.ally.repository.SingleBidRepository;
import com.ally.service.SingleBidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SingleBidServiceImpl implements SingleBidService {

  @Autowired
  SingleBidRepository singleBidRepository;

  @Override
  public void placeSingleBid(SingleBid singleBid) {
    singleBidRepository.save(singleBid);
  }

  @Override
  public ResponseEntity<String> deleteBid(long id) throws RecordNotFoundException {
    return null;
  }

  @Override
  public ResponseEntity<SingleBid> getSingleBid(long id) throws RecordNotFoundException {
    return null;
  }

  @Override
  public ResponseEntity<Page<SingleBid>> searchSingleBids() {
    return null;
  }
}
