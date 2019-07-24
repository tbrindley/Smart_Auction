package com.ally.model.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", updatable = false, nullable = false)
  private long id;

  @NotNull
  @Column(nullable = false)
  @Size(max = 64)
  private String name;

/*  @Size(max = 64)
  private String middleName;

  @NotNull
  @Column(nullable = false)
  @Size(max = 64)
  private String lastName;*/

/*  //Address one to one
  private Set<Address> addresses;

  private Set<Phone> phones;

  //source of payment one to many
  private Set<Payment> payments;

  //bid history one to many
  private Set<Bid> bids;*/
}
