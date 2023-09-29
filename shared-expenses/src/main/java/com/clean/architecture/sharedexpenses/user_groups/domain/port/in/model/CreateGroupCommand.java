package com.clean.architecture.sharedexpenses.user_groups.domain.port.in.model;

import com.clean.architecture.sharedexpenses.user_groups.domain.util.GroupErrorCode;
import com.clean.architecture.sharedexpenses.user_groups.domain.util.GroupFieldValidation;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateGroupCommand {

    @NotNull(message = GroupErrorCode.GROUP_NAME_MANDATORY)
    @Size(min = GroupFieldValidation.GROUP_NAME_MIN_LENGTH, message = GroupErrorCode.GROUP_NAME_MIN_LENGTH)
    @Size(max = GroupFieldValidation.GROUP_NAME_MAX_LENGTH, message = GroupErrorCode.GROUP_NAME_MAX_LENGTH)
    private String groupName;

}
