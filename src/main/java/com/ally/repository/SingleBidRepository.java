package com.ally.repository;

import com.ally.model.Bid.SingleBid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SingleBidRepository extends JpaRepository<SingleBid,Long>  {

}
