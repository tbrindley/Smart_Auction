package com.ally.model.Bid;

import com.ally.model.auctionitem.Item;
import com.ally.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
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
  private BigDecimal maxAutoBidAmount;

  @OneToOne(fetch = FetchType.LAZY)
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  private User user;

  @OneToOne(fetch = FetchType.LAZY)
  @PrimaryKeyJoinColumn(name = "id")
  private Item item;

  @OneToMany(mappedBy = "bid")
  List<SingleBid> bids;
}
