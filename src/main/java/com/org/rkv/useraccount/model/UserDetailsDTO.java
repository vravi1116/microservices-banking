package com.org.rkv.useraccount.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter@Setter
@NoArgsConstructor
@ToString
public class UserDetailsDTO {

  private String name;

  private String email;

  private String password;
}
