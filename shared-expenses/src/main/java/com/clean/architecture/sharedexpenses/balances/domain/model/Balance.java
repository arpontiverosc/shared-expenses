package com.clean.architecture.sharedexpenses.balances.domain.model;

import lombok.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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
        return expenses.stream().map(expense -> expense.getUserId()).distinct().toList();
    }


    public Map<String, BigDecimal> getTotalSpentByUser() {

        List<String> payersId = getPayerUsersId();

        Map<String, BigDecimal> totalSpentByUser = payersId.stream().collect(Collectors.toMap(
                payerId -> payerId,
                payerId -> {
                        List<Expense> userExpenses = expenses.stream().filter(expense -> expense.getUserId().equals(payerId)).toList();
                        BigDecimal amountPaid = userExpenses.stream().map(userExpense -> userExpense.getPrice()).reduce(BigDecimal.ZERO, BigDecimal::add);
                        return amountPaid;
        }));

        return totalSpentByUser;

    }

    public BigDecimal getTotalExpensesAmount(){
        return expenses.stream().map(expense -> expense.getPrice()).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

   public BigDecimal getAmountPerUser(){
       BigDecimal totalAmount = getTotalExpensesAmount();
       return totalAmount.divide(BigDecimal.valueOf(group.getMembersIds().size()), RoundingMode.HALF_UP);
   }

   

}
