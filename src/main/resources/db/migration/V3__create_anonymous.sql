alter table client alter column avatar char(255)  not null;
insert into client(id,name,second_name, avatar,email,role)
values(1,'anonymous','anonymous','https://penfox.ru/wp-content/uploads/2022/01/Anonim_avatar-96x96.jpg',
       'anonymous','USER');
