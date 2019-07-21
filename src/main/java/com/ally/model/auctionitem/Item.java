package com.ally.model.auctionitem;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
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
  private long id;

  @NotNull
  @Column(nullable = false)
  @Size(max = 64)
  private String itemId;

  @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true)
  @MapsId
  ItemDescription itemDescription;

  @Enumerated(EnumType.STRING)
  @Column
  private Status status;

}
