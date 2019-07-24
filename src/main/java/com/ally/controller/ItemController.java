package com.ally.controller;

import com.ally.exception.RecordNotFoundException;
import com.ally.model.auctionitem.Item;
import com.ally.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auction-items")
public class ItemController {

  @Autowired
  private ItemService itemService;

  @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<Item> createItem(@RequestBody Item item) {
    return itemService.addItem(item);
  }

  @GetMapping(value = "/search", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<Page<Item>> getItems(){
    return itemService.searchItems();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Item> getItem(@PathVariable("id") long id) throws RecordNotFoundException {
    return itemService.getItem(id);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteItem(@PathVariable("id") long id) throws RecordNotFoundException {
    return itemService.deleteItem(id);
  }
}
