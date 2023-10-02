package com.clean.architecture.sharedexpenses.balances.domain.port.in.model;

import com.clean.architecture.sharedexpenses.balances.domain.util.BalanceErrorCode;

import com.clean.architecture.sharedexpenses.balances.domain.util.BalanceFieldValidation;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CreateBalanceCommand {

    @NotNull(message = BalanceErrorCode.BALANCE_NAME_MANDATORY)
    @Size(min = BalanceFieldValidation.BALANCE_NAME_MIN_LENGTH, message = BalanceErrorCode.BALANCE_NAME_MIN_LENGTH)
    @Size(max = BalanceFieldValidation.BALANCE_NAME_MAX_LENGTH, message = BalanceErrorCode.BALANCE_NAME_MAX_LENGTH)
    private String balanceName;

    @NotNull(message = BalanceErrorCode.BALANCE_DESCRIPTION_MANDATORY)
    @Size(min = BalanceFieldValidation.BALANCE_NAME_MIN_LENGTH, message = BalanceErrorCode.BALANCE_NAME_MIN_LENGTH)
    @Size(max = BalanceFieldValidation.BALANCE_NAME_MAX_LENGTH, message = BalanceErrorCode.BALANCE_NAME_MAX_LENGTH)
    private String description;

    @NotNull(message = BalanceErrorCode.ID_MANDATORY)
    private String groupId;

}
