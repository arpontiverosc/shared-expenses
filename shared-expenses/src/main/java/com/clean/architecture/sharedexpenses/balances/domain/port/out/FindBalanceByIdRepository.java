package com.clean.architecture.sharedexpenses.balances.domain.port.out;

import com.clean.architecture.sharedexpenses.balances.domain.model.Balance;

import java.util.Optional;

public interface FindBalanceByIdRepository {
    Optional<Balance> findById(String balanceId);
}
