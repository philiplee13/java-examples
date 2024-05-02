create schema if not exists test;

create table test.users (
    first_name varchar(255),
    last_name varchar(255),
    email varchar(255) PRIMARY KEY
);


insert into test.users (first_name, last_name, email) 
values ('jane', 'doe', 'janedoe@email.com');


insert into test.users (first_name, last_name, email) 
values ('john', 'smith', 'johnsmith@email.com');


insert into test.users (first_name, last_name, email) 
values ('teddy', 'smith', 'teddysmith@email.com');

insert into test.users (first_name, last_name, email) 
values ('sam', 'smith', 'samsmith@email.com');
