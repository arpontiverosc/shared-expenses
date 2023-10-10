package com.clean.architecture.sharedexpenses.balances.infrastructure.out.jpa;


import com.clean.architecture.sharedexpenses.balances.infrastructure.model.UserTempJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataUserTempRepository extends JpaRepository<UserTempJpaEntity, String> {

}
