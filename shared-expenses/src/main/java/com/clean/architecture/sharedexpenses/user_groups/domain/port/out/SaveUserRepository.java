package com.clean.architecture.sharedexpenses.user_groups.domain.port.out;

import com.clean.architecture.sharedexpenses.user_groups.domain.model.User;

public interface SaveUserRepository {
    User save(User user);
}
