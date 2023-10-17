package com.clean.architecture.sharedexpenses.balances.domain.model;

import lombok.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.OffsetDateTime;
import java.util.*;
import java.util.stream.Collectors;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Balance {

    @EqualsAndHashCode.Include
    private String id;
    private String balanceName;
    private String description;
    private Group group;
    private OffsetDateTime createdAt;
    private List<Expense> expenses = new ArrayList<>();


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

            UserPaymentSummary userPaymentSummary = new UserPaymentSummary();
            userPaymentSummary.setUserId(userId);

            BigDecimal totalSpentByUser = BigDecimal.ZERO;
            if(totalSpentByUsers.containsKey(userId)) {
                totalSpentByUser = totalSpentByUsers.get(userId);
            }
            userPaymentSummary.setAmountPaid(totalSpentByUser);
            userPaymentSummary.setAmountToBePaid(totalSpentByUser.subtract(amountToPayPerUser));

            return userPaymentSummary;

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

            SettlementPayment settlementPayment = new SettlementPayment();
            settlementPayment.setBeneficiaryId(creditor.getUserId());
            settlementPayment.setDebtorId(debtor.getUserId());
            settlementPayment.setAmountToPay(payment);

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


}
