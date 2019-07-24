package com.ally.model;

import java.math.BigDecimal;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchAuctionItems {

  String name;

  BigDecimal minReserveAmount;

  BigDecimal maxReserveAmount;
}
