package com.clean.architecture.sharedexpenses.balances.domain.port.out;

import com.clean.architecture.sharedexpenses.balances.domain.model.Balance;

public interface FindBalanceByIdRepository {
    Balance findById(String balanceId);
}
