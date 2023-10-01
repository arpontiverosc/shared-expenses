package com.clean.architecture.sharedexpenses.user_groups.infrastructure.in.rest.v1.mapper.query;

import com.clean.architecture.sharedexpenses.user_groups.domain.port.in.model.DetailGroupQuery;

public class DetailGroupQueryMapper {
    public static DetailGroupQuery from(String groupId) {
        return new DetailGroupQuery(groupId);
    }
}
