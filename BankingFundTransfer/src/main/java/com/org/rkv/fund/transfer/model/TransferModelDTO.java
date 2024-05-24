package com.org.rkv.fund.transfer.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter
public class TransferModelDTO {
  private Double amount;
  private String sender;
  private String recipient;
}
