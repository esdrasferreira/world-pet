-- liquibase formatted sql
-- changeset edson:1
-- comment: Criacao da primeira versao

DROP TABLE IF EXISTS pet;

create table pet(
                     id bigint not null primary key auto_increment,
                     nome varchar(50),
                     idade date,
                     raca varchar (50),
                     sexo enum('masculino', 'feminino'),
                     tipo varchar (100) not null

);


-- rollback DROP TABLE pets;