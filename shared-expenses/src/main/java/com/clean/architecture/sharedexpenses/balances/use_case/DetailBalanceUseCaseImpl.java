package com.clean.architecture.sharedexpenses.balances.use_case;

import com.clean.architecture.sharedexpenses.balances.domain.model.Balance;
import com.clean.architecture.sharedexpenses.balances.domain.port.in.DetailBalanceUseCase;
import com.clean.architecture.sharedexpenses.balances.domain.port.in.model.DetailBalanceQuery;
import com.clean.architecture.sharedexpenses.balances.domain.port.out.FindBalanceByIdRepository;
import com.clean.architecture.sharedexpenses.balances.domain.service.BalanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DetailBalanceUseCaseImpl implements DetailBalanceUseCase {

    private final BalanceService balanceService;

    @Override
    public Balance execute(DetailBalanceQuery query) {
        return balanceService.retrieveBalance(query.getId());
    }
}
