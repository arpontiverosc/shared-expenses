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
public class PaymentResponse {

    private Long beneficiary;
    private Long beneficiaryName;
    private Long debtor;
    private Long debtorName;
    private BigDecimal amountToPay;

}
