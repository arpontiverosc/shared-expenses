package com.clean.architecture.sharedexpenses.user_groups.domain.model;


import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class User {

    @EqualsAndHashCode.Include private String id;
    private String userName;
    private String firstName;
    private String lastName;
    private String email;

}
