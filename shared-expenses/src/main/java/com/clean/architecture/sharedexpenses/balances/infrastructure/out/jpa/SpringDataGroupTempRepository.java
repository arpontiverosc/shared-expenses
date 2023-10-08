package com.clean.architecture.sharedexpenses.balances.infrastructure.out.jpa;


import com.clean.architecture.sharedexpenses.balances.infrastructure.model.GroupTempJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataGroupTempRepository extends JpaRepository<GroupTempJpaEntity, String> {

}
