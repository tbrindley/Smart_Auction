package com.ally.exception;

import java.math.BigDecimal;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.EXPECTATION_FAILED, reason = "Reserved bid price was not met")
public class InvalidMaxBidException extends Exception {

  public InvalidMaxBidException(BigDecimal userMaxBid, BigDecimal reservedPrice) {
    super("Your max bid of $" + userMaxBid + "is not greater than the items reserved price:  $"
        + reservedPrice);
  }
}
