package com.clean.architecture.sharedexpenses.user_groups.domain.port.in.model;

import com.clean.architecture.sharedexpenses.user_groups.domain.util.GroupErrorCode;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class DetailGroupQuery {

    @NotNull(message = GroupErrorCode.ID_MANDATORY)
    private String id;
}
