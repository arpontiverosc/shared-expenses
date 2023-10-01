package com.clean.architecture.sharedexpenses.user_groups.infrastructure.in.rest.v1.impl;

import com.clean.architecture.sharedexpenses.user_groups.domain.port.in.AddUserToGroupUseCase;
import com.clean.architecture.sharedexpenses.user_groups.domain.port.in.CreateGroupUseCase;
import com.clean.architecture.sharedexpenses.user_groups.domain.port.in.DetailGroupUseCase;
import com.clean.architecture.sharedexpenses.user_groups.infrastructure.in.rest.v1.GroupApi;
import com.clean.architecture.sharedexpenses.user_groups.infrastructure.in.rest.v1.mapper.command.CreateGroupCommandMapper;
import com.clean.architecture.sharedexpenses.user_groups.infrastructure.in.rest.v1.mapper.command.AddUserToGroupCommandMapper;
import com.clean.architecture.sharedexpenses.user_groups.infrastructure.in.rest.v1.mapper.query.DetailGroupQueryMapper;
import com.clean.architecture.sharedexpenses.user_groups.infrastructure.in.rest.v1.mapper.response.CreateGroupResponseMapper;
import com.clean.architecture.sharedexpenses.user_groups.infrastructure.in.rest.v1.mapper.response.GroupDetailResponseMapper;
import com.clean.architecture.sharedexpenses.user_groups.infrastructure.in.rest.v1.model.request.AddUserToGroupRequest;
import com.clean.architecture.sharedexpenses.user_groups.infrastructure.in.rest.v1.model.request.CreateGroupRequest;
import com.clean.architecture.sharedexpenses.user_groups.infrastructure.in.rest.v1.model.response.CreateGroupResponse;
import com.clean.architecture.sharedexpenses.user_groups.infrastructure.in.rest.v1.model.response.GroupDetailResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GroupController implements GroupApi {

    private final CreateGroupUseCase createGroupUseCase;
    private final DetailGroupUseCase detailGroupUseCase;
    private final AddUserToGroupUseCase addUserToGroupUseCase;

    @Override
    public CreateGroupResponse createGroupV1(CreateGroupRequest request) {
        return CreateGroupResponseMapper.from(createGroupUseCase.execute(CreateGroupCommandMapper.from(request)));
    }

    @Override
    public GroupDetailResponse detailGroupV1(String groupId) {
        return GroupDetailResponseMapper.from(detailGroupUseCase.execute(DetailGroupQueryMapper.from(groupId)));
    }

    @Override
    public void addUserToGroup(String groupId, AddUserToGroupRequest request) {
         addUserToGroupUseCase.execute(AddUserToGroupCommandMapper.from(groupId, request));
    }

}
