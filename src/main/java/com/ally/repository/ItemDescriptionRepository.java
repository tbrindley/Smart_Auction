package com.ally.repository;

import com.ally.model.auctionitem.ItemDescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemDescriptionRepository extends JpaRepository<ItemDescription, Long>{

}
