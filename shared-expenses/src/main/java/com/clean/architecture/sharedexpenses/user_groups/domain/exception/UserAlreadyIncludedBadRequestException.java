package com.clean.architecture.sharedexpenses.user_groups.domain.exception;


import com.clean.architecture.sharedexpenses.common.exception.BusinessValidationException;
import com.clean.architecture.sharedexpenses.user_groups.domain.util.GroupErrorCode;

public class UserAlreadyIncludedBadRequestException extends BusinessValidationException {

    public UserAlreadyIncludedBadRequestException() {
        super(GroupErrorCode.USER_ALREADY_INCLUDED);
    }
}
