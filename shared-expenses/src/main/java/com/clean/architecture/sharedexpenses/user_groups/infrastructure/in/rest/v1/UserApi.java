package com.clean.architecture.sharedexpenses.user_groups.infrastructure.in.rest.v1;

import com.clean.architecture.sharedexpenses.user_groups.infrastructure.in.rest.v1.model.request.CreateUserRequest;
import com.clean.architecture.sharedexpenses.user_groups.infrastructure.in.rest.v1.model.response.CreateUserResponse;
import com.clean.architecture.sharedexpenses.user_groups.infrastructure.in.rest.v1.model.response.UserDetailResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/v1/users")
public interface UserApi {

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    CreateUserResponse createUserV1(@Valid @RequestBody CreateUserRequest request);

    @GetMapping(path = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    UserDetailResponse detailUserV1(@PathVariable("userId") String userId);


}
