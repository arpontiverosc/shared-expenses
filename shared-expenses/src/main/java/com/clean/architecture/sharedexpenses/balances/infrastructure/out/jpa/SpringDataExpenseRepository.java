package com.clean.architecture.sharedexpenses.balances.infrastructure.out.jpa;

import com.clean.architecture.sharedexpenses.balances.infrastructure.model.ExpenseJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataExpenseRepository extends JpaRepository<ExpenseJpaEntity, String> {
}
