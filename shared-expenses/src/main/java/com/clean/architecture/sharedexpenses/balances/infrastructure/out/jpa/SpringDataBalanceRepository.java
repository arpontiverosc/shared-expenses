package com.clean.architecture.sharedexpenses.balances.infrastructure.out.jpa;

import com.clean.architecture.sharedexpenses.balances.infrastructure.model.BalanceJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataBalanceRepository extends JpaRepository<BalanceJpaEntity, String> {
}
