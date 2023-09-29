package com.clean.architecture.sharedexpenses.user_groups.infrastructure.in.rest.v1.model.response;

import com.clean.architecture.sharedexpenses.user_groups.domain.model.Group;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class CreateGroupResponse {

    private String id;

}
