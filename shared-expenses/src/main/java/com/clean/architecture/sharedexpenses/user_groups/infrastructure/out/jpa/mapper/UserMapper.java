package com.clean.architecture.sharedexpenses.user_groups.infrastructure.out.jpa.mapper;

import com.clean.architecture.sharedexpenses.user_groups.domain.model.User;
import com.clean.architecture.sharedexpenses.user_groups.infrastructure.out.jpa.model.UserJpaEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserMapper {

    public static User from(UserJpaEntity userJpaEntity) {
        if (userJpaEntity == null) {
            return null;
        }
        User user = new User();
        user.setId(userJpaEntity.getId());
        user.setFirstName(userJpaEntity.getFirstName());
        user.setLastName(userJpaEntity.getLastName());
        user.setEmail(userJpaEntity.getEmail());
        return user;
    }
}
