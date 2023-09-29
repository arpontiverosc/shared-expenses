package com.clean.architecture.sharedexpenses.user_groups.domain.port.in;

import com.clean.architecture.sharedexpenses.user_groups.domain.model.Group;
import com.clean.architecture.sharedexpenses.user_groups.domain.port.in.model.DetailGroupQuery;
import jakarta.validation.Valid;

public interface DetailGroupUseCase {
    Group execute(@Valid DetailGroupQuery query);
}
