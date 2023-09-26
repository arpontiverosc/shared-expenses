package com.clean.architecture.sharedexpenses.user_groups.infrastructure.out.jpa;

import com.clean.architecture.sharedexpenses.user_groups.infrastructure.out.jpa.model.UserJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface SpringDataUserRepository extends JpaRepository<UserJpaEntity, String> {
    Optional<UserJpaEntity> findByUserName(String userName);
}
