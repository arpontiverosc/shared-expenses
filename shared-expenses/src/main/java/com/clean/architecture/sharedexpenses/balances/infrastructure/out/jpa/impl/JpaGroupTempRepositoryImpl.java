package com.clean.architecture.sharedexpenses.balances.infrastructure.out.jpa.impl;

import com.clean.architecture.sharedexpenses.balances.domain.port.out.ExistsGroupByIdRepository;
import com.clean.architecture.sharedexpenses.balances.infrastructure.out.jpa.SpringDataGroupTempRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JpaGroupTempRepositoryImpl implements ExistsGroupByIdRepository {

    private final SpringDataGroupTempRepository springDataGroupRepository;

    @Override
    public boolean existsById(String groupId) {
        return springDataGroupRepository.existsById(groupId);
    }
}
