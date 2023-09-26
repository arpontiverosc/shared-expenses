package com.clean.architecture.sharedexpenses.user_groups.infrastructure.out.jpa.impl;

import com.clean.architecture.sharedexpenses.user_groups.domain.model.User;
import com.clean.architecture.sharedexpenses.user_groups.domain.port.out.FindUserByIdRepository;
import com.clean.architecture.sharedexpenses.user_groups.domain.port.out.SaveUserRepository;
import com.clean.architecture.sharedexpenses.user_groups.infrastructure.out.jpa.SpringDataUserRepository;
import com.clean.architecture.sharedexpenses.user_groups.infrastructure.out.jpa.mapper.UserMapper;
import com.clean.architecture.sharedexpenses.user_groups.infrastructure.out.jpa.merger.UserJpaEntityMerger;
import com.clean.architecture.sharedexpenses.user_groups.infrastructure.out.jpa.model.UserJpaEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class JpaUserRepositoryImpl implements SaveUserRepository, FindUserByIdRepository {

    private final SpringDataUserRepository springDataUserRepository;

    @Override
    public User save(User user) {
        UserJpaEntity userJpaEntity = springDataUserRepository.findById(user.getId()).orElseGet(UserJpaEntity::new);
        UserJpaEntityMerger.from(user, userJpaEntity);
        UserJpaEntityMerger.from(user, new UserJpaEntity());
        return UserMapper.from(springDataUserRepository.save(userJpaEntity));
    }

    @Override
    public Optional<User> findById(String id) {
        return springDataUserRepository.findById(id).map(UserMapper::from);
    }

    @Override
    public Optional<User> findByUserName(String userName) {
        return springDataUserRepository.findByUserName(userName).map(UserMapper::from);
    }
}
