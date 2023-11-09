package com.clean.architecture.sharedexpenses.balances.domain.model;


import java.math.BigDecimal;
import java.time.OffsetDateTime;



public class Expense {

    private String id;
    private String balanceId;
    private String userId;
    private String groupId;
    private BigDecimal price;
    private String currency;
    private String description;
    private OffsetDateTime createdAt;

}
