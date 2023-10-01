package com.clean.architecture.sharedexpenses.user_groups.domain.port.out;

import com.clean.architecture.sharedexpenses.user_groups.domain.model.Group;

import java.util.Optional;

public interface FindGroupByIdRepository {
    Optional<Group> findByGroupName(String groupName);

    Optional<Group> findById(String id);
}
