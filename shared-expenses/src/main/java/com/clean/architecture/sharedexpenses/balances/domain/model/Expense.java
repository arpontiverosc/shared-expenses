package com.clean.architecture.sharedexpenses.balances.domain.model;

import lombok.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Expense {

    @EqualsAndHashCode.Include  private String id;
    private String balanceId;
    private String userId;
    private String groupId;
    private BigDecimal price;
    private String currency;
    private String description;
    private OffsetDateTime createdAt;

}
