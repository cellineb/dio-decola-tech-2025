CREATE TABLE CLIENTS (
    id BIGSERIAL not null primary key,
    name VARCHAR(150) not null,
    email VARCHAR(150) not null,
    phone BPCHAR(11) not null,
    CONSTRAINT UK_EMAIL  UNIQUE (email),
    CONSTRAINT UK_PHONE  UNIQUE (phone)
);