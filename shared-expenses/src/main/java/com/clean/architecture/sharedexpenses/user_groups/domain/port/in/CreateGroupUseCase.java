package com.clean.architecture.sharedexpenses.user_groups.domain.port.in;

import com.clean.architecture.sharedexpenses.user_groups.domain.model.Group;
import com.clean.architecture.sharedexpenses.user_groups.domain.port.in.model.CreateGroupCommand;
import jakarta.validation.Valid;

public interface CreateGroupUseCase {

    Group execute(@Valid CreateGroupCommand command);

}
