package com.clean.architecture.sharedexpenses.user_groups.domain.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserFieldValidation {

    // id

    //userName

    public static final int USER_NAME_MIN_LENGTH = 6;
    public static final int USER_NAME_MAX_LENGTH = 50;

    // firstName
    public static final int FIRST_NAME_MIN_LENGTH = 3;
    public static final int FIRST_NAME_MAX_LENGTH = 50;

    // lastName
    public static final int LAST_NAME_MIN_LENGTH = 3;
    public static final int LAST_NAME_MAX_LENGTH = 50;

    // email
    public static final int EMAIL_MIN_LENGTH = 3;
    public static final int EMAIL_MAX_LENGTH = 100;

}
