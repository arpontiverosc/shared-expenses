package com.clean.architecture.sharedexpenses.user_groups.domain.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GroupErrorCode {

    // id
    public static final String ID_MANDATORY = "group.id.mandatory";

    public static final String NOT_FOUND = "group.notFound";

    //groupName
    public static final String GROUP_NAME_MANDATORY = "group.groupName.mandatory";
    public static final String GROUP_NAME_MIN_LENGTH = "group.groupName.minLength";
    public static final String GROUP_NAME_MAX_LENGTH = "group.groupName.maxLength";
    public static final String GROUP_NAME_REPEATED = "group.groupName.repeated";

    //user
    public static final String USER_ALREADY_INCLUDED = "group.user.included";;
}
