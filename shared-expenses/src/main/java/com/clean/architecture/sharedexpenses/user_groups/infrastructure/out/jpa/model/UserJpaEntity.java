package com.clean.architecture.sharedexpenses.user_groups.infrastructure.out.jpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class UserJpaEntity {

    @Id
    @EqualsAndHashCode.Include private String id;
    private String userName;
    private String firstName;
    private String lastName;
    private String email;

}
