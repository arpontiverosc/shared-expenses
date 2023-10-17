package com.clean.architecture.sharedexpenses.balances.domain.model;

import lombok.*;

import java.math.BigDecimal;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class SettlementPayment {

    private String beneficiaryId;
    private String debtorId;
    private BigDecimal amountToPay;
}
