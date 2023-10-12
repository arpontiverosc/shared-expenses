CREATE TABLE users (
  id varchar(50) NOT NULL,
  user_name varchar(50) NOT NULL UNIQUE,
  first_name varchar(50) NOT NULL,
  last_name varchar(50) NOT NULL,
  email varchar(100) NOT NULL
);

ALTER TABLE users ADD CONSTRAINT users_pk PRIMARY KEY (id);