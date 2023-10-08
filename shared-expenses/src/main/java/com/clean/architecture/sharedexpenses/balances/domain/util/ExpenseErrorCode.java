package com.clean.architecture.sharedexpenses.balances.domain.util;

public class ExpenseErrorCode {

    //userId
    public static final String EXPENSE_USER_ID_MANDATORY = "expense.userId.mandatory";

    //groupId
    public static final String EXPENSE_GROUP_ID_MANDATORY = "expense.groupId.mandatory";

    //price
    public static final String EXPENSE_PRICE_MANDATORY = "expense.price.mandatory";

    //currency
    public static final String EXPENSE_CURRENCY_MANDATORY = "expense.currency.mandatory";

    //description
    public static final String EXPENSE_DESCRIPTION_MANDATORY = "expense.description.mandatory";
    public static final String EXPENSE_DESCRIPTION_MIN_LENGTH = "expense.description.minLength";
    public static final String EXPENSE_DESCRIPTION_MAX_LENGTH = "expense.description.maxLength";
}
