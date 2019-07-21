package com.ally.controller;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.ally.model.auctionitem.Item;
import com.ally.model.auctionitem.ItemDescription;
import com.ally.model.auctionitem.Status;
import com.ally.service.impl.ItemServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(MockitoJUnitRunner.class)
public class ItemControllerTest {

  @Mock
  private ItemServiceImpl itemService;

  @Mock
  private ItemController itemController;

  private MockMvc mockMvc;
  private ObjectMapper objectMapper = new ObjectMapper();

  @Before
  public void setUp() {
    mockMvc = MockMvcBuilders.standaloneSetup(itemController).build();
  }

  @Test
  public void whenReceivingASuccessfulItemRequestAndReturnsA200Response() throws Exception {
    Item mockItem = Item.builder()
        .itemId("itemID")
        .itemDescription(new ItemDescription())
        .status(Status.ACTIVE)
        .build();

    String jsonString = objectMapper.writeValueAsString(mockItem);

    when(itemService.addItem(mock(Item.class))).thenReturn(mock(ResponseEntity.class));

    mockMvc.perform(post("/item")
        .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
        .content(jsonString))
        .andExpect(status().isOk());
  }

  @Test
  public void whenReceivingAnInvalidRequestToCraeteAnItemAndReturnsA400Response() throws Exception {
    when(itemService.addItem(mock(Item.class))).thenReturn(mock(ResponseEntity.class));

    mockMvc.perform(post("/item")
        .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
        .content("INVALIDREQUEST"))
        .andExpect(status().isBadRequest());
  }
  //successful get request

  //invalid get request

  //successful delete request

  //invalid delete request

}
