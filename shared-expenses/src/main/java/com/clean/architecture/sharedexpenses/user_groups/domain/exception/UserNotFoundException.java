package com.clean.architecture.sharedexpenses.user_groups.domain.exception;


import com.clean.architecture.sharedexpenses.common.exception.NotFoundException;
import com.clean.architecture.sharedexpenses.user_groups.domain.util.UserErrorCode;

public class UserNotFoundException extends NotFoundException {

  public UserNotFoundException() {
    super(UserErrorCode.NOT_FOUND);
  }
}
