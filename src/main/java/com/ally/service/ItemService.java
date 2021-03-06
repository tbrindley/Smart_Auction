package com.ally.service;


import com.ally.exception.RecordNotFoundException;
import com.ally.model.auctionitem.Item;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

public interface ItemService {

  ResponseEntity<Item> addItem(Item item);

  ResponseEntity<String> deleteItem(long id) throws RecordNotFoundException;

  ResponseEntity<Item> getItem(long id) throws RecordNotFoundException;

  ResponseEntity<Page<Item>> searchItems();
}
