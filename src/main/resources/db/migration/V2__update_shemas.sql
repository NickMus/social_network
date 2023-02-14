
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
    "avatar" char(50)  not null,
    "email" char(50)  not null,
    "role" char(50)  not null,
    "message_id"  bigint    null,
    --     "enabled"     boolean   not null,
--     "age"         char(50)  not null,
--     "sex"         boolean   not null,
--     "password"    char(60)  not null,
--     "photo"       char(255) not null,
    constraint fk_message foreign key (message_id) references "message" ("id")
    );

create index if not exists client_tbl_role_id_idx on client
    (message_id);