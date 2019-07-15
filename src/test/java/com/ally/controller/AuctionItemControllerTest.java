package com.ally.controller;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.ally.model.auctionitem.AuctionItem;
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
public class AuctionItemControllerTest {

  @Mock
  AuctionItemController auctionItemController;

  private MockMvc mockMvc;
  private ObjectMapper objectMapper = new ObjectMapper();
  private AuctionItem auctionItem;

  @Before
  public void setUp() {
    mockMvc = MockMvcBuilders.standaloneSetup(auctionItemController).build();
  }

  @Test
  public void auctionControllerReceivesAValidPostRequestAndReturnsA200Response()
      throws Exception {
    when(auctionItemController.createNewAuctionItem(mock(AuctionItem.class)))
        .thenReturn(mock(ResponseEntity.class));

    mockMvc.perform(post("/auction-items")
        .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
        .content("")
    )
        .andExpect(status().is2xxSuccessful());
  }
}
