package com.ally.service.impl;

import com.ally.exception.RecordNotFoundException;
import com.ally.model.auctionitem.Item;
import com.ally.model.auctionitem.Status;
import com.ally.repository.ItemRepository;
import com.ally.service.ItemService;
import java.util.Optional;
import javax.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service
public class ItemServiceImpl implements ItemService {

  @Autowired
  private ItemRepository itemRepository;

  @Autowired
  EntityManager entityManager;

  private static final Logger logger = LoggerFactory.getLogger(ItemServiceImpl.class);

  @Override
  public ResponseEntity<Item> addItem(Item item) {
    StopWatch stopWatch = new StopWatch("Add Item");
    stopWatch.start("Saving Item " + item.getItemName());
    Item savedItem = itemRepository.save(item);
    stopWatch.stop();
    logger.info("\nSaved Item {}: \n{}", item.getId(), stopWatch.prettyPrint());

    return new ResponseEntity<>(savedItem, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<String> deleteItem(long id) throws RecordNotFoundException {
    StopWatch stopWatch = new StopWatch("Delete Item");
    stopWatch.start("Deleting Item " + id);
    Optional<Item> item = itemRepository.findById(id);
    if (item.isPresent()) {
      Item retreivedItem = item.get();
      retreivedItem.setStatus(Status.DELETED);
      itemRepository.save(retreivedItem);
      stopWatch.stop();
      logger.info("\nSuccessfully Deleted item: {}\n{}" + retreivedItem.getId(),
          stopWatch.prettyPrint());
      return new ResponseEntity<>("Item was successfully deleted", HttpStatus.OK);
    }
    stopWatch.stop();
    logger.warn("Item {} was not found \n{}", id, stopWatch.prettyPrint());
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

  @Override
  public ResponseEntity<Page<Item>> searchItems() {

    //TODO: add search criteria.  explorer criteria vs query vs scrollable;
/*    Session session = entityManager.unwrap(Session.class);
    Query query = session.createQuery("from Item where itemName like something");
    query.getResultList();*/

    Page<Item> page = itemRepository.findAll(
        PageRequest.of(0, 10,
            Sort.by(Direction.DESC, "id")));

    return new ResponseEntity<>(page, HttpStatus.OK);
  }
}
