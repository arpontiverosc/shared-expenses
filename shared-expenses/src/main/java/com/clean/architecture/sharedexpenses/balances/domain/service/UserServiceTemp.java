package com.clean.architecture.sharedexpenses.balances.domain.service;


import com.clean.architecture.sharedexpenses.balances.domain.exception.UserNotFoundException;
import com.clean.architecture.sharedexpenses.balances.domain.port.out.ExistsUserByIdRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceTemp {

    private final ExistsUserByIdRepository existsUserByIdRepository;

    public void existsUser(String id) {
        if (!existsUserByIdRepository.existsById(id)) throw new UserNotFoundException();
    }


}
