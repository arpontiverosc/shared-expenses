package com.clean.architecture.sharedexpenses.user_groups.domain.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Group {

    @EqualsAndHashCode.Include private String id;
    private String groupName;
    private List<User> users = new ArrayList<>();


    public void addUser(User user){
        users = Optional.ofNullable(users)
                .map(ArrayList::new)
                .orElseGet(ArrayList::new);
        users.add(user);
    }

    public boolean isIncluded(User user) {
        return users.contains(user);
    }
}
