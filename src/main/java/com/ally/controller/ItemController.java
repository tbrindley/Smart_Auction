package com.ally.controller;

import com.ally.model.auctionitem.Item;
import com.ally.model.auctionitem.ItemDescription;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item")
public class ItemController {

  @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<Item> createItem(@RequestBody Item item){
    return new ResponseEntity<>(item, HttpStatus.OK);
  }
}
