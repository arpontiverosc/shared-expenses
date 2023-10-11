package com.clean.architecture.sharedexpenses.balances.infrastructure.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

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

    private String userId;
    private String groupId;
    private String currency;
    private String description;
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "balance_id", referencedColumnName = "id", nullable = false)
    private BalanceJpaEntity balance;

    private OffsetDateTime createdAt;


}
