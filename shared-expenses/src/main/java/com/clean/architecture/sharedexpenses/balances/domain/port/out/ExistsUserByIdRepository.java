package com.clean.architecture.sharedexpenses.balances.domain.port.out;

import com.clean.architecture.sharedexpenses.balances.domain.model.User;

import java.util.Optional;

public interface ExistsUserByIdRepository {
    boolean existsById(String userId);
}
