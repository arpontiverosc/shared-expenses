package com.clean.architecture.sharedexpenses.user_groups.infrastructure.in.rest.v1.mapper.response;

import com.clean.architecture.sharedexpenses.user_groups.domain.model.User;
import com.clean.architecture.sharedexpenses.user_groups.infrastructure.in.rest.v1.model.response.CreateUserResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CreateUserResponseMapper {
    public static CreateUserResponse from(User user) {
        if (user == null) {
            return null;
        }
        CreateUserResponse createCustomerResponse = new CreateUserResponse();
        createCustomerResponse.setId(user.getId());
        return createCustomerResponse;
    }

}
