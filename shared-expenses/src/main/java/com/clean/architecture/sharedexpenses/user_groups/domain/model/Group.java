package com.clean.architecture.sharedexpenses.user_groups.domain.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


public class Group {

    private final String id;
    private final String groupName;
    private List<User> users;


    private Group(Builder builder) {
        id = builder.id;
        groupName = builder.groupName;
        users = builder.users;
    }

    public static Builder builder() {
        return new Builder();
    }

    public void addUser(User user) {
        users = Optional.ofNullable(users).map(ArrayList::new).orElseGet(ArrayList::new);
        users.add(user);
    }

    public void addUsers(List<User> usersToAdd) {
        users = Optional.ofNullable(users).map(ArrayList::new).orElseGet(ArrayList::new);
        users.addAll(usersToAdd);
    }

    public boolean isIncluded(User user) {
        return users.contains(user);
    }

    public String getId() {
        return id;
    }

    public String getGroupName() {
        return groupName;
    }

    public List<User> getUsers() {
        return users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return Objects.equals(id, group.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Group{" + "id='" + id + '\'' + ", groupName='" + groupName + '\'' + ", users=" + users + '}';
    }

    public static final class Builder {
        private String id;
        private String groupName;
        private List<User> users;

        private Builder() {
        }


        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder groupName(String groupName) {
            this.groupName = groupName;
            return this;
        }

        public Builder users(List<User> users){
            this.users = users;
            return this;
        }


        public Group build() {
            return new Group(this);
        }
    }
}
