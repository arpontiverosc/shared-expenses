package com.clean.architecture.sharedexpenses.user_groups.infrastructure.in.rest.v1.model.response;

import com.clean.architecture.sharedexpenses.user_groups.domain.model.Group;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class GroupDetailResponse {

    private String id;
    private String userName;

}
