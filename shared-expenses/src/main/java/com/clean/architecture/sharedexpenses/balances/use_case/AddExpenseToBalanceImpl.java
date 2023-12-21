package com.clean.architecture.sharedexpenses.balances.use_case;

import com.clean.architecture.sharedexpenses.balances.domain.model.Balance;
import com.clean.architecture.sharedexpenses.balances.domain.model.Expense;
import com.clean.architecture.sharedexpenses.balances.domain.port.in.AddExpenseToBalance;
import com.clean.architecture.sharedexpenses.balances.domain.port.in.model.AddExpenseToBalanceCommand;
import com.clean.architecture.sharedexpenses.balances.domain.port.out.SaveBalanceRepository;
import com.clean.architecture.sharedexpenses.balances.domain.service.BalanceService;
import com.clean.architecture.sharedexpenses.balances.domain.service.GroupServiceTemp;
import com.clean.architecture.sharedexpenses.balances.domain.service.UserServiceTemp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AddExpenseToBalanceImpl implements AddExpenseToBalance {

    private final GroupServiceTemp groupService;
    private final UserServiceTemp userServiceTemp;
    private final BalanceService balanceService;
    private final SaveBalanceRepository saveBalanceRepository;

    @Transactional
    @Override
    public Expense execute(AddExpenseToBalanceCommand command) {

        groupService.existsGroup(command.getGroupId());
        userServiceTemp.existsUser(command.getUserId());
        //groupService.isUserPartOftheGroup(command.getUserId());
        Balance balance = balanceService.retrieveBalance(command.getBalanceId());
        Expense expense = createExpenseFromCommand(command);
        balance.addExpense(expense);
        saveBalanceRepository.save(balance);
        return expense;

    }


    private Expense createExpenseFromCommand(AddExpenseToBalanceCommand command) {
        return Expense.Builder.builder()
                .id(UUID.randomUUID().toString())
                .balanceId(command.getBalanceId())
                .price(command.getPrice())
                .description(command.getDescription())
                .userId(command.getUserId())
                .groupId(command.getGroupId())
                .currency(command.getCurrency())
                .price(command.getPrice())
                .createdAt(OffsetDateTime.now())
                .build();
    }

}
