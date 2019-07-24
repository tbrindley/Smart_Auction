package com.ally.model.Bid;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

public class SingleBid {

  @Id
  @GeneratedValue
  long id;

  @Column
  BigDecimal currentBidAmount;

  @ManyToOne
  @JoinColumn(name = "id")
  Bid bid;

  @CreationTimestamp
  private LocalDateTime createDateTime;

  @UpdateTimestamp
  private LocalDateTime updateDateTime;
}
