create table users (
                     uid serial primary key,
                     login varchar(200),
                     password varchar(200),
                     role_id bigint unsigned not null,
                     FOREIGN KEY (role_id)  REFERENCES roles (uid)
);