AngularJsVraptorContatos
========================

Aplicação exemplificando integração entre AngularJs e VRaptor com muitos recursos de ambas frameworks (Application integration between exemplifying and AngularJs VRaptor with many features of both frameworks)

<code>

use contatos

CREATE TABLE IF NOT EXISTS contato (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  endereco varchar(255) NOT NULL,
  nome varchar(255) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS perfil (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  descricao varchar(255) NOT NULL,
  PRIMARY KEY (id)
);

INSERT INTO perfil (id, descricao) VALUES
(1, 'ROLE_ADMIN'),
(2, 'ROLE_USER');

CREATE TABLE IF NOT EXISTS tarefa (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  dataExecucao date DEFAULT NULL,
  nome varchar(255) NOT NULL,
  id_usuario bigint(20) DEFAULT NULL,
  PRIMARY KEY (id)
);

INSERT INTO tarefa (id, dataExecucao, nome, id_usuario) VALUES
(1, '2013-12-25', 'tarefa 01', 1),
(2, '2014-11-13', 'tarefa 02', 2);

CREATE TABLE IF NOT EXISTS usuario (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  ativo tinyint(1) DEFAULT NULL,
  email varchar(255) NOT NULL,
  senha varchar(255) DEFAULT NULL,
  tentativas_login int(11) DEFAULT NULL,
  login varchar(255) NOT NULL,
  PRIMARY KEY (id)
);

INSERT INTO usuario (id, ativo, email, senha, tentativas_login, login) VALUES
(1, 1, 'admin@sharkness.org', 'F6E0A1E2AC41945A9AA7FF8A8AAA0CEBC12A3BCC981A929AD5CF810A090E11AE', 0, 'admin'),
(2, 1, 'user@sharkness.org', 'A665A45920422F9D417E4867EFDC4FB8A04A1F3FFF1FA07E998E86F7F7A27AE3', 0, 'user');

CREATE TABLE IF NOT EXISTS usuario_perfil (
  id_usuario bigint(20) NOT NULL,
  id_perfil bigint(20) NOT NULL,
  PRIMARY KEY (id_usuario,id_perfil)
);

INSERT INTO usuario_perfil (id_usuario, id_perfil) VALUES
(1, 1),
(1, 2),
(2, 2);

</code>