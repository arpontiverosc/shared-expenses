package com.clean.architecture.sharedexpenses.balances.infrastructure.in.rest.v1.model.response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class BalanceDetailResponse {


    private String id;
    private String balanceName;
    private String description;
    private String groupId;

}
