package com.clean.architecture.sharedexpenses.user_groups.user_case;

import com.clean.architecture.sharedexpenses.user_groups.domain.model.User;
import com.clean.architecture.sharedexpenses.user_groups.domain.port.in.DetailUserUseCase;
import com.clean.architecture.sharedexpenses.user_groups.domain.port.in.model.DetailUserQuery;
import com.clean.architecture.sharedexpenses.user_groups.domain.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DetailUserUseCaseImpl implements DetailUserUseCase {

    private final UserService userService;

    @Transactional(readOnly = true)
    @Override
    public User execute(DetailUserQuery query) {
        return userService.retrieveUser(query.getId());
    }
}
