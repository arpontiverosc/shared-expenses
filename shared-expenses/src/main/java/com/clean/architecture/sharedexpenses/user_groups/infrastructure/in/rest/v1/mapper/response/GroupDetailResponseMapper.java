package com.clean.architecture.sharedexpenses.user_groups.infrastructure.in.rest.v1.mapper.response;

import com.clean.architecture.sharedexpenses.user_groups.domain.model.Group;
import com.clean.architecture.sharedexpenses.user_groups.infrastructure.in.rest.v1.model.response.GroupDetailResponse;

public class GroupDetailResponseMapper {
    public static GroupDetailResponse from(Group group) {
        return new GroupDetailResponse(group.getId(), group.getGroupName());
    }
}
