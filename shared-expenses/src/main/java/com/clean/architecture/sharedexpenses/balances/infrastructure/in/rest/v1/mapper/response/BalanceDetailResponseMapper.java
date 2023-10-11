package com.clean.architecture.sharedexpenses.balances.infrastructure.in.rest.v1.mapper.response;

import com.clean.architecture.sharedexpenses.balances.domain.model.Balance;
import com.clean.architecture.sharedexpenses.balances.infrastructure.in.rest.v1.model.response.BalanceDetailResponse;

public class BalanceDetailResponseMapper {
    public static BalanceDetailResponse from(Balance balance) {
        BalanceDetailResponse balanceDetailResponse = new BalanceDetailResponse();
        balanceDetailResponse.setId(balance.getId());
        balanceDetailResponse.setBalanceName(balance.getBalanceName());
        balanceDetailResponse.setDescription(balance.getDescription());
        balanceDetailResponse.setGroupId(balance.getGroupId());
        return balanceDetailResponse;
    }
}
