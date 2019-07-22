package com.ally.service.impl;

import com.ally.exception.RecordNotFoundException;
import com.ally.model.auctionitem.Item;
import com.ally.model.auctionitem.Status;
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
  private ItemRepository itemRepository;

  private static final Logger logger = LoggerFactory.getLogger(ItemServiceImpl.class);

  @Override
  public ResponseEntity<Item> addItem(Item item) {
    long startTime = System.currentTimeMillis();
    logger.info("Saving Item: {}", item.getItemId());
    Item savedItem = itemRepository.save(item);
    long elapsedTime = System.currentTimeMillis() - startTime;
    logger.info("Successfully saved item: {} in {} ms", savedItem.getId(), elapsedTime);
    return new ResponseEntity<>(savedItem, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<String> deleteItem(long id) throws RecordNotFoundException {
    long startTime = System.currentTimeMillis();
    logger.info("Searching for Item Id:  " + id);
    Optional<Item> item = itemRepository.findById(id);

    if (item.isPresent()) {
      Item retreivedItem = item.get();
      retreivedItem.setStatus(Status.DELETED);
      itemRepository.save(retreivedItem);
      long elapsedTime = System.currentTimeMillis() - startTime;
      logger.info("Successfully Deleted item: {} in {} ms" + retreivedItem.getId(), elapsedTime);

      return new ResponseEntity<>("Item was successfully deleted", HttpStatus.OK);
    }
    logger.warn("Item {} was not found", id);
    throw new RecordNotFoundException(id, "Item");
  }

  @Override
  public ResponseEntity<Item> getItem(long id) throws RecordNotFoundException {
    long startTime = System.currentTimeMillis();
    logger.info("Getting item: {} ", id);
    Optional<Item> item = itemRepository.findById(id);
    if (item.isPresent()) {
      long elapsedTime = System.currentTimeMillis() - startTime;
      logger.info("Successfully Retrieved item: {} in {} ms", id, elapsedTime);
      return new ResponseEntity<>(item.get(), HttpStatus.OK);
    } else {
      logger.warn("Item {} was not found.", id);
      throw new RecordNotFoundException(id, "Item");
    }
  }
}
