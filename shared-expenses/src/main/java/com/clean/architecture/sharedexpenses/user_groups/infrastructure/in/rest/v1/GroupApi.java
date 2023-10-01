package com.clean.architecture.sharedexpenses.user_groups.infrastructure.in.rest.v1;

import com.clean.architecture.sharedexpenses.user_groups.infrastructure.in.rest.v1.model.request.AddUserToGroupRequest;
import com.clean.architecture.sharedexpenses.user_groups.infrastructure.in.rest.v1.model.request.CreateGroupRequest;
import com.clean.architecture.sharedexpenses.user_groups.infrastructure.in.rest.v1.model.response.CreateGroupResponse;
import com.clean.architecture.sharedexpenses.user_groups.infrastructure.in.rest.v1.model.response.GroupDetailResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/v1/groups")
public interface GroupApi {


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    CreateGroupResponse createGroupV1(@Valid @RequestBody CreateGroupRequest request);


    @GetMapping(path = "/{groupId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    GroupDetailResponse detailGroupV1(@PathVariable("groupId") String groupId);


    @PostMapping(path = "/{groupId}/users", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    void addUserToGroup(@PathVariable("groupId") String groupId, @Valid @RequestBody AddUserToGroupRequest request);

}
