package com.ally.model;

import com.ally.model.auctionitem.AuctionItem;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Bid {

  @Id
  private long id;

  @NotNull
  @Column(nullable = false)
  private BigDecimal currentBidAmount;

  @NotNull
  @Column(nullable = false)
  private BigDecimal maxAutoBidAmount;

  //one to one between bid & user eventually
  @NotNull
  private String user;

  @OneToOne(fetch = FetchType.LAZY)
  @PrimaryKeyJoinColumn(name = "id")
  private AuctionItem auctionItem;

  @CreationTimestamp
  @Column(nullable = false)
  private LocalDateTime createDateTime;

  @UpdateTimestamp
  @Column(nullable = false)
  private LocalDateTime updateDateTime;
}
