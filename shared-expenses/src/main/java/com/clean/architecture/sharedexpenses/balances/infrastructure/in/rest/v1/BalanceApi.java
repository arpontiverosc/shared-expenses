package com.clean.architecture.sharedexpenses.balances.infrastructure.in.rest.v1;

import com.clean.architecture.sharedexpenses.balances.infrastructure.in.rest.v1.model.request.AddExpenseToBalanceRequest;
import com.clean.architecture.sharedexpenses.balances.infrastructure.in.rest.v1.model.request.CreateBalanceRequest;
import com.clean.architecture.sharedexpenses.balances.infrastructure.in.rest.v1.model.response.AddExpenseToBalanceResponse;
import com.clean.architecture.sharedexpenses.balances.infrastructure.in.rest.v1.model.response.BalanceDetailResponse;
import com.clean.architecture.sharedexpenses.balances.infrastructure.in.rest.v1.model.response.CreateBalanceResponse;
import com.clean.architecture.sharedexpenses.balances.infrastructure.in.rest.v1.model.response.ExpensesForBalanceResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/v1/balances")
public interface BalanceApi {

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    CreateBalanceResponse createBalanceV1(@Valid @RequestBody CreateBalanceRequest createBalanceRequest);


    @GetMapping(path = "/{balanceId}", produces = MediaType.APPLICATION_JSON_VALUE)
    BalanceDetailResponse detailBalanceV1(@PathVariable String balanceId);


    @PostMapping(path = "/{balanceId}/expenses", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    AddExpenseToBalanceResponse addExpenseToBalanceV1(@PathVariable String balanceId, @Valid @RequestBody AddExpenseToBalanceRequest addExpenseToBalanceRequest);


    @GetMapping(path = "/{balanceId}/expenses", produces = MediaType.APPLICATION_JSON_VALUE)
    ExpensesForBalanceResponse obtainExpensesForBalanceV1(@PathVariable String balanceId);


}
