CREATE TABLE groups (
  id varchar(50) NOT NULL,
  group_name varchar(50) NOT NULL UNIQUE
);

ALTER TABLE groups ADD CONSTRAINT groups_pk PRIMARY KEY (id);