package com.clean.architecture.sharedexpenses.balances.infrastructure.in.rest.v1.mapper.command;

import com.clean.architecture.sharedexpenses.balances.domain.port.in.model.CreateBalanceCommand;
import com.clean.architecture.sharedexpenses.balances.infrastructure.in.rest.v1.model.request.CreateBalanceRequest;

public class CreateBalanceCommandMapper {
    public static CreateBalanceCommand from(CreateBalanceRequest request) {
        CreateBalanceCommand createBalanceCommand = new CreateBalanceCommand();
        createBalanceCommand.setDescription(request.getDescription());
        createBalanceCommand.setBalanceName(request.getBalanceName());
        createBalanceCommand.setGroupId(request.getGroupId());
        return createBalanceCommand;
    }
}
