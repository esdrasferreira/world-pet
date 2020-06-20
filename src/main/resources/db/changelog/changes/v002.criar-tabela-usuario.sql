-- liquibase formatted sql
-- changeset esdras:1
-- comment: Criacao da primeira versao

DROP TABLE IF EXISTS  usuario;

CREATE TABLE usuario(
                         `id` INT NOT NULL AUTO_INCREMENT,
                         `nome` VARCHAR(45) not null ,
                         `idade` date not null ,
                         `sexo` enum('masculino', 'feminino', 'duvida'),
                         `endereco` VARCHAR(45) not null ,
                         PRIMARY KEY (`id`)
)

-- rollback DROP TABLE usuario;