package com.clean.architecture.sharedexpenses.user_groups.domain.service;

import com.clean.architecture.sharedexpenses.user_groups.domain.port.out.FindGroupByIdRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GroupService {

    private final FindGroupByIdRepository findGroupByIdRepository;

    public void existsGroupName(String groupName) {

        findGroupByIdRepository

    }

}
