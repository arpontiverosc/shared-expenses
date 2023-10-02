package com.clean.architecture.sharedexpenses.user_groups.infrastructure.out.jpa.mapper;

import com.clean.architecture.sharedexpenses.user_groups.domain.model.Group;
import com.clean.architecture.sharedexpenses.user_groups.infrastructure.out.jpa.model.GroupJpaEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GroupMapper {

    public static GroupJpaEntity from(Group group) {
        GroupJpaEntity groupJpaEntity = new GroupJpaEntity();
        groupJpaEntity.setId(group.getId());
        groupJpaEntity.setGroupName(group.getGroupName());
        groupJpaEntity.setUsers(UserMapper.from(group.getUsers()));
        return groupJpaEntity;
    }

    public static Group from(GroupJpaEntity groupJpaEntity) {
        Group group = new Group();
        group.setId(groupJpaEntity.getId());
        group.setGroupName(groupJpaEntity.getGroupName());
        group.setUsers(groupJpaEntity.getUsers().stream().map(UserMapper::from).toList());
        return group;
    }

}
