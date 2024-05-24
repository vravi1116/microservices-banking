package com.org.rkv.useraccount.service;

import com.org.rkv.useraccount.config.JasyptEncryptorConfig;
import com.org.rkv.useraccount.dao.UserDetailsRepository;
import com.org.rkv.useraccount.exception.ErrorResponse;
import com.org.rkv.useraccount.exception.InvalidEmailException;
import com.org.rkv.useraccount.model.UserAccountDetails;
import com.org.rkv.useraccount.model.UserDetailsDTO;
import com.org.rkv.useraccount.util.UserDetailsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService {
  @Autowired
  private UserDetailsRepository userDetailsRepository;

  @Autowired
  private JasyptEncryptorConfig jasyptEncryptorConfig;

  public UserAccountDetails saveUserDetails(UserDetailsDTO userDetailsDTO)
  {
    UserAccountDetails userAccountDetails =new UserAccountDetails();
    userAccountDetails.setName(userDetailsDTO.getName());
    userAccountDetails.setPassword(jasyptEncryptorConfig.getPasswordEncryptor().encrypt(userDetailsDTO.getPassword()));

    if(UserDetailsUtil.emailValidation(userDetailsDTO.getEmail()))
      userAccountDetails.setEmail(userDetailsDTO.getEmail());
    else
      throw new InvalidEmailException(new ErrorResponse(1002,"Invalid email id"));

   return userDetailsRepository.save(userAccountDetails);
  }

}
