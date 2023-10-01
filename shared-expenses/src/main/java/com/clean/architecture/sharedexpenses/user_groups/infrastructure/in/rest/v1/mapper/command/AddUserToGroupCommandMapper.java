package com.clean.architecture.sharedexpenses.user_groups.infrastructure.in.rest.v1.mapper.command;

import com.clean.architecture.sharedexpenses.user_groups.domain.port.in.model.AddUserToGroupCommand;
import com.clean.architecture.sharedexpenses.user_groups.infrastructure.in.rest.v1.model.request.AddUserToGroupRequest;

public class AddUserToGroupCommandMapper {
    public static AddUserToGroupCommand from(String groupId, AddUserToGroupRequest request) {
        return new AddUserToGroupCommand(request.getUserId(), groupId);
    }
}
