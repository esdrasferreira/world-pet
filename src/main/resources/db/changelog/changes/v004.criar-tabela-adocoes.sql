-- liquibase formatted sql
-- changeset esdras:1
-- comment: Criacao da quarta versao

DROP TABLE IF EXISTS  adocao;

CREATE TABLE adocao(
                        `id` INT NOT NULL AUTO_INCREMENT,
                        `id_pet` INT,
                        `id_usuario` INT,
                        `data_adocao` DATE,
                        `informacoes` VARCHAR(255) NULL,
                        PRIMARY KEY (`id`)
)

-- rollback DROP TABLE usuario;