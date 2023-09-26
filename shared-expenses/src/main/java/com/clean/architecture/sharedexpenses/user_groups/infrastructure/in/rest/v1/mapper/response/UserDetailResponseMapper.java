package com.clean.architecture.sharedexpenses.user_groups.infrastructure.in.rest.v1.mapper.response;

import com.clean.architecture.sharedexpenses.user_groups.domain.model.User;
import com.clean.architecture.sharedexpenses.user_groups.infrastructure.in.rest.v1.model.response.UserDetailResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserDetailResponseMapper {
    public static UserDetailResponse from(User user) {
        UserDetailResponse userDetailResponse = new UserDetailResponse();
        userDetailResponse.setId(user.getId());
        userDetailResponse.setUserName(user.getUserName());
        userDetailResponse.setFirstName(user.getFirstName());
        userDetailResponse.setLastName(user.getLastName());
        userDetailResponse.setEmail(user.getEmail());
        return userDetailResponse;
    }
}
