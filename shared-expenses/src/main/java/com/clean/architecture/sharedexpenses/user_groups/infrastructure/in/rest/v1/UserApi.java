package com.clean.architecture.sharedexpenses.user_groups.infrastructure.in.rest.v1;

import com.clean.architecture.sharedexpenses.user_groups.infrastructure.in.rest.v1.model.request.CreateUserRequest;
import com.clean.architecture.sharedexpenses.user_groups.infrastructure.in.rest.v1.model.response.CreateUserResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequestMapping("/v1/users")
public interface UserApi {

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    CreateUserResponse createUserV1(@Valid @RequestBody CreateUserRequest request);


}
