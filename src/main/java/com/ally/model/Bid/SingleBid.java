package com.ally.model.Bid;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Builder;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Builder
public class SingleBid {

  @Id
  @GeneratedValue
  long id;

  @Column
  BigDecimal bidAmount;

  @Column
  long userId;

  @Column
  long itemId;

  @CreationTimestamp
  private LocalDateTime createDateTime;
}
