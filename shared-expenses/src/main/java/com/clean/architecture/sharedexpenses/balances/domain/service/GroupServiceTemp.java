package com.clean.architecture.sharedexpenses.balances.domain.service;

import com.clean.architecture.sharedexpenses.balances.domain.exception.GroupNotFoundException;
import com.clean.architecture.sharedexpenses.balances.domain.model.Group;
import com.clean.architecture.sharedexpenses.balances.domain.port.out.ExistsGroupByIdRepository;

import com.clean.architecture.sharedexpenses.balances.domain.port.out.FindGroupByIdRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GroupServiceTemp {

    private final ExistsGroupByIdRepository existsGroupByIdRepository;
    private final FindGroupByIdRepository findGroupByIdRepository;

    public void existsGroup(String groupId) {
        if (!existsGroupByIdRepository.existsById(groupId)) throw new GroupNotFoundException();
    }

    public Group retrieveGroup(String id) {
        return findGroupByIdRepository.findById(id).orElseThrow(GroupNotFoundException::new);
    }

}
