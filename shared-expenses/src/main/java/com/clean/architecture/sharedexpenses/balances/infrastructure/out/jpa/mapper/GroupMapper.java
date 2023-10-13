package com.clean.architecture.sharedexpenses.balances.infrastructure.out.jpa.mapper;


import com.clean.architecture.sharedexpenses.balances.domain.model.Group;
import com.clean.architecture.sharedexpenses.balances.infrastructure.model.GroupTempJpaEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GroupMapper {
    public static Group from(GroupTempJpaEntity groupJpaEntity) {
        Group group = new Group();
        group.setId(groupJpaEntity.getId());
        group.setMembersIds(groupJpaEntity.getUsers().stream().map(user -> user.getId()).collect(Collectors.toSet()));
        return group;
    }

}
