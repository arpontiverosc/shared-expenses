package com.clean.architecture.sharedexpenses.user_groups.user_case;

import com.clean.architecture.sharedexpenses.user_groups.domain.model.Group;
import com.clean.architecture.sharedexpenses.user_groups.domain.port.in.DetailGroupUseCase;
import com.clean.architecture.sharedexpenses.user_groups.domain.port.in.model.DetailGroupQuery;

public class DetailGroupUseCaseImpl implements DetailGroupUseCase {
    @Override
    public Group execute(DetailGroupQuery query) {
        return null;
    }
}
