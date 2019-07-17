package com.ally.model.auctionitem;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "Auction_Item")
@AllArgsConstructor
@Getter
@Setter
@Builder
public class AuctionItem {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", updatable = false, nullable = false)
  private long id;

  @NotNull
  private BigDecimal reservePrice;

  @NotNull
  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id")
  private Item item;

  @CreationTimestamp
  @Column(nullable = false)
  private LocalDateTime createDateTime;

  @UpdateTimestamp
  @Column(nullable = false)
  private LocalDateTime updateDateTime;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private Status status = Status.PENDING_LISTING;
}
