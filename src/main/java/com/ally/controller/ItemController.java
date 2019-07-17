package com.ally.controller;

import com.ally.model.auctionitem.Item;
import com.ally.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item")
public class ItemController {

  @Autowired
  ItemService itemService;

  @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<Item> createItem(@RequestBody Item item) {
    return itemService.addItem(item);
  }
}
