drop table message;
drop table client;
create table if not exists "message"
(
    "id"   bigserial primary key,
    "twit" char(50) not null,
    "date" char(50) not null,
    "time" char(50) not null
);

create table if not exists client
(
    "id"          bigserial primary key,
    "name"        char(50)  not null,
    "second_name" char(50)  not null,
    "avatar" char(250)  not null,
    "email" char(50)  not null,
    "role" char(50)  not null,
    "message_id"  bigint    null,

    constraint fk_message foreign key (message_id) references "message" ("id")
);

create index if not exists client_tbl_role_id_idx on client
    (message_id);

insert into client(id,name,second_name,avatar,email,role)
values(1,'anonymous','anonymous','https://penfox.ru/wp-content/uploads/2022/01/Anonim_avatar-96x96.jpg',
       'anonymous','USER');