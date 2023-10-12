package com.clean.architecture.sharedexpenses.balances.infrastructure.in.rest.v1.impl;

import com.clean.architecture.sharedexpenses.balances.domain.port.in.AddExpenseToBalance;
import com.clean.architecture.sharedexpenses.balances.domain.port.in.CreateBalanceUseCase;
import com.clean.architecture.sharedexpenses.balances.domain.port.in.DetailBalanceUseCase;
import com.clean.architecture.sharedexpenses.balances.infrastructure.in.rest.v1.BalanceApi;
import com.clean.architecture.sharedexpenses.balances.infrastructure.in.rest.v1.mapper.command.AddExpenseToBalanceCommandMapper;
import com.clean.architecture.sharedexpenses.balances.infrastructure.in.rest.v1.mapper.command.CreateBalanceCommandMapper;
import com.clean.architecture.sharedexpenses.balances.infrastructure.in.rest.v1.mapper.query.DetailBalanceQueryMapper;
import com.clean.architecture.sharedexpenses.balances.infrastructure.in.rest.v1.mapper.response.BalanceDetailResponseMapper;
import com.clean.architecture.sharedexpenses.balances.infrastructure.in.rest.v1.mapper.response.CreateBalanceResponseMapper;
import com.clean.architecture.sharedexpenses.balances.infrastructure.in.rest.v1.model.request.AddExpenseToBalanceRequest;
import com.clean.architecture.sharedexpenses.balances.infrastructure.in.rest.v1.model.request.CreateBalanceRequest;
import com.clean.architecture.sharedexpenses.balances.infrastructure.in.rest.v1.model.response.AddExpenseToBalanceResponse;
import com.clean.architecture.sharedexpenses.balances.infrastructure.in.rest.v1.model.response.BalanceDetailResponse;
import com.clean.architecture.sharedexpenses.balances.infrastructure.in.rest.v1.model.response.CreateBalanceResponse;
import com.clean.architecture.sharedexpenses.balances.infrastructure.in.rest.v1.mapper.response.AddExpenseToBalanceResponseMapper;

import com.clean.architecture.sharedexpenses.balances.infrastructure.in.rest.v1.model.response.ExpensesForBalanceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BalanceController implements BalanceApi {


    private final CreateBalanceUseCase createBalanceUseCase;
    private final DetailBalanceUseCase detailBalanceUseCase;
    private final AddExpenseToBalance addExpenseToBalance;

    @Override
    public CreateBalanceResponse createBalanceV1(CreateBalanceRequest request) {
        return CreateBalanceResponseMapper.from(createBalanceUseCase.execute(CreateBalanceCommandMapper.from(request)));
    }


    @Override
    public BalanceDetailResponse detailBalanceV1(String balanceId) {
        return BalanceDetailResponseMapper.from(detailBalanceUseCase.execute(DetailBalanceQueryMapper.from(balanceId)));
    }

    @Override
    public AddExpenseToBalanceResponse addExpenseToBalanceV1(String balanceId, AddExpenseToBalanceRequest request) {
        return AddExpenseToBalanceResponseMapper.from(addExpenseToBalance.execute(AddExpenseToBalanceCommandMapper.from(balanceId, request)));
    }

    @Override
    public ExpensesForBalanceResponse obtainExpensesForBalanceV1(String balanceId) {
        return null;
    }
}
