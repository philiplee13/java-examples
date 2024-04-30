create schema test;

create table test.users (
    first_name varchar(255),
    last_name varchar(255),
    email varchar(255) PRIMARY KEY
);

insert into test.users (first_name, last_name, email) values ('testFirstName', 'testLastName', 'testEmail@email.com');