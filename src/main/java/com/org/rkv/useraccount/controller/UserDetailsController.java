package com.org.rkv.useraccount.controller;
import com.org.rkv.useraccount.model.TransferFundDTO;
import com.org.rkv.useraccount.model.UserAccountDetails;
import com.org.rkv.useraccount.model.UserDetailsDTO;
import com.org.rkv.useraccount.service.FundUpdateService;
import com.org.rkv.useraccount.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserDetailsController {

  @Autowired
  UserDetailsService service;

  @Autowired
  FundUpdateService fundUpdateService;

  @PostMapping(value = "/api/registerUser")
  public ResponseEntity<UserAccountDetails> createUser(@RequestBody UserDetailsDTO userDetailsDTO)
  {
    System.out.println(userDetailsDTO);
    return ResponseEntity.ok(service.saveUserDetails(userDetailsDTO));
  }
  @PutMapping(value = "/api/updateUserBalance")
  public ResponseEntity<Boolean> updateUserBalance(@RequestBody TransferFundDTO transferFundDTO)
  {
    System.out.println(transferFundDTO);
    return ResponseEntity.ok(fundUpdateService.fundUpdate(transferFundDTO));
  }
}
