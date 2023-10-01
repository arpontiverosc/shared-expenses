package com.clean.architecture.sharedexpenses.user_groups.infrastructure.in.rest.v1.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddUserToGroupRequest {

    private String userId;
}
