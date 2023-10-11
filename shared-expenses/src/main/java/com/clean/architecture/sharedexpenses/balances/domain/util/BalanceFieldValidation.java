package com.clean.architecture.sharedexpenses.balances.domain.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BalanceFieldValidation {



    //balanceName

    public static final int BALANCE_NAME_MIN_LENGTH = 6;
    public static final int BALANCE_NAME_MAX_LENGTH = 25;

    //balanceDescription

    public static final int BALANCE_DESCRIPTION_MIN_LENGTH = 6;
    public static final int BALANCE_DESCRIPTION_MAX_LENGTH = 50;

}
