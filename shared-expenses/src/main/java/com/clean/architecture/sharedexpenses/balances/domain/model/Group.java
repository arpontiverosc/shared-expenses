package com.clean.architecture.sharedexpenses.balances.domain.model;

import lombok.*;

import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Group {

    @EqualsAndHashCode.Include
    private String id;
    private Set<String> membersIds;

}
