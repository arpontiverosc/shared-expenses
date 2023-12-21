package com.clean.architecture.sharedexpenses.balances.domain.model;

import java.util.Set;


public class Group {
    private final String id;
    private final Set<String> membersIds;

    private Group(Builder builder) {
        this.id = builder.id;
        this.membersIds = builder.membersIds;
    }

    public String getId() {
        return id;
    }

    public Set<String> getMembersIds() {
        return membersIds;
    }


    public static final class Builder {
        private String id;
        private Set<String> membersIds;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder membersIds(Set<String> membersIds) {
            this.membersIds = membersIds;
            return this;
        }

        public Group build() {
            return new Group(this);
        }
    }
}
