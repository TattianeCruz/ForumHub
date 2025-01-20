create table topicos (
                         id bigint not null auto_increment,
                         titulo varchar(128) not null unique,
                         mensagem varchar(1024) not null,
                         created_at datetime not null,
                         state varchar(20) not null,
                         author varchar(20) not null,
                         curso varchar(64) not null,

                     primary key(id)
);