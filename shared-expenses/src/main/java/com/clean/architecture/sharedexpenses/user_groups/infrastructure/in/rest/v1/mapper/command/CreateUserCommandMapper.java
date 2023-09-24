package com.clean.architecture.sharedexpenses.user_groups.infrastructure.in.rest.v1.mapper.command;

import com.clean.architecture.sharedexpenses.user_groups.domain.port.in.model.CreateUserCommand;
import com.clean.architecture.sharedexpenses.user_groups.infrastructure.in.rest.v1.model.request.CreateUserRequest;

public class CreateUserCommandMapper {
    public static CreateUserCommand from(CreateUserRequest request) {
        if (request == null) {
            return null;
        }
        CreateUserCommand command = new CreateUserCommand();
        command.setUserName(request.getUserName());
        command.setFirstName(request.getFirstName());
        command.setLastName(request.getLastName());
        command.setEmail(request.getEmail());

        return command;

    }
}
