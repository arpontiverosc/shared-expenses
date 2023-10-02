package com.clean.architecture.sharedexpenses.balances.infrastructure.in.rest.v1.mapper.response;

import com.clean.architecture.sharedexpenses.balances.domain.model.Balance;
import com.clean.architecture.sharedexpenses.balances.infrastructure.in.rest.v1.model.response.CreateBalanceResponse;

public class CreateBalanceResponseMapper {
    public static CreateBalanceResponse from(Balance balance) {
        return new CreateBalanceResponse(balance.getId());
    }
}
