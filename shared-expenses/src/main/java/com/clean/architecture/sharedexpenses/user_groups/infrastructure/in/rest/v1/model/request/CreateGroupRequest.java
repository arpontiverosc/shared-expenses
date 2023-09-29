package com.clean.architecture.sharedexpenses.user_groups.infrastructure.in.rest.v1.model.request;

import com.clean.architecture.sharedexpenses.user_groups.domain.util.GroupErrorCode;
import com.clean.architecture.sharedexpenses.user_groups.domain.util.GroupFieldValidation;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CreateGroupRequest {

    @NotNull(message = GroupErrorCode.GROUP_NAME_MANDATORY)
    @Size(min = GroupFieldValidation.GROUP_NAME_MIN_LENGTH, message = GroupErrorCode.GROUP_NAME_MIN_LENGTH)
    @Size(max = GroupFieldValidation.GROUP_NAME_MAX_LENGTH, message = GroupErrorCode.GROUP_NAME_MAX_LENGTH)
    private String groupName;
}
