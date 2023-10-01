package com.clean.architecture.sharedexpenses.user_groups.domain.exception;


import com.clean.architecture.sharedexpenses.common.exception.BusinessValidationException;
import com.clean.architecture.sharedexpenses.user_groups.domain.util.GroupErrorCode;

public class GroupNameUsedBadRequestException extends BusinessValidationException {

    public GroupNameUsedBadRequestException() {
        super(GroupErrorCode.GROUP_NAME_REPEATED);
    }
}
