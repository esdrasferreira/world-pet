-- liquibase formatted sql
-- changeset esdras:1
-- comment: Criacao da quarta versao

DROP TABLE IF EXISTS  adocao;

CREATE TABLE adocao(
                        `id` INT NOT NULL AUTO_INCREMENT,
                        `pet_id` INT NOT NULL,
                        `usuario_id` INT NOT NULL,
                        `data_adocao` DATE NOT NULL ,
                        `informacoes` VARCHAR(255) NULL,
                        PRIMARY KEY (`id`)
)

-- rollback DROP TABLE usuario;