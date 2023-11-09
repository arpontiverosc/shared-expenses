package com.clean.architecture.sharedexpenses.user_groups.use_case;

import com.clean.architecture.sharedexpenses.user_groups.domain.model.User;
import com.clean.architecture.sharedexpenses.user_groups.domain.port.in.CreateUserUseCase;
import com.clean.architecture.sharedexpenses.user_groups.domain.port.in.model.CreateUserCommand;

import com.clean.architecture.sharedexpenses.user_groups.domain.port.out.SaveUserRepository;
import com.clean.architecture.sharedexpenses.user_groups.domain.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;


@Service
@RequiredArgsConstructor
public class CreateUserUseCaseImpl implements CreateUserUseCase {

    private final SaveUserRepository saveUserRepository;
    private final UserService userService;

    @Transactional
    @Override
    public User execute(CreateUserCommand command) {
        validateCommand(command);
        User user = createUserFromCommand(command);
        userService.existsUserName(user.getUserName());
        return saveUserRepository.save(user);
    }

    private User createUserFromCommand(CreateUserCommand command) {

        return User.builder()
            .id(UUID.randomUUID().toString())
            .userName(command.getUserName())
            .firstName(command.getFirstName())
            .lastName(command.getLastName())
            .email(command.getEmail())
            .build() ;

    }

    private void validateCommand(CreateUserCommand command) {

    }
}
