package com.ally.service;


import com.ally.exception.RecordNotFoundException;
import com.ally.model.auctionitem.Item;
import org.springframework.http.ResponseEntity;

public interface ItemService {

  ResponseEntity<Item> addItem(Item item);

  ResponseEntity<String> deleteItem(long id);

  ResponseEntity<Item> getItem(long id) throws RecordNotFoundException;
}
