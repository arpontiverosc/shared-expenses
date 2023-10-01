package com.clean.architecture.sharedexpenses.user_groups.user_case;

import com.clean.architecture.sharedexpenses.user_groups.domain.model.Group;
import com.clean.architecture.sharedexpenses.user_groups.domain.port.in.CreateGroupUseCase;
import com.clean.architecture.sharedexpenses.user_groups.domain.port.in.model.CreateGroupCommand;
import com.clean.architecture.sharedexpenses.user_groups.domain.port.out.SaveGroupRepository;
import com.clean.architecture.sharedexpenses.user_groups.domain.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreateGroupUseCaseImpl implements CreateGroupUseCase {

    private final SaveGroupRepository saveGroupRepository;
    private final GroupService groupService;

    @Override
    public Group execute(CreateGroupCommand command) {
        validateCommand(command);
        Group group = createGroupFromCommand(command);
        groupService.existsGroupName(group.getGroupName());
        return saveGroupRepository.save(group);
    }

    private Group createGroupFromCommand(CreateGroupCommand command) {
        Group group = new Group();
        group.setId(UUID.randomUUID().toString());
        group.setGroupName(command.getGroupName());
        return group;
    }

    private void validateCommand(CreateGroupCommand command) {
    }

}
