package com.clean.architecture.sharedexpenses.user_groups.infrastructure.in.rest.v1.mapper.response;

import com.clean.architecture.sharedexpenses.user_groups.domain.model.Group;
import com.clean.architecture.sharedexpenses.user_groups.infrastructure.in.rest.v1.model.response.CreateGroupResponse;

public class CreateGroupResponseMapper {
    public static CreateGroupResponse from(Group group) {
        CreateGroupResponse createGroupResponse = new CreateGroupResponse();
        createGroupResponse.setId(group.getId());
        return createGroupResponse;
    }
}
