package com.clean.architecture.sharedexpenses.balances.infrastructure.out.jpa.impl;

import com.clean.architecture.sharedexpenses.balances.domain.model.Balance;
import com.clean.architecture.sharedexpenses.balances.domain.model.Expense;
import com.clean.architecture.sharedexpenses.balances.domain.model.Group;
import com.clean.architecture.sharedexpenses.balances.domain.port.out.FindBalanceByIdRepository;
import com.clean.architecture.sharedexpenses.balances.domain.port.out.SaveBalanceRepository;
import com.clean.architecture.sharedexpenses.balances.infrastructure.model.BalanceJpaEntity;
import com.clean.architecture.sharedexpenses.balances.infrastructure.model.ExpenseJpaEntity;
import com.clean.architecture.sharedexpenses.balances.infrastructure.model.GroupTempJpaEntity;
import com.clean.architecture.sharedexpenses.balances.infrastructure.out.jpa.SpringDataBalanceRepository;
import com.clean.architecture.sharedexpenses.balances.infrastructure.out.jpa.SpringDataExpenseRepository;
import com.clean.architecture.sharedexpenses.balances.infrastructure.out.jpa.SpringDataGroupTempRepository;
import com.clean.architecture.sharedexpenses.balances.infrastructure.out.jpa.mapper.BalanceMapper;
import com.clean.architecture.sharedexpenses.balances.infrastructure.out.jpa.mapper.ExpenseMapper;
import com.clean.architecture.sharedexpenses.balances.infrastructure.out.jpa.mapper.GroupMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class JpaBalanceRepositoryImpl implements SaveBalanceRepository, FindBalanceByIdRepository {


    private final SpringDataBalanceRepository springDataBalanceRepository;
    private final SpringDataExpenseRepository springDataExpenseRepository;
    private final SpringDataGroupTempRepository springDataGroupTempRepository;


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

/*

    public Optional<Balance> findById(String balanceId) {

        Optional<Balance> balanceOptional = Optional.empty();

        Optional<BalanceJpaEntity> balanceJpaEntity = springDataBalanceRepository.findById(balanceId);

        if(balanceJpaEntity.isPresent()){

            Optional<GroupTempJpaEntity> groupJpaEntity = springDataGroupTempRepository.findById(balanceJpaEntity.get().getGroupId());

            Group group = new Group();
            if(groupJpaEntity.isPresent()){
                group = groupJpaEntity.map(GroupMapper::from).get();
            }
            Balance balance = balanceJpaEntity.map(BalanceMapper::from).get();
            balance.setGroup(group);

            balanceOptional = Optional.of(balance);
        }

        return balanceOptional;

    }*/
    @Override
    public Optional<Balance> findById(String balanceId) {

        Optional<BalanceJpaEntity> balanceJpaEntity = springDataBalanceRepository.findById(balanceId);

        if (balanceJpaEntity.isPresent()) {

            Balance balance = BalanceMapper.from(balanceJpaEntity.get());

            Optional<Group> groupOptional = springDataGroupTempRepository.findById(balanceJpaEntity.get().getGroupId())
                    .map(GroupMapper::from);

            groupOptional.ifPresent(balance::setGroup);

            return Optional.of(balance);
        } else {
            return Optional.empty();
        }
    }


}
