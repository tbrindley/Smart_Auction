package com.ally.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

public class Bid {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", updatable = false, nullable = false)
  private long id;

  @NotNull
  @Column(nullable = false)
  private BigDecimal bidAmount;

  //one to one between bid & user

  //one to one between bid & item

  @CreationTimestamp
  @Column(nullable = false)
  private LocalDateTime createDateTime;

  @UpdateTimestamp
  @Column(nullable = false)
  private LocalDateTime updateDateTime;
}
