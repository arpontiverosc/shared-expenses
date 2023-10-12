package com.clean.architecture.sharedexpenses.balances.infrastructure.out.jpa.mapper;

import com.clean.architecture.sharedexpenses.balances.domain.model.Balance;
import com.clean.architecture.sharedexpenses.balances.infrastructure.model.BalanceJpaEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BalanceMapper {
    public static BalanceJpaEntity from(Balance balance) {
        BalanceJpaEntity balanceJpaEntity = new BalanceJpaEntity();
        balanceJpaEntity.setId(balance.getId());
        balanceJpaEntity.setBalanceName(balance.getBalanceName());
        balanceJpaEntity.setDescription(balance.getDescription());
        balanceJpaEntity.setGroupId(balance.getGroup().getId());
        balanceJpaEntity.setCreatedAt(balance.getCreatedAt());
        if (Objects.nonNull(balance.getExpenses()) && !balance.getExpenses().isEmpty()) {
            balanceJpaEntity.setExpenses(balance.getExpenses().stream().map(ExpenseMapper::from).collect(Collectors.toSet()));
        }
        return balanceJpaEntity;
    }

    public static Balance from(BalanceJpaEntity balanceJpaEntity) {
        Balance balance = new Balance();
        balance.setId(balanceJpaEntity.getId());
        balance.setBalanceName(balanceJpaEntity.getBalanceName());
        balance.setDescription(balanceJpaEntity.getDescription());
        balance.setCreatedAt(balanceJpaEntity.getCreatedAt());
        if (Objects.nonNull(balanceJpaEntity.getExpenses()) && !balanceJpaEntity.getExpenses().isEmpty()) {
            balance.setExpenses(balanceJpaEntity.getExpenses().stream().map(ExpenseMapper::from).toList());
        }
        return balance;
    }
}
