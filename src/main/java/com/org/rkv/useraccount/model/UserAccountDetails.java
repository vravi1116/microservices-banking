package com.org.rkv.useraccount.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter@Setter
@ToString
@NoArgsConstructor
public class UserAccountDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long userId;

  private String name;

  @Column(unique=true)
  private String email;

  private String password;

  private Double balance;
}
