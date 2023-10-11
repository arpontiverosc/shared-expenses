package com.clean.architecture.sharedexpenses.user_groups.infrastructure.out.jpa.impl;

import com.clean.architecture.sharedexpenses.user_groups.domain.model.Group;
import com.clean.architecture.sharedexpenses.user_groups.domain.model.User;
import com.clean.architecture.sharedexpenses.user_groups.domain.port.out.FindGroupByIdRepository;
import com.clean.architecture.sharedexpenses.user_groups.domain.port.out.SaveGroupRepository;
import com.clean.architecture.sharedexpenses.user_groups.infrastructure.out.jpa.SpringDataGroupRepository;
import com.clean.architecture.sharedexpenses.user_groups.infrastructure.out.jpa.SpringDataUserRepository;
import com.clean.architecture.sharedexpenses.user_groups.infrastructure.out.jpa.mapper.GroupMapper;
import com.clean.architecture.sharedexpenses.user_groups.infrastructure.out.jpa.model.GroupJpaEntity;
import com.clean.architecture.sharedexpenses.user_groups.infrastructure.out.jpa.model.UserJpaEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JpaGroupRepositoryImpl implements SaveGroupRepository, FindGroupByIdRepository {


    private final SpringDataGroupRepository springDataGroupRepository;
    private final SpringDataUserRepository springDataUserRepository;


    private void addUserToGroup(GroupJpaEntity groupJpaEntity, Group group) {

        Set<UserJpaEntity> entityUsers = groupJpaEntity.getUsers();

        List<String> usersAddedIds = entityUsers.stream().map(UserJpaEntity::getId).toList();
        List<String> domainUsers = group.getUsers().stream().map(User::getId).toList();

        List<String> notIncludedUsers = domainUsers.stream().filter(user -> !usersAddedIds.contains(user)).collect(Collectors.toList());

        List<UserJpaEntity> userJpaEntities = springDataUserRepository.findAllById(notIncludedUsers);

        groupJpaEntity.getUsers().addAll(userJpaEntities);
        springDataGroupRepository.save(groupJpaEntity);

        userJpaEntities.forEach(userJpaEntityItem -> {
            userJpaEntityItem.getGroups().add(groupJpaEntity);
            springDataUserRepository.save(userJpaEntityItem);
        });

    }

    @Override
    public Group save(Group group) {

        GroupJpaEntity groupJpaEntityToSave = GroupMapper.from(group);
        Optional<GroupJpaEntity> groupJpaEntity = springDataGroupRepository.findById(group.getId());

        if (groupJpaEntity.isPresent()) {
            addUserToGroup(groupJpaEntity.get(), group);
            //merge if necessary in future
        } else {
            groupJpaEntityToSave = springDataGroupRepository.save(groupJpaEntityToSave);
        }

        return GroupMapper.from(groupJpaEntityToSave);
    }

    @Override
    public Optional<Group> findByGroupName(String groupName) {
        return springDataGroupRepository.findByGroupName(groupName).map(GroupMapper::from);
    }

    @Override
    public Optional<Group> findById(String id) {
        return springDataGroupRepository.findById(id).map(GroupMapper::from);
    }
}
