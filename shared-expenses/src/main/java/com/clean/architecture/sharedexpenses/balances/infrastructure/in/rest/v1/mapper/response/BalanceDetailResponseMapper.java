package com.clean.architecture.sharedexpenses.balances.infrastructure.in.rest.v1.mapper.response;

import com.clean.architecture.sharedexpenses.balances.domain.model.Balance;
import com.clean.architecture.sharedexpenses.balances.domain.model.SettlementPayment;
import com.clean.architecture.sharedexpenses.balances.domain.model.UserPaymentSummary;
import com.clean.architecture.sharedexpenses.balances.infrastructure.in.rest.v1.model.response.BalanceAmountResponse;
import com.clean.architecture.sharedexpenses.balances.infrastructure.in.rest.v1.model.response.BalanceDetailResponse;
import com.clean.architecture.sharedexpenses.balances.infrastructure.in.rest.v1.model.response.PaymentResponse;

public class BalanceDetailResponseMapper {
    public static BalanceDetailResponse from(Balance balance) {
        BalanceDetailResponse balanceDetailResponse = new BalanceDetailResponse();
        balanceDetailResponse.setId(balance.getId());
        balanceDetailResponse.setBalanceName(balance.getBalanceName());
        balanceDetailResponse.setDescription(balance.getDescription());
        balanceDetailResponse.setGroupId(balance.getGroup().getId());
        balanceDetailResponse.setUsers(balance.getGroup().getMembersIds().size());
        balanceDetailResponse.setUsers(balance.getUserNumberGroup());
        balanceDetailResponse.setTotalAmount(balance.getTotalExpensesAmount());
        balanceDetailResponse.setAmountPerUser(balance.getAmountPerUser());
        balanceDetailResponse.setBalancesAmount(balance.getUsersPaymentSummary().stream().map(BalanceDetailResponseMapper::from).toList());
        balanceDetailResponse.setPayments(balance.getUsersSettlementPayments().stream().map(BalanceDetailResponseMapper::from).toList());
        return balanceDetailResponse;
    }

    private static BalanceAmountResponse from(UserPaymentSummary userPaymentSummary) {
        BalanceAmountResponse balanceAmountResponse = new BalanceAmountResponse();
        balanceAmountResponse.setUserId(userPaymentSummary.getUserId());
        balanceAmountResponse.setAmountPaid(userPaymentSummary.getAmountPaid());
        balanceAmountResponse.setAmountFinal(userPaymentSummary.getAmountToBePaid());
        return balanceAmountResponse;
    }

    private static PaymentResponse from(SettlementPayment settlementPayment) {
        PaymentResponse paymentResponse = new PaymentResponse();
        paymentResponse.setBeneficiaryId(settlementPayment.getBeneficiaryId());
        paymentResponse.setDebtorId(settlementPayment.getDebtorId());
        paymentResponse.setAmountToPay(settlementPayment.getAmountToPay());
        return paymentResponse;
    }
}
