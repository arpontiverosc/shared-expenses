package com.clean.architecture.sharedexpenses.balances.domain.model;


import java.math.BigDecimal;

public class SettlementPayment {

    private final String beneficiaryId;
    private final String debtorId;
    private final BigDecimal amountToPay;

    public SettlementPayment(Builder builder) {
        this.beneficiaryId = builder.beneficiaryId;
        this.debtorId = builder.debtorId;
        this.amountToPay = builder.amountToPay;
    }

    public String getBeneficiaryId() {
        return beneficiaryId;
    }

    public String getDebtorId() {
        return debtorId;
    }

    public BigDecimal getAmountToPay() {
        return amountToPay;
    }


    public static final class Builder {
        private String beneficiaryId;
        private String debtorId;
        private BigDecimal amountToPay;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder beneficiaryId(String beneficiaryId) {
            this.beneficiaryId = beneficiaryId;
            return this;
        }

        public Builder debtorId(String debtorId) {
            this.debtorId = debtorId;
            return this;
        }

        public Builder amountToPay(BigDecimal amountToPay) {
            this.amountToPay = amountToPay;
            return this;
        }

        public SettlementPayment build() {
            return new SettlementPayment(this);
        }
    }
}
