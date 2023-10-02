package com.clean.architecture.sharedexpenses.balances.infrastructure.in.rest.v1.mapper.response;

import com.clean.architecture.sharedexpenses.balances.domain.model.Balance;
import com.clean.architecture.sharedexpenses.balances.infrastructure.in.rest.v1.model.response.BalanceDetailResponse;

public class BalanceDetailResponseMapper {
    public static BalanceDetailResponse from(Balance request) {
        BalanceDetailResponse balanceDetailResponse = new BalanceDetailResponse();
        balanceDetailResponse.setBalanceName(request.getBalanceName());
        balanceDetailResponse.setDescription(request.getDescription());
        balanceDetailResponse.setGroupId(request.getGroupId());
        return balanceDetailResponse;

    }
}
