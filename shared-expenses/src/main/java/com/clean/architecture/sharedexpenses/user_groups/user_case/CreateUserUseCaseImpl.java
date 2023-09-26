package com.clean.architecture.sharedexpenses.user_groups.user_case;

import com.clean.architecture.sharedexpenses.user_groups.domain.model.User;
import com.clean.architecture.sharedexpenses.user_groups.domain.port.in.CreateUserUseCase;
import com.clean.architecture.sharedexpenses.user_groups.domain.port.in.model.CreateUserCommand;

import com.clean.architecture.sharedexpenses.user_groups.domain.port.out.SaveUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;


@Service
@RequiredArgsConstructor
public class CreateUserUseCaseImpl implements CreateUserUseCase {

    private final SaveUserRepository saveUserRepository;

    @Transactional
    @Override
    public User execute(CreateUserCommand command) {
        validateCommand(command);
        User user = createUserFromCommand(command);
        return saveUserRepository.save(user);
    }

    private User createUserFromCommand(CreateUserCommand command) {
            User user = new User();
            user.setId(UUID.randomUUID().toString());
            user.setUserName(command.getUserName());
            user.setFirstName(command.getFirstName());
            user.setLastName(command.getLastName());
            user.setEmail(command.getEmail());
            return user;
    }

    private void validateCommand(CreateUserCommand command) {
    }
}
