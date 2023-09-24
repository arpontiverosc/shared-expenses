package com.clean.architecture.sharedexpenses.user_groups.infrastructure.in.rest.v1.impl;

import com.clean.architecture.sharedexpenses.user_groups.domain.port.in.CreateUserUseCase;
import com.clean.architecture.sharedexpenses.user_groups.infrastructure.in.rest.v1.UserApi;
import com.clean.architecture.sharedexpenses.user_groups.infrastructure.in.rest.v1.mapper.command.CreateUserCommandMapper;
import com.clean.architecture.sharedexpenses.user_groups.infrastructure.in.rest.v1.mapper.response.CreateUserResponseMapper;
import com.clean.architecture.sharedexpenses.user_groups.infrastructure.in.rest.v1.model.request.CreateUserRequest;
import com.clean.architecture.sharedexpenses.user_groups.infrastructure.in.rest.v1.model.response.CreateUserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController implements UserApi {


    private final CreateUserUseCase createUserUseCase;
    private final CreateUserResponseMapper createUserResponseMapper;

    @Override
    public CreateUserResponse createUserV1(CreateUserRequest request) {

        return createUserResponseMapper.from(createUserUseCase.execute(CreateUserCommandMapper.from(request)));

    }
}
