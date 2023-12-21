package com.clean.architecture.sharedexpenses.balances.domain.model;



import java.math.BigDecimal;

public class UserPaymentSummary {

    private final String userId;
    private final BigDecimal amountPaid;
    private final BigDecimal amountToBePaid;


    private UserPaymentSummary(Builder builder) {
        this.userId = builder.userId;
        this.amountPaid = builder.amountPaid;
        this.amountToBePaid = builder.amountToBePaid;
    }

    public String getUserId() {
        return userId;
    }

    public BigDecimal getAmountPaid() {
        return amountPaid;
    }

    public BigDecimal getAmountToBePaid() {
        return amountToBePaid;
    }


    public static final class Builder {
        private String userId;
        private BigDecimal amountPaid;
        private BigDecimal amountToBePaid;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder userId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder amountPaid(BigDecimal amountPaid) {
            this.amountPaid = amountPaid;
            return this;
        }

        public Builder amountToBePaid(BigDecimal amountToBePaid) {
            this.amountToBePaid = amountToBePaid;
            return this;
        }

        public UserPaymentSummary build() {
            return new UserPaymentSummary(this);
        }
    }
}
