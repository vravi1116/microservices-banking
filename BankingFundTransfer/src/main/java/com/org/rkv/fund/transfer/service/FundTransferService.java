package com.org.rkv.fund.transfer.service;

import com.org.rkv.fund.transfer.exception.ErrorResponse;
import com.org.rkv.fund.transfer.exception.InvalidEmailException;
import com.org.rkv.fund.transfer.exception.TransactionFailedException;
import com.org.rkv.fund.transfer.model.TransferModelDTO;
import com.org.rkv.fund.transfer.util.UserDetailsUtil;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FundTransferService {

  private String payerEmail;
  private String receiverEmail;

  public boolean trasferFund(TransferModelDTO transferModelDTO)
  {

    try {
      validateUserByEmail(transferModelDTO);
      updateBalance(transferModelDTO);
    }catch (Exception ex)
    {
      ex.printStackTrace();
      throw new TransactionFailedException("Failed in Transaction");
    }

   return true;
  }

  private void validateUserByEmail(TransferModelDTO transferModelDTO) {
    if (!UserDetailsUtil.emailValidation(transferModelDTO.getSender())
        && !UserDetailsUtil.emailValidation(transferModelDTO.getRecipient())) {
      throw new InvalidEmailException(new ErrorResponse(1002, "Invalid Email id"));
    }
  }

  private void updateBalance(TransferModelDTO transferModelDTO)
  {
    Map<String, String> params = new HashMap<String, String>();
    new RestTemplate().put(
          "http://localhost:8083/api/updateUserBalance",
           transferModelDTO,params);
    System.out.println("Rest call complete");
  }
}
