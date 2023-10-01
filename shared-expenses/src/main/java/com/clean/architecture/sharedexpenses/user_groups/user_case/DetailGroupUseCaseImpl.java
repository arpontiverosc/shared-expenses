package com.clean.architecture.sharedexpenses.user_groups.user_case;

import com.clean.architecture.sharedexpenses.user_groups.domain.model.Group;
import com.clean.architecture.sharedexpenses.user_groups.domain.port.in.DetailGroupUseCase;
import com.clean.architecture.sharedexpenses.user_groups.domain.port.in.model.DetailGroupQuery;
import com.clean.architecture.sharedexpenses.user_groups.domain.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DetailGroupUseCaseImpl implements DetailGroupUseCase {

    private final GroupService groupService;

    @Transactional(readOnly = true)
    @Override
    public Group execute(DetailGroupQuery query) {
        return groupService.retrieveGroup(query.getId());
    }
}
