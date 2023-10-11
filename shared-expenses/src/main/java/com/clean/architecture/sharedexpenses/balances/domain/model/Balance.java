package com.clean.architecture.sharedexpenses.balances.domain.model;

import lombok.*;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


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
    private String groupId;
    private OffsetDateTime createdAt;
    private List<Expense> expenses = new ArrayList<>();


    public void addExpense(Expense expense) {
        expenses = Optional.ofNullable(expenses).map(ArrayList::new).orElseGet(ArrayList::new);
        expenses.add(expense);
    }
/*
    public void addExpense(Expense expense) {
        Optional.ofNullable(expenses)
                .map(ArrayList::new)
                .ifPresent(expenseList -> {
                    expenseList.add(expense);
                    expenses = expenseList;
                });
    }
*/
}
