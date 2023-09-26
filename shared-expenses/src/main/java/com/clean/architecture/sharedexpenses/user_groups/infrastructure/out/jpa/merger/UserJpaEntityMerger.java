package com.clean.architecture.sharedexpenses.user_groups.infrastructure.out.jpa.merger;

import com.clean.architecture.sharedexpenses.user_groups.domain.model.User;
import com.clean.architecture.sharedexpenses.user_groups.infrastructure.out.jpa.model.UserJpaEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserJpaEntityMerger {

    public static void from(User source, UserJpaEntity target) {
        target.setId(source.getId());
        target.setUserName(source.getUserName());
        target.setFirstName(source.getFirstName());
        target.setLastName(source.getLastName());
        target.setEmail(source.getEmail());
    }
}
