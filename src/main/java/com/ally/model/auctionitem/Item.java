package com.ally.model.auctionitem;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Item {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private long id;

  @NotNull
  @Column(nullable = false)
  @Size(max = 64)
  private String itemId;

  @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true)
  @JoinColumn(name = "id")
  ItemDescription itemDescription;

  @OneToOne(mappedBy = "item")
  private AuctionItem auctionItem;

  @Enumerated(EnumType.STRING)
  @Column
  private Status status;

}
