package com.clean.architecture.sharedexpenses.balances.infrastructure.in.rest.v1.mapper.query;

import com.clean.architecture.sharedexpenses.balances.domain.port.in.model.DetailBalanceQuery;

public class DetailBalanceQueryMapper {
    public static DetailBalanceQuery from(String balanceId) {
        DetailBalanceQuery detailBalanceQuery = new DetailBalanceQuery();
        detailBalanceQuery.setId(balanceId);
        return detailBalanceQuery;
    }
}
