package com.clean.architecture.sharedexpenses.user_groups.domain.port.in.model;

import com.clean.architecture.sharedexpenses.user_groups.domain.util.GroupErrorCode;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AddUserToGroupCommand {

    @NotNull(message = GroupErrorCode.ID_MANDATORY)
    String userId;

    @NotNull(message = GroupErrorCode.ID_MANDATORY)
    String groupId;
}
