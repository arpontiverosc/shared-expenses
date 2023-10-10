package com.clean.architecture.sharedexpenses.balances.domain.exception;


import com.clean.architecture.sharedexpenses.balances.domain.util.UserErrorCode;
import com.clean.architecture.sharedexpenses.common.exception.NotFoundException;


public class UserNotFoundException extends NotFoundException {

    public UserNotFoundException() {
        super(UserErrorCode.NOT_FOUND);
    }
}

