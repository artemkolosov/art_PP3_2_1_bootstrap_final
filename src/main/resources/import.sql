# create table if not exists users
# (
#     id         bigint primary key auto_increment,
#     username        varchar(50)  not null,
#     firstname        varchar(50)  not null,
#     lastname    varchar(50)  not null,
#     age      bigint,
#     email    varchar(50)  not null,
#     password     varchar(255) not null
#
# );
#
#
# create table if not exists roles
# (
#     id        bigint primary key auto_increment,
#     name varchar(50) not null
# );
#
#
# create table if not exists users_roles
# (
#     users_id bigint,
#     foreign key (users_id) references users (id),
#     roles_id bigint,
#     foreign key (users_id) references users (id),
#     primary key (users_id, roles_id)
# );
#


insert into users (username, firstname, lastName, age, email, password) values ('admin','Ivan', 'Ivanov', '35','ivanov@mail.ru', '$2a$12$N9xXphXFJvKqAwe7yojK6uGsDZvLhsLEMEwu9nLZZu6WlFUQjGQJm');
insert into users (username, firstname, lastName, age, email, password) values ('user', 'Petr', 'Petrov', '25','petrov@mail.ru', '$2a$12$V1N5WF.J4z6mhHCfhNYwUe7.FXWYEPwua3/GLt.L6QKROoXgLciHO');
insert into users (username, firstname, lastName, age, email, password) values ('Semen','Semen', 'Semenov', '22','semenov@mail.ru', '$2a$12$N9xXphXFJvKqAwe7yojK6uGsDZvLhsLEMEwu9nLZZu6WlFUQjGQJm');
insert into users (username, firstname, lastName, age, email, password) values ('Serg','Сергей', 'Сергеев', '20','sergeev@mail.ru', '$2a$12$V1N5WF.J4z6mhHCfhNYwUe7.FXWYEPwua3/GLt.L6QKROoXgLciHO');


 insert into roles (name) values ('ROLE_ADMIN'), ('ROLE_USER');


insert into users_roles (users_id, roles_id) values ('1','1');
insert into users_roles (users_id, roles_id) values ('1','2');
insert into users_roles (users_id, roles_id) values ('2','2');
insert into users_roles (users_id, roles_id) values ('3','1');
insert into users_roles (users_id, roles_id) values ('3','2');
insert into users_roles (users_id, roles_id) values ('4','2');


