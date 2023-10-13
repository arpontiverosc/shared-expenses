package com.clean.architecture.sharedexpenses.balances.infrastructure.in.rest.v1.mapper.response;

import com.clean.architecture.sharedexpenses.balances.domain.model.Balance;
import com.clean.architecture.sharedexpenses.balances.infrastructure.in.rest.v1.model.response.BalanceAmountResponse;
import com.clean.architecture.sharedexpenses.balances.infrastructure.in.rest.v1.model.response.BalanceDetailResponse;
import com.clean.architecture.sharedexpenses.balances.infrastructure.in.rest.v1.model.response.PaymentResponse;

import java.math.BigDecimal;
import java.util.List;

public class BalanceDetailResponseMapper {
    public static BalanceDetailResponse from(Balance balance) {
        BalanceDetailResponse balanceDetailResponse = new BalanceDetailResponse();
        balanceDetailResponse.setId(balance.getId());
        balanceDetailResponse.setBalanceName(balance.getBalanceName());
        balanceDetailResponse.setDescription(balance.getDescription());
        balanceDetailResponse.setGroupId(balance.getGroup().getId());
        balanceDetailResponse.setUsers(balance.getPayerUsersId().size());
        balanceDetailResponse.setTotalAmount(balance.getTotalExpensesAmount());
        balanceDetailResponse.setAmountPerUser(balance.getAmountPerUser());
       // balanceDetailResponse.setBalancesAmount(balance.get);
       // balanceDetailResponse.setPayments();
        return balanceDetailResponse;
    }
}
