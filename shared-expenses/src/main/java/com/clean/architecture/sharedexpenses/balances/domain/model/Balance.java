package com.clean.architecture.sharedexpenses.balances.domain.model;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Balance {

    @EqualsAndHashCode.Include
    private String id;
    private String balanceName;
    private String description;
    private String groupId;


}
