package com.clean.architecture.sharedexpenses.user_groups.user_case;

import com.clean.architecture.sharedexpenses.user_groups.domain.model.User;
import com.clean.architecture.sharedexpenses.user_groups.domain.port.in.CreateUserUseCase;
import com.clean.architecture.sharedexpenses.user_groups.domain.port.in.model.CreateUserCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CreateUserUseCaseImpl implements CreateUserUseCase {


    @Override
    public User execute(CreateUserCommand command) {
        return null;

    }
}
