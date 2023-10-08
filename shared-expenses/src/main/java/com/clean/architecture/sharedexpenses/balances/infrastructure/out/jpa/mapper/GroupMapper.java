package com.clean.architecture.sharedexpenses.balances.infrastructure.out.jpa.mapper;


import com.clean.architecture.sharedexpenses.balances.domain.model.Group;
import com.clean.architecture.sharedexpenses.balances.infrastructure.model.GroupTempJpaEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GroupMapper {
    public static Group from(GroupTempJpaEntity groupJpaEntity) {
        Group group = new Group();
        group.setId(groupJpaEntity.getId());
        group.setGroupName(groupJpaEntity.getGroupName());
        return group;
    }

}
