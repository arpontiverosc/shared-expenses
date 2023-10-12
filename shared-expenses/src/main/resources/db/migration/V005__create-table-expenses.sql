CREATE TABLE expenses (
    id varchar(50) NOT NULL,
    user_id varchar(50) NOT NULL,
    group_id varchar(50) NOT NULL,
    currency varchar(25) NOT NULL,
    description varchar(50) NOT NULL,
    price numeric(5,2) NOT NULL,
    balance_id varchar(50) REFERENCES balances(id),
    created_at date NOT NULL
);

ALTER TABLE expenses ADD CONSTRAINT expenses_pk PRIMARY KEY (id);
