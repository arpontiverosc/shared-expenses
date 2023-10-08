package com.clean.architecture.sharedexpenses.balances.infrastructure.in.rest.v1.mapper.response;

import com.clean.architecture.sharedexpenses.balances.domain.model.Expense;
import com.clean.architecture.sharedexpenses.balances.infrastructure.in.rest.v1.model.response.AddExpenseToBalanceResponse;

public class AddExpenseToBalanceResponseMapper {
    public static AddExpenseToBalanceResponse from(Expense expense) {
        AddExpenseToBalanceResponse addExpenseToBalanceResponse = new AddExpenseToBalanceResponse();
        addExpenseToBalanceResponse.setId(expense.g);


    }
}
