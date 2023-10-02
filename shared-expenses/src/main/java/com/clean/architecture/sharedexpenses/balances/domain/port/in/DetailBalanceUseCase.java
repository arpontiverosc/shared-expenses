package com.clean.architecture.sharedexpenses.balances.domain.port.in;


import com.clean.architecture.sharedexpenses.balances.domain.model.Balance;
import com.clean.architecture.sharedexpenses.balances.domain.port.in.model.DetailBalanceQuery;
import jakarta.validation.Valid;

public interface DetailBalanceUseCase {
    Balance execute(@Valid DetailBalanceQuery query);
}
