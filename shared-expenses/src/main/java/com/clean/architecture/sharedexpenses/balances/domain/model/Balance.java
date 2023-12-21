package com.clean.architecture.sharedexpenses.balances.domain.model;



import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.OffsetDateTime;
import java.util.*;
import java.util.stream.Collectors;



public class Balance {


    private final String id;
    private final String balanceName;
    private final String description;
    private Group group;
    private final OffsetDateTime createdAt;
    private List<Expense> expenses = new ArrayList<>();

    public void setGroup(Group group) {
        this.group = group;
    }

    private Balance(Builder builder) {
        this.id = builder.id;
        this.balanceName = builder.balanceName;
        this.description = builder.description;
        this.group = builder.group;
        this.createdAt = builder.createdAt;
        this.expenses = builder.expenses;
    }

    public String getId() {
        return id;
    }

    public String getBalanceName() {
        return balanceName;
    }

    public String getDescription() {
        return description;
    }

    public Group getGroup() {
        return group;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void addExpense(Expense expense) {
        expenses = Optional.ofNullable(expenses).map(ArrayList::new).orElseGet(ArrayList::new);
        expenses.add(expense);
    }

    public List<String> getPayerUsersId() {
        return expenses.stream().map(Expense::getUserId).distinct().toList();
    }

    public int getUserNumberGroup() {
        return Optional.ofNullable(group)
                .flatMap(g -> Optional.ofNullable(g.getMembersIds()))
                .map(Set::size)
                .orElse(0);
    }

    public List<String> getUsersIdGroup() {
        return Optional.ofNullable(group)
                .map(Group::getMembersIds)
                .orElse(Collections.emptySet())
                .stream()
                .map(Objects::toString)
                .collect(Collectors.toList());
    }

    public Map<String, BigDecimal> getTotalSpentByUser() {

        List<String> payersId = getPayerUsersId();

        return payersId.stream().collect(Collectors.toMap(payerId -> payerId, payerId -> {
            List<Expense> userExpenses = expenses.stream().filter(expense -> expense.getUserId().equals(payerId)).toList();
            return userExpenses.stream().map(Expense::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);

        }));

    }

    public BigDecimal getTotalExpensesAmount() {
        return expenses.stream().map(Expense::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal getAmountPerUser() {
        BigDecimal totalAmount = getTotalExpensesAmount();
        return totalAmount.divide(BigDecimal.valueOf(group.getMembersIds().size()), RoundingMode.HALF_UP);
    }

    public List<UserPaymentSummary> getUsersPaymentSummary() {

        final BigDecimal amountToPayPerUser = getAmountPerUser();
        final Map<String, BigDecimal> totalSpentByUsers = getTotalSpentByUser();

        return getUsersIdGroup().stream().map(userId -> {

            BigDecimal totalSpentByUser = BigDecimal.ZERO;
            if(totalSpentByUsers.containsKey(userId)) {
                totalSpentByUser = totalSpentByUsers.get(userId);
            }

            return UserPaymentSummary.Builder.builder()
                    .userId(userId)
                    .amountPaid(totalSpentByUser)
                    .amountToBePaid(totalSpentByUser.subtract(amountToPayPerUser)).build();


        }).toList();


    }

    public List<SettlementPayment> getUsersSettlementPayments() {

        List<UserPaymentSummary> userPaymentSummaries = getUsersPaymentSummary();

        List<UserPaymentSummary> balanceBeneficiary = new ArrayList<>(userPaymentSummaries.stream()
                .filter(balance -> balance.getAmountToBePaid().compareTo(BigDecimal.ZERO) > 0)
                .sorted(Comparator.comparing(UserPaymentSummary::getAmountToBePaid).reversed())
                .toList());

        List<UserPaymentSummary> balanceDebtors = new ArrayList<>(userPaymentSummaries.stream()
                .filter(balance -> balance.getAmountToBePaid().compareTo(BigDecimal.ZERO) < 0)
                .sorted(Comparator.comparing(UserPaymentSummary::getAmountToBePaid))
                .toList());

        Map<String, BigDecimal> balancesAux = userPaymentSummaries.stream()
                .collect(Collectors.toMap(
                        UserPaymentSummary::getUserId,
                        UserPaymentSummary::getAmountToBePaid));

        List<SettlementPayment> settlementPayments = new ArrayList<>();

        while (!balanceDebtors.isEmpty() && !balanceBeneficiary.isEmpty()) {

            UserPaymentSummary debtor = balanceDebtors.get(0);
            UserPaymentSummary creditor = balanceBeneficiary.get(0);

            BigDecimal debt = balancesAux.get(debtor.getUserId());
            BigDecimal credit = balancesAux.get(creditor.getUserId());

            BigDecimal payment = debt.abs().min(credit);

            balancesAux.put(debtor.getUserId(), debt.add(payment));
            balancesAux.put(creditor.getUserId(), credit.subtract(payment));

            SettlementPayment settlementPayment = SettlementPayment.Builder.builder()
                                                .beneficiaryId(creditor.getUserId())
                                                .debtorId(debtor.getUserId())
                                                .amountToPay(payment)
                                                 .build();

            settlementPayments.add(settlementPayment);

            if (balancesAux.get(debtor.getUserId()).abs().compareTo(BigDecimal.valueOf(0.01)) < 0 )  {
                balanceDebtors.remove(0);
            }

            if (balancesAux.get(creditor.getUserId()).abs().compareTo(BigDecimal.valueOf(0.01)) < 0 )  {
                balanceBeneficiary.remove(0);
            }

        }

        return settlementPayments;

    }


    public static final class Builder {
        private String id;
        private String balanceName;
        private String description;
        private Group group;
        private OffsetDateTime createdAt;
        private List<Expense> expenses;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder balanceName(String balanceName) {
            this.balanceName = balanceName;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder group(Group group) {
            this.group = group;
            return this;
        }

        public Builder createdAt(OffsetDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder expenses(List<Expense> expenses) {
            this.expenses = expenses;
            return this;
        }

        public Balance build() {
            return new Balance(this);
        }
    }
}
