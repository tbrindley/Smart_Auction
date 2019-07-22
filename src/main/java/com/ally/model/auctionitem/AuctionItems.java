package com.ally.model.auctionitem;

import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class AuctionItems {
  private Set<AuctionItem> data;
  private long elapseTimeMillis;
  private int itemsPerPage = 10;
  private int page;
  private int totalItems;
  private int totalPages;
}
