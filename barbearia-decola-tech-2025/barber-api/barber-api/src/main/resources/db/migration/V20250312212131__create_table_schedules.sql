CREATE TABLE SCHEDULES (
    id BIGSERIAL not null primary key,
    start_at timestamp not null,
    end_at timestamp not null,
    client_id BIGSERIAL not null,
    CONSTRAINT UK_SCHEDULE_INTERVAL  UNIQUE (start_at, end_at),
    CONSTRAINT FK_CLIENTS_SCHEDULES FOREIGN KEY(client_id) REFERENCES CLIENTS(id)
);