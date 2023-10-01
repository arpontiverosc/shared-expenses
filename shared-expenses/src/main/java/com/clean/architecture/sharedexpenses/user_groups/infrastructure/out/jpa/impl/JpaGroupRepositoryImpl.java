package com.clean.architecture.sharedexpenses.user_groups.infrastructure.out.jpa.impl;

import com.clean.architecture.sharedexpenses.user_groups.domain.model.Group;
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


    @Override
    public Group save(Group group) {

        GroupJpaEntity groupJpaEntityToSave = GroupMapper.from(group);

        ///filtrar los usurios que no están en el grupo, es decir los nuevos

        Optional<GroupJpaEntity> groupJpaEntity = springDataGroupRepository.findById(group.getId());

        if(groupJpaEntity.isPresent()){

             Set<UserJpaEntity> entityUsers =  groupJpaEntity.get().getUsers();

             List<String> usersAddedIds = entityUsers.stream().map(user -> user.getId()).collect(Collectors.toList());

             List<String> domainUsers  = group.getUsers().stream().map(user -> user.getId()).collect(Collectors.toList());

             List<String> notIncludedUsers = domainUsers.stream()
                     .filter(user -> !usersAddedIds.contains(user))
                     .collect(Collectors.toList());

             //buscar ids, meterlos en la entidad
           List<UserJpaEntity> userJpaEntities = springDataUserRepository.findAllById(notIncludedUsers);

           groupJpaEntityToSave.getUsers().addAll(userJpaEntities);
         }


        return GroupMapper.from(springDataGroupRepository.save(groupJpaEntityToSave));
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
