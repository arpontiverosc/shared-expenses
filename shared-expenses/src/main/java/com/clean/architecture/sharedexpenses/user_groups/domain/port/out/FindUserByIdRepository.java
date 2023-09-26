package com.clean.architecture.sharedexpenses.user_groups.domain.port.out;
import com.clean.architecture.sharedexpenses.user_groups.domain.model.User;

import java.util.Optional;

public interface FindUserByIdRepository {
    Optional<User> findById(String id);
}
