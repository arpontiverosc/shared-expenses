CREATE TABLE balances (
    id varchar(50) NOT NULL,
    balance_name varchar(50),
    description varchar(50),
    group_id varchar(50),
    created_at date NOT NULL
);

ALTER TABLE balances ADD CONSTRAINT balances_pk PRIMARY KEY (id);
