package com.clean.architecture.sharedexpenses.balances.infrastructure.model;

import com.clean.architecture.sharedexpenses.balances.domain.model.Expense;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Table(name = "expenses")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ExpenseJpaEntity {

    @Id
    @EqualsAndHashCode.Include private String id;

    private String user_id;
    private String group_id;
    private String currency;
    private String description;
    private String price;

    private BalanceJpaEntity balance;
    private OffsetDateTime created_at; 


}
