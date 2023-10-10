package com.clean.architecture.sharedexpenses.balances.domain.port.in.model;

import lombok.*;

import java.math.BigDecimal;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AddExpenseToBalanceCommand {

    private String balanceId;
    private String userId;
    private String groupId;
    private BigDecimal price;
    private String currency;
    private String description;
}
