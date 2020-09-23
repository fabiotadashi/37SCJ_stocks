drop table if exists TB_PESSOA;

create table TB_PESSOA(
    id long auto_increment not null primary key,
    nome varchar(100) not null,
    cpf varchar(11) not null
)