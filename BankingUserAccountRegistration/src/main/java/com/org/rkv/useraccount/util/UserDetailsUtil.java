package com.org.rkv.useraccount.util;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsUtil {

  public static boolean emailValidation(String email)
  {
    EmailValidator emailValidator=EmailValidator.getInstance();
    return emailValidator.isValid(email);
  }



}
