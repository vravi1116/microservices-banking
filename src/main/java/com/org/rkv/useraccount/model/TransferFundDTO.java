package com.org.rkv.useraccount.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class TransferFundDTO {
  private Double amount;
  private String sender;
  private String recipient;
}
