CREATE TABLE `Postagens` (
	`id_postagem` bigint NOT NULL AUTO_INCREMENT,
	`titulo_postagem` varchar(255) NOT NULL,
	`texto_postagem` varchar(1000) NOT NULL,
	`data_postagem` TIMESTAMP NOT NULL,
	`curtidas_postagem` bigint NOT NULL AUTO_INCREMENT,
	`fk_usuario` bigint NOT NULL,
	`fk_tema` bigint NOT NULL,
	PRIMARY KEY (`id_postagem`)
);

CREATE TABLE `Usuarios` (
	`id_usuario` bigint NOT NULL AUTO_INCREMENT,
	`nome_usuario` varchar(255) NOT NULL,
	`apelido_usuario` varchar(80) NOT NULL,
	`email_usuario` varchar(256) NOT NULL,
	`senha_usuario` varchar(255) NOT NULL,
	PRIMARY KEY (`id_usuario`)
);

CREATE TABLE `Tema` (
	`id_tema` bigint NOT NULL AUTO_INCREMENT,
	`titulo_tema` varchar(80) NOT NULL,
	`descricao_tema` varchar(255) NOT NULL,
	`qtd_tema` bigint NOT NULL AUTO_INCREMENT,
	PRIMARY KEY (`id_tema`)
);

ALTER TABLE `Postagens` ADD CONSTRAINT `Postagens_fk0` FOREIGN KEY (`fk_usuario`) REFERENCES `Usuarios`(`id_usuario`);

ALTER TABLE `Postagens` ADD CONSTRAINT `Postagens_fk1` FOREIGN KEY (`fk_tema`) REFERENCES `Tema`(`id_tema`);




