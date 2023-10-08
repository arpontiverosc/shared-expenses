package com.clean.architecture.sharedexpenses.balances.domain.exception;


import com.clean.architecture.sharedexpenses.balances.domain.util.BalanceErrorCode;
import com.clean.architecture.sharedexpenses.common.exception.NotFoundException;


public class BalanceNotFoundException extends NotFoundException {

  public BalanceNotFoundException() {
    super(BalanceErrorCode.NOT_FOUND);
  }
}
