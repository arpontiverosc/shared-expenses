package com.clean.architecture.sharedexpenses.balances.infrastructure.in.rest.v1.impl;

import com.clean.architecture.sharedexpenses.balances.domain.port.in.CreateBalanceUseCase;
import com.clean.architecture.sharedexpenses.balances.domain.port.in.DetailBalanceUseCase;
import com.clean.architecture.sharedexpenses.balances.infrastructure.in.rest.v1.BalanceApi;
import com.clean.architecture.sharedexpenses.balances.infrastructure.in.rest.v1.mapper.command.CreateBalanceCommandMapper;
import com.clean.architecture.sharedexpenses.balances.infrastructure.in.rest.v1.mapper.query.DetailBalanceQueryMapper;
import com.clean.architecture.sharedexpenses.balances.infrastructure.in.rest.v1.mapper.response.BalanceDetailResponseMapper;
import com.clean.architecture.sharedexpenses.balances.infrastructure.in.rest.v1.mapper.response.CreateBalanceResponseMapper;
import com.clean.architecture.sharedexpenses.balances.infrastructure.in.rest.v1.model.request.CreateBalanceRequest;
import com.clean.architecture.sharedexpenses.balances.infrastructure.in.rest.v1.model.response.BalanceDetailResponse;
import com.clean.architecture.sharedexpenses.balances.infrastructure.in.rest.v1.model.response.CreateBalanceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BalanceController implements BalanceApi {


    private final CreateBalanceUseCase createBalanceUseCase;
    private final DetailBalanceUseCase detailBalanceUseCase;

    @Override
    public CreateBalanceResponse createBalanceV1(CreateBalanceRequest request) {
        return CreateBalanceResponseMapper.from(createBalanceUseCase.execute(CreateBalanceCommandMapper.from(request)));
    }


    @Override
    public BalanceDetailResponse detailBalanceV1(String balanceId) {
        return BalanceDetailResponseMapper.from(detailBalanceUseCase.execute(DetailBalanceQueryMapper.from(balanceId)));
    }
}
