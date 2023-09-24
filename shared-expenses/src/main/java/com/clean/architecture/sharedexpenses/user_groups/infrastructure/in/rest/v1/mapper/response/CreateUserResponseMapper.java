package com.clean.architecture.sharedexpenses.user_groups.infrastructure.in.rest.v1.mapper.response;

import com.clean.architecture.sharedexpenses.user_groups.domain.model.User;
import com.clean.architecture.sharedexpenses.user_groups.infrastructure.in.rest.v1.model.response.CreateUserResponse;

public class CreateUserResponseMapper {
    public CreateUserResponse from(User user) {
        if (user == null) {
            return null;
        }
        CreateUserResponse createCustomerResponse = new CreateUserResponse();
        createCustomerResponse.setId(user.getId());
        return createCustomerResponse;
    }

}
