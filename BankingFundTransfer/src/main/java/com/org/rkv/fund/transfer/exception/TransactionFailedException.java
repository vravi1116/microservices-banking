package com.org.rkv.fund.transfer.exception;

public class TransactionFailedException extends RuntimeException{
  public TransactionFailedException(String discription,Exception ex)
  {
    super(discription,ex);
  }

  public TransactionFailedException(String discription)
  {
    super(discription);
  }
}
