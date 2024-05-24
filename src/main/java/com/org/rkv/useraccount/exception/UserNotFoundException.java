package com.org.rkv.useraccount.exception;

public class UserNotFoundException extends RuntimeException{
  public UserNotFoundException(String description,Exception ex)
  {
    super(description,ex);
  }
  public UserNotFoundException(String description)
  {
    super(description);
  }
}
