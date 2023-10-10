package com.clean.architecture.sharedexpenses.balances.infrastructure.model;

import com.clean.architecture.sharedexpenses.user_groups.infrastructure.out.jpa.model.GroupJpaEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class UserTempJpaEntity {

    @Id
    @EqualsAndHashCode.Include private String id;
    private String userName;
    private String firstName;
    private String lastName;
    private String email;

    @ManyToMany
    @JoinTable(
            name = "users_groups",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id"))
    private Set<GroupJpaEntity> groups;

}
