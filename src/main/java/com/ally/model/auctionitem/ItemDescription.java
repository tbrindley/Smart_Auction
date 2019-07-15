package com.ally.model.auctionitem;


import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ItemDescription {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", updatable = false, nullable = false)
  private long id;

  @NotNull
  @Column(nullable = false)
  @Size(max = 2048)
  private String description;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "itemDescription")
  private Item item;

}
