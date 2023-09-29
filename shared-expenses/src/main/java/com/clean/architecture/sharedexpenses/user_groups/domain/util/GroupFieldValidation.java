package com.clean.architecture.sharedexpenses.user_groups.domain.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GroupFieldValidation {

    // id

    //groupName

    public static final int GROUP_NAME_MIN_LENGTH = 6;
    public static final int GROUP_NAME_MAX_LENGTH = 25;


}
