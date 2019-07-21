package com.ally.service.impl;

import com.ally.exception.RecordNotFoundException;
import com.ally.model.auctionitem.Item;
import com.ally.model.auctionitem.Status;
import com.ally.repository.ItemDescriptionRepository;
import com.ally.repository.ItemRepository;
import com.ally.service.ItemService;
import java.util.Optional;
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

    logger.info("Saving Item: " + item.getItemId());
    Item savedItem = itemRepository.save(item);
    logger.info("SUCCESSFULLY SAVED: " + savedItem.getId());
    return new ResponseEntity<>(savedItem, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<String> deleteItem(long id) throws RecordNotFoundException {
    logger.info("Searching for Item Id:  " + id);
    Optional<Item> item = itemRepository.findById(id);

    if (item.isPresent()) {
      Item retreivedItem = item.get();
      retreivedItem.setStatus(Status.DELETED);
      itemRepository.save(retreivedItem);
      logger.info("SUCCESSFULLY DELETED: " + retreivedItem.getId());

      return new ResponseEntity<>("Item was successfully deleted", HttpStatus.OK);
    }
    throw new RecordNotFoundException(id, "Item");
  }

  @Override
  public ResponseEntity<Item> getItem(long id) throws RecordNotFoundException {
    logger.info("Searching for ITEM ID:  " + id);
    Optional<Item> item = itemRepository.findById(id);

    if (item.isPresent()) {
      Item retreivedItem = item.get();
      logger.info("SUCCESSFULLY RETRIEVED: " + retreivedItem.getId());

      return new ResponseEntity<>(retreivedItem, HttpStatus.OK);
    } else {
      throw new RecordNotFoundException(id, "Item");
    }
  }
}