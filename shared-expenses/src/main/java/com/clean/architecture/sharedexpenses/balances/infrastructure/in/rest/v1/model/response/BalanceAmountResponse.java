package com.clean.architecture.sharedexpenses.balances.infrastructure.in.rest.v1.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BalanceAmountResponse {

    private String userId;
    private BigDecimal amountPaid;
    private BigDecimal amountFinal;
}
