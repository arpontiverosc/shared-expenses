package com.clean.architecture.sharedexpenses.balances.infrastructure.out.jpa.impl;


import com.clean.architecture.sharedexpenses.balances.domain.port.out.ExistsUserByIdRepository;
import com.clean.architecture.sharedexpenses.balances.infrastructure.out.jpa.SpringDataUserTempRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class JpaUserTempRepositoryImpl implements ExistsUserByIdRepository {

    private final SpringDataUserTempRepository springDataUserTempRepository;

    @Override
    public boolean existsById(String userId) {
        return springDataUserTempRepository.existsById(userId);
    }
}
