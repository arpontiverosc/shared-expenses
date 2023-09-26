package com.clean.architecture.sharedexpenses.user_groups.domain.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserErrorCode {

    public static final String NOT_FOUND = "user.notFound";

    // id
    public static final String ID_MANDATORY = "user.id.mandatory";

    //userName
    public static final String USER_NAME_MANDATORY = "user.userName.mandatory";
    public static final String USER_NAME_REPEATED = "user.userName.repeated";
    public static final String USER_NAME_MIN_LENGTH = "user.userName.minLength";
    public static final String USER_NAME_MAX_LENGTH = "user.userName.maxLength";

    // lastName

    // firstName
    public static final String FIRST_NAME_MANDATORY = "user.firstName.mandatory";
    public static final String FIRST_NAME_MIN_LENGTH = "user.firstName.minLength";
    public static final String FIRST_NAME_MAX_LENGTH = "user.firstName.maxLength";

    // lastName
    public static final String LAST_NAME_MANDATORY = "user.lastName.mandatory";
    public static final String LAST_NAME_MIN_LENGTH = "user.lastName.minLength";
    public static final String LAST_NAME_MAX_LENGTH = "user.lastName.maxLength";

    // email
    public static final String EMAIL_MANDATORY = "user.email.mandatory";
    public static final String EMAIL_MIN_LENGTH = "user.email.minLength";
    public static final String EMAIL_MAX_LENGTH = "user.email.maxLength";


}
