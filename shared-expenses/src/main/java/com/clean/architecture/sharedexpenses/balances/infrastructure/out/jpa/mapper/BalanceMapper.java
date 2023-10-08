package com.clean.architecture.sharedexpenses.balances.infrastructure.out.jpa.mapper;

import com.clean.architecture.sharedexpenses.balances.domain.model.Balance;
import com.clean.architecture.sharedexpenses.balances.infrastructure.model.BalanceJpaEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BalanceMapper {
    public static BalanceJpaEntity from(Balance balance) {
        BalanceJpaEntity balanceJpaEntity = new BalanceJpaEntity();
        balanceJpaEntity.setId(balance.getId());
        balanceJpaEntity.setBalanceName(balance.getBalanceName());
        balanceJpaEntity.setDescription(balance.getDescription());
        balanceJpaEntity.setGroupId(balance.getGroupId());
        balanceJpaEntity.setCreatedAt(OffsetDateTime.now());
        return balanceJpaEntity;
    }

    public static Balance from(BalanceJpaEntity balanceJpaEntity) {
        Balance balance = new Balance();
        balance.setId(balanceJpaEntity.getId());
        balance.setBalanceName(balanceJpaEntity.getBalanceName());
        balance.setDescription(balanceJpaEntity.getDescription());
        balance.setGroupId(balanceJpaEntity.getGroupId());
        balance.setCreatedAt(balanceJpaEntity.getCreatedAt());
        return balance;
    }
}
