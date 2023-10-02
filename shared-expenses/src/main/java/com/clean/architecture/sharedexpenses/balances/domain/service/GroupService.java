package com.clean.architecture.sharedexpenses.balances.domain.service;

import com.clean.architecture.sharedexpenses.balances.domain.port.out.ExistsGroupByIdRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GroupService {

   private final ExistsGroupByIdRepository existsGroupByIdRepository;

    public void existsGroup(String groupId) {

        //existsGroupByIdRepository.exists(groupId)

    }

}
