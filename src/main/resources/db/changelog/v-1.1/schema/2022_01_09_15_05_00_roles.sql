use reservation;

CREATE TABLE IF NOT EXISTS user
(
    ID         BIGINT NOT NULL AUTO_INCREMENT,
    FIRST_NAME VARCHAR(20),
    LAST_NAME  VARCHAR(20),
    EMAIL      VARCHAR(20),
    PASSWORD   VARCHAR(256),
    ROLES      VARCHAR(512),
    PRIMARY KEY (ID),
    UNIQUE KEY (EMAIL)
);

insert into user
values (1, 'Zenia', 'Trofan', 'test@email.com', '$2a$12$cDsOIg6cJ9FSs/oo1cZD2.H6LXWkNcH9wj/vPcra1DCQ0yYkgccry', 'ROLE_ADMIN;ROLE_USER');