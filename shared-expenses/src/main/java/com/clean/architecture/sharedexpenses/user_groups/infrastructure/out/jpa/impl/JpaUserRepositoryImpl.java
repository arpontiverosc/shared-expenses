package com.clean.architecture.sharedexpenses.user_groups.infrastructure.out.jpa.impl;

import com.clean.architecture.sharedexpenses.user_groups.domain.model.User;
import com.clean.architecture.sharedexpenses.user_groups.domain.port.out.SaveUserRepository;
import com.clean.architecture.sharedexpenses.user_groups.infrastructure.out.jpa.SpringDataUserRepository;
import com.clean.architecture.sharedexpenses.user_groups.infrastructure.out.jpa.mapper.UserMapper;
import com.clean.architecture.sharedexpenses.user_groups.infrastructure.out.jpa.merger.UserJpaEntityMerger;
import com.clean.architecture.sharedexpenses.user_groups.infrastructure.out.jpa.model.UserJpaEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class JpaUserRepositoryImpl implements SaveUserRepository {

    private final SpringDataUserRepository springDataUserRepository;

    @Override
    public User save(User user) {
        UserJpaEntity userJpaEntity = springDataUserRepository.findById(user.getId()).orElseGet(UserJpaEntity::new);
        UserJpaEntityMerger.from(user, userJpaEntity);
        return UserMapper.from(springDataUserRepository.save(userJpaEntity));
    }
}
