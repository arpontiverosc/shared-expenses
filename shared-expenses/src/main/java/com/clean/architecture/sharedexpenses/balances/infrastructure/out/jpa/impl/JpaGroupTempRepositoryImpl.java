package com.clean.architecture.sharedexpenses.balances.infrastructure.out.jpa.impl;

import com.clean.architecture.sharedexpenses.balances.domain.model.Group;
import com.clean.architecture.sharedexpenses.balances.domain.port.out.ExistsGroupByIdRepository;
import com.clean.architecture.sharedexpenses.balances.domain.port.out.FindGroupByIdRepository;
import com.clean.architecture.sharedexpenses.balances.infrastructure.out.jpa.SpringDataGroupTempRepository;
import com.clean.architecture.sharedexpenses.balances.infrastructure.out.jpa.mapper.GroupMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JpaGroupTempRepositoryImpl implements ExistsGroupByIdRepository, FindGroupByIdRepository {

    private final SpringDataGroupTempRepository springDataGroupRepository;

    @Override
    public boolean existsById(String groupId) {
        return springDataGroupRepository.existsById(groupId);
    }

    @Override
    public Optional<Group> findById(String groupId) {
        return springDataGroupRepository.findById(groupId).map(GroupMapper::from);
    }
}
