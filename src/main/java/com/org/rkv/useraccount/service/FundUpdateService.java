package com.org.rkv.useraccount.service;

import com.org.rkv.useraccount.dao.UserDetailsRepository;
import com.org.rkv.useraccount.exception.UserNotFoundException;
import com.org.rkv.useraccount.model.TransferFundDTO;
import com.org.rkv.useraccount.model.UserAccountDetails;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FundUpdateService {
  @Autowired
  UserDetailsRepository repository;
  @Transactional
  public boolean fundUpdate(TransferFundDTO transferFundDTO)
  {

    if(validCustomer(transferFundDTO.getSender()) && validCustomer(transferFundDTO.getRecipient()))
    {
      UserAccountDetails senderUserFromDB = repository.findByEmail(transferFundDTO.getSender());
      // crush the variables of the object found
      senderUserFromDB.setBalance(senderUserFromDB.getBalance()-transferFundDTO.getAmount());
      repository.save(senderUserFromDB);


      UserAccountDetails receiverUserFromDB = repository.findByEmail(transferFundDTO.getRecipient());
      // crush the variables of the object found
      receiverUserFromDB.setBalance(senderUserFromDB.getBalance()+transferFundDTO.getAmount());
      repository.save(receiverUserFromDB);

      return false;
    }

    return false;
  }
  public boolean validCustomer(String email)
  {
    String ExceptionStr="No bank account found for this email : "+email;
    try {
      if(repository.findByEmail(email)!=null)
      return true;
      else
        throw new UserNotFoundException(ExceptionStr);
    }
    catch (Exception exception)
    {
      throw new UserNotFoundException(ExceptionStr,exception);
    }
  }
}
