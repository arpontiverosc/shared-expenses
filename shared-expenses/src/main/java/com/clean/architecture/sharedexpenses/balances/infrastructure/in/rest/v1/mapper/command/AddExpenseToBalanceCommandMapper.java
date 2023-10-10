package com.clean.architecture.sharedexpenses.balances.infrastructure.in.rest.v1.mapper.command;

import com.clean.architecture.sharedexpenses.balances.domain.port.in.model.AddExpenseToBalanceCommand;
import com.clean.architecture.sharedexpenses.balances.infrastructure.in.rest.v1.model.request.AddExpenseToBalanceRequest;


public class AddExpenseToBalanceCommandMapper {


    public static AddExpenseToBalanceCommand from(String balanceId, AddExpenseToBalanceRequest request) {
        AddExpenseToBalanceCommand addExpenseToBalanceCommand = new AddExpenseToBalanceCommand();
        addExpenseToBalanceCommand.setBalanceId(balanceId);
        addExpenseToBalanceCommand.setUserId(request.getUserId());
        addExpenseToBalanceCommand.setCurrency(request.getCurrency());
        addExpenseToBalanceCommand.setPrice(request.getPrice());
        addExpenseToBalanceCommand.setDescription(request.getDescription());
        addExpenseToBalanceCommand.setGroupId(request.getGroupId());
        return addExpenseToBalanceCommand;
    }
}
