package com.ally.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.ally.model.auctionitem.Item;
import com.ally.model.auctionitem.ItemDescription;
import com.ally.model.auctionitem.Status;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(MockitoJUnitRunner.class)
public class ItemControllerTest {

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

    mockMvc.perform(post("/item")
        .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
        .content(jsonString))
        .andExpect(status().isOk());
  }

  @Test
  public void whenReceivingAnInvalidRequestToCreateAnItemAndReturnsA400Response() throws Exception {
    mockMvc.perform(post("/item")
        .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
        .content("INVALIDREQUEST"))
        .andExpect(status().isBadRequest());
  }

  @Test
  public void whenReceivingAValidGetRequestThatReturnsA200Response() throws Exception {
    mockMvc.perform(get("/item/{id}", 1))
        .andExpect(status().isOk());
  }

  @Test
  public void whenReceivingAnInvalidGetRequestThatReturnsA400Response() throws Exception {
    mockMvc.perform(get("/item/{id}", "IM A BAD REQUEST"))
        .andExpect(status().isBadRequest());
  }

  @Test
  public void whenReceivingAValidDeleteRequestThatReturnsA200Response() throws Exception {
    mockMvc.perform(delete("/item/{id}", 1))
        .andExpect(status().isOk());
  }

  @Test
  public void whenReceivingAnInvalidDeleteRequestThatReturnsA400Response() throws Exception {
    mockMvc.perform(delete("/item/{id}", "IM A BAD REQUEST"))
        .andExpect(status().isBadRequest());
  }
}
