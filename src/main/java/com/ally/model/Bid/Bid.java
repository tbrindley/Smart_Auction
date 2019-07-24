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
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Data
public class Bid {

  @Id
  @GeneratedValue
  private long id;

  @NotNull
  @Column(nullable = false)
  private BigDecimal maxAutoBidAmount;

  @NotNull
  @Column(nullable = false)
  private BigDecimal currentBid;

  @OneToOne(fetch = FetchType.LAZY)
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  @JoinColumn(name = "fk_user")
  private User user;

  @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true)
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  @JoinColumn(name = "fk_item")
  private Item item;

}
