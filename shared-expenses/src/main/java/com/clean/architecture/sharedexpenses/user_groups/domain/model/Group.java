package com.clean.architecture.sharedexpenses.user_groups.domain.model;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Group {

    private Long id;
    private String groupName;

}
