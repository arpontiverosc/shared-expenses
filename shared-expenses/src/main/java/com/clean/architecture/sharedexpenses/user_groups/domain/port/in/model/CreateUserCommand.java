package com.clean.architecture.sharedexpenses.user_groups.domain.port.in.model;

import com.clean.architecture.sharedexpenses.user_groups.domain.util.UserErrorCode;
import com.clean.architecture.sharedexpenses.user_groups.domain.util.UserFieldValidation;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CreateUserCommand {

    @NotNull(message = UserErrorCode.USER_NAME_MANDATORY)
    @Size(min = UserFieldValidation.USER_NAME_MIN_LENGTH, message = UserErrorCode.USER_NAME_MIN_LENGTH)
    @Size(max = UserFieldValidation.USER_NAME_MAX_LENGTH, message = UserErrorCode.USER_NAME_MAX_LENGTH)
    private String userName;

    @NotNull(message = UserErrorCode.FIRST_NAME_MANDATORY)
    @Size(min = UserFieldValidation.FIRST_NAME_MIN_LENGTH, message = UserErrorCode.FIRST_NAME_MIN_LENGTH)
    @Size(max = UserFieldValidation.FIRST_NAME_MAX_LENGTH, message = UserErrorCode.FIRST_NAME_MAX_LENGTH)
    private String firstName;

    @NotNull(message = UserErrorCode.LAST_NAME_MANDATORY)
    @Size(min = UserFieldValidation.LAST_NAME_MIN_LENGTH, message = UserErrorCode.LAST_NAME_MIN_LENGTH)
    @Size(max = UserFieldValidation.LAST_NAME_MAX_LENGTH, message = UserErrorCode.LAST_NAME_MAX_LENGTH)
    private String lastName;

    @NotNull(message = UserErrorCode.EMAIL_MANDATORY)
    @Size(min = UserFieldValidation.EMAIL_MIN_LENGTH, message = UserErrorCode.EMAIL_MIN_LENGTH)
    @Size(max = UserFieldValidation.EMAIL_MAX_LENGTH, message = UserErrorCode.EMAIL_MAX_LENGTH)
    private String email;

}
