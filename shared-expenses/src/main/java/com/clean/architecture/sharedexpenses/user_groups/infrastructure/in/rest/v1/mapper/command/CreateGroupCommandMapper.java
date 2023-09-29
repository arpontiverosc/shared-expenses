package com.clean.architecture.sharedexpenses.user_groups.infrastructure.in.rest.v1.mapper.command;

import com.clean.architecture.sharedexpenses.user_groups.domain.port.in.model.CreateGroupCommand;
import com.clean.architecture.sharedexpenses.user_groups.infrastructure.in.rest.v1.model.request.CreateGroupRequest;

public class CreateGroupCommandMapper {
    public static CreateGroupCommand from(CreateGroupRequest request) {
        CreateGroupCommand createGroupCommand = new CreateGroupCommand();
        createGroupCommand.setGroupName(request.getGroupName());
        return createGroupCommand;
    }
}
