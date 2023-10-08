package com.clean.architecture.sharedexpenses.balances.domain.port.out;
import com.clean.architecture.sharedexpenses.balances.domain.model.Group;

import java.util.Optional;

public interface ExistsGroupByIdRepository {
    Optional<Group> exists(String groupId);
}
