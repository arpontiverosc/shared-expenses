package com.clean.architecture.sharedexpenses.balances.infrastructure.out.jpa.impl;

import com.clean.architecture.sharedexpenses.balances.domain.model.Balance;
import com.clean.architecture.sharedexpenses.balances.domain.port.out.FindBalanceByIdRepository;
import com.clean.architecture.sharedexpenses.balances.domain.port.out.SaveBalanceRepository;

public class JpaBalanceRepository implements SaveBalanceRepository, FindBalanceByIdRepository {
    @Override
    public Balance save(Balance balanceFromCommand) {
        return null;
    }

    @Override
    public Balance findById(String balanceId) {
        return null;
    }
}
