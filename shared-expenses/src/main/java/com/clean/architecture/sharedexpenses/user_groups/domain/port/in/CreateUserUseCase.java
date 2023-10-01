package com.clean.architecture.sharedexpenses.user_groups.domain.port.in;

import com.clean.architecture.sharedexpenses.user_groups.domain.model.User;
import com.clean.architecture.sharedexpenses.user_groups.domain.port.in.model.CreateUserCommand;
import jakarta.validation.Valid;

public interface CreateUserUseCase {

    User execute(@Valid CreateUserCommand command);

}
