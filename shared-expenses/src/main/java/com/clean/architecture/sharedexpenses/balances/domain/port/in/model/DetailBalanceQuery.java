package com.clean.architecture.sharedexpenses.balances.domain.port.in.model;


import com.clean.architecture.sharedexpenses.balances.domain.util.BalanceErrorCode;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class DetailBalanceQuery {

    @NotNull(message = BalanceErrorCode.ID_MANDATORY)
    private String id;
}
