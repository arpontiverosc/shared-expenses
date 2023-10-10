package com.clean.architecture.sharedexpenses.balances.infrastructure.in.rest.v1.model.request;

import com.clean.architecture.sharedexpenses.balances.domain.util.ExpenseErrorCode;
import com.clean.architecture.sharedexpenses.balances.domain.util.ExpenseFieldValidation;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddExpenseToBalanceRequest {

    @NotNull(message = ExpenseErrorCode.EXPENSE_USER_ID_MANDATORY)
    private String userId;

    @NotNull(message = ExpenseErrorCode.EXPENSE_GROUP_ID_MANDATORY)
    private String groupId;

    @NotNull(message = ExpenseErrorCode.EXPENSE_PRICE_MANDATORY)
    private BigDecimal price;

    @NotNull(message = ExpenseErrorCode.EXPENSE_CURRENCY_MANDATORY)
    private String currency;

    @NotNull(message = ExpenseErrorCode.EXPENSE_DESCRIPTION_MANDATORY)
    @Size(min = ExpenseFieldValidation.EXPENSE_DESCRIPTION_MIN_LENGTH, message = ExpenseErrorCode.EXPENSE_DESCRIPTION_MIN_LENGTH)
    @Size(max = ExpenseFieldValidation.EXPENSE_DESCRIPTION_MAX_LENGTH, message = ExpenseErrorCode.EXPENSE_DESCRIPTION_MAX_LENGTH)
    private String description;
}
