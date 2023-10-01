package com.clean.architecture.sharedexpenses.user_groups.infrastructure.out.jpa;

import com.clean.architecture.sharedexpenses.user_groups.infrastructure.out.jpa.model.GroupJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataGroupRepository extends JpaRepository<GroupJpaEntity, String> {
    Optional<GroupJpaEntity> findByGroupName(String userName);
}
