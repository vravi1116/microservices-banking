package com.org.rkv.fund.transfer.controller;
import com.org.rkv.fund.transfer.model.TransferModelDTO;
import com.org.rkv.fund.transfer.service.FundTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FundTransferController {

  @Autowired
  FundTransferService fundTransferService;

  @PostMapping(value = "/api/TransferFunds")
  public ResponseEntity<String> fundTransfer(@RequestBody TransferModelDTO transferModelDTO)
  {
    System.out.println(transferModelDTO);

    if(fundTransferService.trasferFund(transferModelDTO))
       return ResponseEntity.ok("Fund successfully transferred");
    else
      return ResponseEntity.ofNullable("Account information is not correct");
  }
}
