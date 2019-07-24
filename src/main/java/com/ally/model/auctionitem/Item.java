package com.ally.model.auctionitem;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Item {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @NotNull
  @Column(nullable = false)
  @Size(max = 64)
  private String itemName;

  @NotNull
  @Column
  private BigDecimal reservePrice;

  @NotNull
  @Column
  private BigDecimal currentPrice;

  @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true)
  @MapsId
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  ItemDescription itemDescription;

  @CreationTimestamp
  private LocalDateTime createDateTime;

  @UpdateTimestamp
  private LocalDateTime updateDateTime;

  @Enumerated(EnumType.STRING)
  @Column
  private Status status;

}
