package com.clean.architecture.sharedexpenses.balances.domain.port.in;

import com.clean.architecture.sharedexpenses.balances.domain.model.Balance;
import com.clean.architecture.sharedexpenses.balances.domain.port.in.model.CreateBalanceCommand;
import com.clean.architecture.sharedexpenses.balances.infrastructure.in.rest.v1.model.response.CreateBalanceResponse;
import jakarta.validation.Valid;

public interface CreateBalanceUseCase {
    Balance execute(@Valid CreateBalanceCommand command);
}
