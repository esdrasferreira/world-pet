-- liquibase formatted sql
-- changeset esdras:1
-- comment: Criacao da primeira versao

DROP TABLE IF EXISTS  usuario;

CREATE TABLE usuario(
                         `id` INT NOT NULL AUTO_INCREMENT,
                         `nome` VARCHAR(45) NULL,
                         `idade` date,
                         `sexo` enum('masculino', 'feminino', 'duvida'),
                         `endereco` VARCHAR(45) NULL,
                         PRIMARY KEY (`id`)
)

-- rollback DROP TABLE usuario;