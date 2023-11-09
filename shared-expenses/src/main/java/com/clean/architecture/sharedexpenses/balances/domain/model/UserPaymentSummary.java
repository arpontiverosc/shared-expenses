package com.clean.architecture.sharedexpenses.balances.domain.model;

import lombok.*;

import java.math.BigDecimal;

public class UserPaymentSummary {

    private String userId;
    private BigDecimal amountPaid;
    private BigDecimal amountToBePaid;
}
