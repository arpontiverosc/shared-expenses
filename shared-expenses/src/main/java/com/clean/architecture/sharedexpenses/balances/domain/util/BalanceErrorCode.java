package com.clean.architecture.sharedexpenses.balances.domain.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BalanceErrorCode {

    public static final String NOT_FOUND = "balance.notFound";

    // id
    public static final String ID_MANDATORY = "balance.id.mandatory";

    //balanceName
    public static final String BALANCE_NAME_MANDATORY = "balance.balanceName.mandatory";
    public static final String BALANCE_NAME_MIN_LENGTH = "balance.balanceName.minLength";
    public static final String BALANCE_NAME_MAX_LENGTH = "balance.balanceName.maxLength";

    //balanceDescription
    public static final String BALANCE_DESCRIPTION_MANDATORY = "balance.balanceDescription.mandatory";
    public static final String BALANCE_DESCRIPTION_MIN_LENGTH = "balance.balanceDescription.minLength";
    public static final String BALANCE_DESCRIPTION_MAX_LENGTH = "balance.balanceDescription.maxLength";

    //balanceGroup
    public static final String BALANCE_GROUP_ID_MANDATORY = "balance.groupId.mandatory";

}
