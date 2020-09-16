create table TB_USER (
    id bigint not null auto_increment,
    username varchar(100) not null,
    password varchar(100) not null,
    data_criacao timestamp not null,
    data_atualizacao timestamp default null,
    primary key (id)
)