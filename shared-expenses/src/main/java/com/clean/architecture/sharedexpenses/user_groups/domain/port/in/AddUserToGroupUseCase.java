package com.clean.architecture.sharedexpenses.user_groups.domain.port.in;

import com.clean.architecture.sharedexpenses.user_groups.domain.port.in.model.AddUserToGroupCommand;
import jakarta.validation.Valid;

public interface AddUserToGroupUseCase {
    void execute(@Valid AddUserToGroupCommand from);

}
