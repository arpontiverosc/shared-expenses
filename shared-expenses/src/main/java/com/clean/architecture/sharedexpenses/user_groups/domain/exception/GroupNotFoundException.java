package com.clean.architecture.sharedexpenses.user_groups.domain.exception;


import com.clean.architecture.sharedexpenses.common.exception.NotFoundException;
import com.clean.architecture.sharedexpenses.user_groups.domain.util.GroupErrorCode;

public class GroupNotFoundException extends NotFoundException {

  public GroupNotFoundException() {
    super(GroupErrorCode.NOT_FOUND);
  }
}
