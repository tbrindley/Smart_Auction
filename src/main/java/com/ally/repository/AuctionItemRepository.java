package com.ally.repository;

import com.ally.model.auctionitem.AuctionItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuctionItemRepository extends JpaRepository<AuctionItem,Long> {

}
