package com.clean.architecture.sharedexpenses.user_groups.domain.port.out;

import com.clean.architecture.sharedexpenses.user_groups.domain.model.Group;

public interface SaveGroupRepository {
    Group save(Group group);
}
