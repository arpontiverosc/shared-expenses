package com.clean.architecture.sharedexpenses.user_groups.infrastructure.in.rest.v1.mapper.query;

import com.clean.architecture.sharedexpenses.user_groups.domain.port.in.model.DetailUserQuery;

public class DetailUserQueryMapper {
    public static DetailUserQuery from(String userId) {
        DetailUserQuery detailUserQuery = new DetailUserQuery();
        detailUserQuery.setId(userId);
        return detailUserQuery;
    }
}
