package com.clean.architecture.sharedexpenses.balances.infrastructure.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.OffsetDateTime;

@Entity
@Table(name = "balances")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class BalanceJpaEntity {

    @Id
    @EqualsAndHashCode.Include private String id;
    private String balanceName;
    private String description;
    private String groupId;
    private OffsetDateTime createdAt;

}
