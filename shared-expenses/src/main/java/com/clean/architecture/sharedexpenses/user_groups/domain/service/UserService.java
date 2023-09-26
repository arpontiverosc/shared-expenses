package com.clean.architecture.sharedexpenses.user_groups.domain.service;

import com.clean.architecture.sharedexpenses.user_groups.domain.exception.UserNameUsedBadRequestException;
import com.clean.architecture.sharedexpenses.user_groups.domain.exception.UserNotFoundException;
import com.clean.architecture.sharedexpenses.user_groups.domain.model.User;
import com.clean.architecture.sharedexpenses.user_groups.domain.port.out.FindUserByIdRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final FindUserByIdRepository findUserByIdRepository;
    public User retrieveUser(String id) {
        return findUserByIdRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    public void existsUserName(String userName) {
        findUserByIdRepository.findByUserName(userName)
                .ifPresent(user -> {
                    throw new UserNameUsedBadRequestException();
                });
    }
}
