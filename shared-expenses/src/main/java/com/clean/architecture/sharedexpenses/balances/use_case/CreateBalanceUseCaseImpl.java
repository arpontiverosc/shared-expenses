package com.clean.architecture.sharedexpenses.balances.use_case;

import com.clean.architecture.sharedexpenses.balances.domain.model.Balance;
import com.clean.architecture.sharedexpenses.balances.domain.port.in.CreateBalanceUseCase;
import com.clean.architecture.sharedexpenses.balances.domain.port.in.model.CreateBalanceCommand;
import com.clean.architecture.sharedexpenses.balances.domain.port.out.SaveBalanceRepository;
import com.clean.architecture.sharedexpenses.balances.domain.service.GroupService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreateBalanceUseCaseImpl implements CreateBalanceUseCase {

    private final SaveBalanceRepository saveBalanceRepository;
    private final GroupService groupService;

    @Transactional
    @Override
    public Balance execute(CreateBalanceCommand command) {
       groupService.existsGroup(command.getGroupId());
       return saveBalanceRepository.save(createBalanceFromCommand(command));
    }


    private Balance createBalanceFromCommand(CreateBalanceCommand command){
        Balance balance = new Balance();
        balance.setId(UUID.randomUUID().toString());
        balance.setBalanceName(command.getBalanceName());
        balance.setDescription(command.getDescription());
        balance.setGroupId(command.getGroupId());
        return balance;
    }
}
