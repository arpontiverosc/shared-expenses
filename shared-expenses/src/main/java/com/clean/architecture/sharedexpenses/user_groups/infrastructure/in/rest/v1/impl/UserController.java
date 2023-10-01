package com.clean.architecture.sharedexpenses.user_groups.infrastructure.in.rest.v1.impl;

import com.clean.architecture.sharedexpenses.user_groups.domain.port.in.CreateUserUseCase;
import com.clean.architecture.sharedexpenses.user_groups.domain.port.in.DetailUserUseCase;
import com.clean.architecture.sharedexpenses.user_groups.infrastructure.in.rest.v1.UserApi;
import com.clean.architecture.sharedexpenses.user_groups.infrastructure.in.rest.v1.mapper.command.CreateUserCommandMapper;
import com.clean.architecture.sharedexpenses.user_groups.infrastructure.in.rest.v1.mapper.query.DetailUserQueryMapper;
import com.clean.architecture.sharedexpenses.user_groups.infrastructure.in.rest.v1.mapper.response.CreateUserResponseMapper;
import com.clean.architecture.sharedexpenses.user_groups.infrastructure.in.rest.v1.mapper.response.UserDetailResponseMapper;
import com.clean.architecture.sharedexpenses.user_groups.infrastructure.in.rest.v1.model.request.CreateUserRequest;
import com.clean.architecture.sharedexpenses.user_groups.infrastructure.in.rest.v1.model.response.CreateUserResponse;
import com.clean.architecture.sharedexpenses.user_groups.infrastructure.in.rest.v1.model.response.UserDetailResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController implements UserApi {


    private final CreateUserUseCase createUserUseCase;
    private final DetailUserUseCase detailUserUseCase;


    @Override
    public CreateUserResponse createUserV1(CreateUserRequest request) {
        return CreateUserResponseMapper.from(createUserUseCase.execute(CreateUserCommandMapper.from(request)));
    }

    @Override
    public UserDetailResponse detailUserV1(String userId) {
        return UserDetailResponseMapper.from(detailUserUseCase.execute(DetailUserQueryMapper.from(userId)));
    }
}
