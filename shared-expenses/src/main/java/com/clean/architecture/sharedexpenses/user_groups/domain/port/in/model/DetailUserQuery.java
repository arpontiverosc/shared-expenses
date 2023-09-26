package com.clean.architecture.sharedexpenses.user_groups.domain.port.in.model;

import com.clean.architecture.sharedexpenses.user_groups.domain.util.UserErrorCode;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class DetailUserQuery {

    @NotNull(message = UserErrorCode.ID_MANDATORY)
    private String id;
}
