package com.clean.architecture.sharedexpenses.user_groups.domain.exception;


import com.clean.architecture.sharedexpenses.common.exception.BusinessValidationException;
import com.clean.architecture.sharedexpenses.common.exception.NotFoundException;
import com.clean.architecture.sharedexpenses.user_groups.domain.util.UserErrorCode;

public class UserNameUsedBadRequestException extends BusinessValidationException {

  public UserNameUsedBadRequestException() {
    super(UserErrorCode.USER_NAME_REPEATED);
  }
}
