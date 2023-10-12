package com.clean.architecture.sharedexpenses.user_groups.infrastructure.in.rest.v1.model.request;

import com.clean.architecture.sharedexpenses.user_groups.domain.util.GroupErrorCode;
import com.clean.architecture.sharedexpenses.user_groups.domain.util.UserErrorCode;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddUserToGroupRequest {

    @NotNull(message = UserErrorCode.ID_MANDATORY)
    private String userId;
}
