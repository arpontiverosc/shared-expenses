package com.clean.architecture.sharedexpenses.user_groups.domain.port.in;

import com.clean.architecture.sharedexpenses.user_groups.domain.model.User;
import com.clean.architecture.sharedexpenses.user_groups.domain.port.in.model.DetailUserQuery;
import jakarta.validation.Valid;

public interface DetailUserUseCase {
    User execute(@Valid DetailUserQuery query);
}
