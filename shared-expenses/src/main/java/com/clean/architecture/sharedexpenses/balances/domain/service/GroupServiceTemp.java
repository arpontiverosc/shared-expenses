package com.clean.architecture.sharedexpenses.balances.domain.service;

import com.clean.architecture.sharedexpenses.balances.domain.port.out.ExistsGroupByIdRepository;
import com.clean.architecture.sharedexpenses.user_groups.domain.exception.GroupNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GroupServiceTemp {

    private final ExistsGroupByIdRepository existsGroupByIdRepository;

    public void existsGroup(String groupId) {
        if (!existsGroupByIdRepository.existsById(groupId)) throw new GroupNotFoundException();
    }

}
