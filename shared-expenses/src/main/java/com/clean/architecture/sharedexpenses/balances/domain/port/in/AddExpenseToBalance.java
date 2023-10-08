package com.clean.architecture.sharedexpenses.balances.domain.port.in;

import com.clean.architecture.sharedexpenses.balances.domain.model.Expense;
import com.clean.architecture.sharedexpenses.balances.domain.port.in.model.AddExpenseToBalanceCommand;


public interface AddExpenseToBalance {
    Expense execute(AddExpenseToBalanceCommand from);
}
