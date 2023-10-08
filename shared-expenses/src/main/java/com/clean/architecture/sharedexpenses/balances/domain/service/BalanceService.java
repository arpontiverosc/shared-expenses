package com.clean.architecture.sharedexpenses.balances.domain.service;

import com.clean.architecture.sharedexpenses.balances.domain.model.Balance;
import com.clean.architecture.sharedexpenses.balances.domain.port.out.FindBalanceByIdRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BalanceService {

    private final FindBalanceByIdRepository findBalanceByIdRepository;

    public Balance retrieveBalance(String balanceId) {
        return findBalanceByIdRepository.findById(balanceId).orElseThrow();
    }
}
