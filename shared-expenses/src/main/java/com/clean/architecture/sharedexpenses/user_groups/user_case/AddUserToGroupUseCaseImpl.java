package com.clean.architecture.sharedexpenses.user_groups.user_case;

import com.clean.architecture.sharedexpenses.user_groups.domain.model.Group;
import com.clean.architecture.sharedexpenses.user_groups.domain.model.User;
import com.clean.architecture.sharedexpenses.user_groups.domain.port.in.AddUserToGroupUseCase;
import com.clean.architecture.sharedexpenses.user_groups.domain.port.in.model.AddUserToGroupCommand;
import com.clean.architecture.sharedexpenses.user_groups.domain.port.out.SaveGroupRepository;
import com.clean.architecture.sharedexpenses.user_groups.domain.service.GroupService;
import com.clean.architecture.sharedexpenses.user_groups.domain.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AddUserToGroupUseCaseImpl implements AddUserToGroupUseCase  {

    private final GroupService groupService;
    private final UserService userService;
    private final SaveGroupRepository saveGroupRepository;


    @Override
    public void execute(AddUserToGroupCommand command) {
         Group group = groupService.retrieveGroup(command.getGroupId());
         User user = userService.retrieveUser(command.getUserId());
         groupService.checkIsNotAlreadyIncluded(group, user);
         group.addUser(user);
         saveGroupRepository.save(group);
    }
}
