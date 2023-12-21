package com.clean.architecture.sharedexpenses.balances.infrastructure.out.jpa.mapper;

import com.clean.architecture.sharedexpenses.balances.domain.model.Expense;
import com.clean.architecture.sharedexpenses.balances.infrastructure.model.ExpenseJpaEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ExpenseMapper {

    public static Expense from(ExpenseJpaEntity expenseJpaEntity) {
        return Expense.Builder.builder()
                                .id(expenseJpaEntity.getId())
                                .description(expenseJpaEntity.getDescription())
                                .price(expenseJpaEntity.getPrice())
                                .userId(expenseJpaEntity.getUserId())
                                .groupId(expenseJpaEntity.getGroupId())
                                .balanceId(expenseJpaEntity.getBalance().getId())
                                .currency(expenseJpaEntity.getCurrency())
                                .createdAt(expenseJpaEntity.getCreatedAt())
                .build();

    }

    public static ExpenseJpaEntity from(Expense expense) {
        ExpenseJpaEntity expenseJpaEntity = new ExpenseJpaEntity();
        expenseJpaEntity.setId(expense.getId());
        expenseJpaEntity.setDescription(expense.getDescription());
        expenseJpaEntity.setPrice(expense.getPrice());
        expenseJpaEntity.setCurrency(expense.getCurrency());
        expenseJpaEntity.setUserId(expense.getUserId());
        expenseJpaEntity.setGroupId(expense.getGroupId());
        expenseJpaEntity.setCreatedAt(expense.getCreatedAt());
        return expenseJpaEntity;
    }

}
