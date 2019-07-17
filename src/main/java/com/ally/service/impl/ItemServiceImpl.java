package com.ally.service.impl;

import com.ally.exception.RecordNotFoundException;
import com.ally.model.auctionitem.Item;
import com.ally.model.auctionitem.ItemDescription;
import com.ally.repository.ItemDescriptionRepository;
import com.ally.repository.ItemRepository;
import com.ally.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

  @Autowired
  ItemRepository itemRepository;
  @Autowired
  ItemDescriptionRepository itemDescriptionRepository;

  private static final Logger logger = LoggerFactory.getLogger(ItemServiceImpl.class);

  @Override
  public ResponseEntity<Item> addItem(Item item) {

   ItemDescription newDescription = itemDescriptionRepository.save(item.getItemDescription());
    item.setItemDescription(newDescription);
    logger.info("Saving Item: " + item.getItemId());
    Item savedItem = itemRepository.save(item);
    logger.info("SUCCESSFULLY SAVED: " + savedItem.getId());
    return new ResponseEntity<>(savedItem, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<String> deleteItem(long id) {
    return null;
  }

  @Override
  public ResponseEntity<Item> getItem(long id) throws RecordNotFoundException {
    return null;
  }
}
