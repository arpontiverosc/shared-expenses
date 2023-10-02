package com.clean.architecture.sharedexpenses.user_groups.infrastructure.in.rest.v1.mapper.response;

import com.clean.architecture.sharedexpenses.user_groups.domain.model.Group;
import com.clean.architecture.sharedexpenses.user_groups.infrastructure.in.rest.v1.model.response.GroupDetailResponse;
import com.clean.architecture.sharedexpenses.user_groups.infrastructure.out.jpa.mapper.GroupMapper;

public class GroupDetailResponseMapper {
    public static GroupDetailResponse from(Group group) {
        GroupDetailResponse groupDetailResponse = new GroupDetailResponse();
        groupDetailResponse.setId(group.getId());
        groupDetailResponse.setGroupName(group.getGroupName());
        groupDetailResponse.setUsers(group.getUsers().stream().map(UserDetailResponseMapper::from).toList());
        return groupDetailResponse;
    }
}
