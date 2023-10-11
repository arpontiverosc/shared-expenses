package com.clean.architecture.sharedexpenses.balances.infrastructure.out.jpa.impl;

import com.clean.architecture.sharedexpenses.balances.domain.model.Balance;
import com.clean.architecture.sharedexpenses.balances.domain.model.Expense;
import com.clean.architecture.sharedexpenses.balances.domain.port.out.FindBalanceByIdRepository;
import com.clean.architecture.sharedexpenses.balances.domain.port.out.SaveBalanceRepository;
import com.clean.architecture.sharedexpenses.balances.infrastructure.model.BalanceJpaEntity;
import com.clean.architecture.sharedexpenses.balances.infrastructure.model.ExpenseJpaEntity;
import com.clean.architecture.sharedexpenses.balances.infrastructure.out.jpa.SpringDataBalanceRepository;
import com.clean.architecture.sharedexpenses.balances.infrastructure.out.jpa.SpringDataExpenseRepository;
import com.clean.architecture.sharedexpenses.balances.infrastructure.out.jpa.mapper.BalanceMapper;
import com.clean.architecture.sharedexpenses.balances.infrastructure.out.jpa.mapper.ExpenseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JpaBalanceRepositoryImpl implements SaveBalanceRepository, FindBalanceByIdRepository {


    private final SpringDataBalanceRepository springDataBalanceRepository;
    private final SpringDataExpenseRepository springDataExpenseRepository;


    private void saveUpdateBalance(BalanceJpaEntity balanceJpaEntity, Balance balance) {

        Set<ExpenseJpaEntity> entityExpenses = balanceJpaEntity.getExpenses();

        List<String> expensesAddedIds = entityExpenses.stream().map(ExpenseJpaEntity::getId).toList();
        List<Expense> domainExpenses = balance.getExpenses();


        List<ExpenseJpaEntity> notIncludedExpenses = domainExpenses.stream()
                .filter(expense -> !expensesAddedIds.contains(expense.getId()))
                .map(ExpenseMapper::from)
                .map(e -> {
                    e.setBalance(balanceJpaEntity);
                    return e;
                })
                .toList();

        springDataExpenseRepository.saveAll(notIncludedExpenses);
    }

    @Override
    public Balance save(Balance balance) {

        BalanceJpaEntity balanceJpaEntitytoSave = BalanceMapper.from(balance);

        Optional<BalanceJpaEntity> balanceJpaEntity = springDataBalanceRepository.findById(balanceJpaEntitytoSave.getId());
        if (balanceJpaEntity.isPresent()) {
            saveUpdateBalance(balanceJpaEntity.get(), balance);
        } else {
            balanceJpaEntitytoSave = springDataBalanceRepository.save(balanceJpaEntitytoSave);
        }

        return BalanceMapper.from(balanceJpaEntitytoSave);

    }


    @Override
    public Optional<Balance> findById(String balanceId) {
        return springDataBalanceRepository.findById(balanceId).map(BalanceMapper::from);
    }
}
