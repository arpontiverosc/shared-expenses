package com.clean.architecture.sharedexpenses.user_groups.domain.exception;


import com.clean.architecture.sharedexpenses.balances.domain.util.GroupErrorCode;
import com.clean.architecture.sharedexpenses.common.exception.NotFoundException;


public class GroupNotFoundException extends NotFoundException {

  public GroupNotFoundException() {
    super(GroupErrorCode.NOT_FOUND);
  }
}
