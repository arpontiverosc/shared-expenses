CREATE TABLE users_groups (
    user_id varchar(50) REFERENCES users(id),
    group_id varchar(50) REFERENCES groups(id)
);

ALTER TABLE users_groups ADD CONSTRAINT users_groups_pk PRIMARY KEY (user_id, group_id);