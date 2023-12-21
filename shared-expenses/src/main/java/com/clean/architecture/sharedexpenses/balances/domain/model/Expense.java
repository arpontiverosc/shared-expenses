package com.clean.architecture.sharedexpenses.balances.domain.model;


import java.math.BigDecimal;
import java.time.OffsetDateTime;


public class Expense {

    private final String id;
    private final String balanceId;
    private final String userId;
    private final String groupId;
    private final BigDecimal price;
    private final String currency;
    private final String description;
    private final OffsetDateTime createdAt;

    public Expense(Builder builder) {
        this.id = builder.id;
        this.balanceId = builder.balanceId;
        this.userId = builder.userId;
        this.groupId = builder.groupId;
        this.price = builder.price;
        this.currency = builder.currency;
        this.description = builder.description;
        this.createdAt = builder.createdAt;
    }

    public String getId() {
        return id;
    }

    public String getBalanceId() {
        return balanceId;
    }

    public String getUserId() {
        return userId;
    }

    public String getGroupId() {
        return groupId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }

    public String getDescription() {
        return description;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public static final class Builder {
        private String id;
        private String balanceId;
        private String userId;
        private String groupId;
        private BigDecimal price;
        private String currency;
        private String description;
        private OffsetDateTime createdAt;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder balanceId(String balanceId) {
            this.balanceId = balanceId;
            return this;
        }

        public Builder userId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder groupId(String groupId) {
            this.groupId = groupId;
            return this;
        }

        public Builder price(BigDecimal price) {
            this.price = price;
            return this;
        }

        public Builder currency(String currency) {
            this.currency = currency;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder createdAt(OffsetDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Expense build() {
            return new Expense(this);
        }
    }
}
