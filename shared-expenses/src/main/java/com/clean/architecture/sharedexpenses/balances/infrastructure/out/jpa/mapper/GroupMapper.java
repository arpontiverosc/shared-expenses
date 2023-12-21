package com.clean.architecture.sharedexpenses.balances.infrastructure.out.jpa.mapper;


import com.clean.architecture.sharedexpenses.balances.domain.model.Group;
import com.clean.architecture.sharedexpenses.balances.infrastructure.model.GroupTempJpaEntity;
import com.clean.architecture.sharedexpenses.user_groups.infrastructure.out.jpa.model.UserJpaEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GroupMapper {
    public static Group from(GroupTempJpaEntity groupJpaEntity) {
        return Group.Builder.builder()
                                .id(groupJpaEntity.getId())
                                .membersIds(groupJpaEntity.getUsers().stream().map(UserJpaEntity::getId).collect(Collectors.toSet()))
                                 .build();
    }

}
