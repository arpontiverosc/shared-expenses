package com.clean.architecture.sharedexpenses.balances.infrastructure.out.jpa.impl;

import com.clean.architecture.sharedexpenses.balances.domain.model.Balance;
import com.clean.architecture.sharedexpenses.balances.domain.port.out.FindBalanceByIdRepository;
import com.clean.architecture.sharedexpenses.balances.domain.port.out.SaveBalanceRepository;
import com.clean.architecture.sharedexpenses.balances.infrastructure.out.jpa.StringDataBalanceRepository;
import com.clean.architecture.sharedexpenses.balances.infrastructure.out.jpa.mapper.BalanceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JpaBalanceRepositoryImpl implements SaveBalanceRepository, FindBalanceByIdRepository {


    private final StringDataBalanceRepository springDataBalanceRepository;

    @Override
    public Balance save(Balance balance) {
         return BalanceMapper.from(springDataBalanceRepository.save(BalanceMapper.from(balance)));
    }

    @Override
    public Optional<Balance> findById(String balanceId) {
        return springDataBalanceRepository.findById(balanceId).map(BalanceMapper::from);
    }
}
