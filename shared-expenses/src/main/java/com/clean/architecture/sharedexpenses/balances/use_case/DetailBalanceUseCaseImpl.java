package com.clean.architecture.sharedexpenses.balances.use_case;

import com.clean.architecture.sharedexpenses.balances.domain.model.Balance;
import com.clean.architecture.sharedexpenses.balances.domain.port.in.DetailBalanceUseCase;
import com.clean.architecture.sharedexpenses.balances.domain.port.in.model.DetailBalanceQuery;
import com.clean.architecture.sharedexpenses.balances.domain.port.out.FindBalanceByIdRepository;
import com.clean.architecture.sharedexpenses.balances.domain.service.BalanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DetailBalanceUseCaseImpl implements DetailBalanceUseCase {

    private final BalanceService balanceService;

    @Transactional(readOnly = true)
    @Override
    public Balance execute(DetailBalanceQuery query) {
        return balanceService.retrieveBalance(query.getId());
    }
}
