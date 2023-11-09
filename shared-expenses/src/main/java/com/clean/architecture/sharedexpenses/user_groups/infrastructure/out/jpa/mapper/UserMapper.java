package com.clean.architecture.sharedexpenses.user_groups.infrastructure.out.jpa.mapper;

import com.clean.architecture.sharedexpenses.user_groups.domain.model.User;
import com.clean.architecture.sharedexpenses.user_groups.infrastructure.out.jpa.model.UserJpaEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserMapper {

    public static User from(UserJpaEntity userJpaEntity) {

        return User.builder()
        .id(userJpaEntity.getId())
        .userName(userJpaEntity.getUserName())
        .firstName(userJpaEntity.getFirstName())
        .lastName(userJpaEntity.getLastName())
        .email(userJpaEntity.getEmail())
        .build();

    }


    public static UserJpaEntity from(User user) {
        UserJpaEntity userJpaEntity = new UserJpaEntity();
        userJpaEntity.setId(user.getId());
        userJpaEntity.setUserName(user.getUserName());
        userJpaEntity.setFirstName(user.getFirstName());
        userJpaEntity.setLastName(user.getLastName());
        userJpaEntity.setEmail(user.getEmail());
        return userJpaEntity;
    }

    public static Set<UserJpaEntity> from(List<User> users) {
            return Optional.ofNullable(users)
                    .map(userList -> userList.stream()
                            .map(UserMapper::from)
                            .collect(Collectors.toSet()))
                    .orElseGet(HashSet::new);
    }

}
