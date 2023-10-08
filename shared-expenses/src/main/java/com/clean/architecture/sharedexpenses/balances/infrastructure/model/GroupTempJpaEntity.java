package com.clean.architecture.sharedexpenses.balances.infrastructure.model;

import com.clean.architecture.sharedexpenses.user_groups.infrastructure.out.jpa.model.UserJpaEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "groups")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class GroupTempJpaEntity {

    @Id
    @EqualsAndHashCode.Include private String id;
    private String groupName;

    @ManyToMany(mappedBy = "groups")
    private Set<UserJpaEntity> users;



}
