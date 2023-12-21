package com.clean.architecture.sharedexpenses.balances.use_case;

import com.clean.architecture.sharedexpenses.balances.domain.model.Balance;
import com.clean.architecture.sharedexpenses.balances.domain.model.Group;
import com.clean.architecture.sharedexpenses.balances.domain.port.in.CreateBalanceUseCase;
import com.clean.architecture.sharedexpenses.balances.domain.port.in.model.CreateBalanceCommand;
import com.clean.architecture.sharedexpenses.balances.domain.port.out.SaveBalanceRepository;
import com.clean.architecture.sharedexpenses.balances.domain.service.GroupServiceTemp;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.time.OffsetDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreateBalanceUseCaseImpl implements CreateBalanceUseCase {

    private final SaveBalanceRepository saveBalanceRepository;
    private final GroupServiceTemp groupService;

    @Transactional
    @Override
    public Balance execute(CreateBalanceCommand command) {
       return saveBalanceRepository.save(createBalanceFromCommand(command));
    }


    private Balance createBalanceFromCommand(CreateBalanceCommand command){
        return Balance.Builder.builder()
                            .id(UUID.randomUUID().toString())
                            .balanceName(command.getBalanceName())
                            .description(command.getDescription())
                            .group(groupService.retrieveGroup(command.getGroupId()))
                            .createdAt(OffsetDateTime.now())
                            .build();

    }
}
