package com.clean.architecture.sharedexpenses.user_groups.domain.service;

import com.clean.architecture.sharedexpenses.user_groups.domain.exception.GroupNameUsedBadRequestException;
import com.clean.architecture.sharedexpenses.user_groups.domain.exception.GroupNotFoundException;
import com.clean.architecture.sharedexpenses.user_groups.domain.exception.UserAlreadyIncludedBadRequestException;
import com.clean.architecture.sharedexpenses.user_groups.domain.model.Group;
import com.clean.architecture.sharedexpenses.user_groups.domain.model.User;
import com.clean.architecture.sharedexpenses.user_groups.domain.port.out.FindGroupByIdRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GroupService {

    private final FindGroupByIdRepository findGroupByIdRepository;

    public void existsGroupName(String groupName) {

        findGroupByIdRepository.findByGroupName(groupName).ifPresent(group -> {
            throw new GroupNameUsedBadRequestException();
        });

    }

    public Group retrieveGroup(String id) {
        return findGroupByIdRepository.findById(id).orElseThrow(GroupNotFoundException::new);
    }

    public void checkIsNotAlreadyIncluded(Group group, User user) {
        if(group.isIncluded(user)){
            throw new UserAlreadyIncludedBadRequestException();
        }
    }
}
