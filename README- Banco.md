# BankingForAll
Trabalho sistema bancario

Banco Criacional Bank

create table usuario(
	id serial,
	usuario varchar(255),
	senha varchar(255),
	tipoUsuario varchar(255),
	primary key (id));
	
create table agencia(
	id serial,
	nome varchar(255),
	numeroAgencia varchar(255),
	cidade varchar(255),
	primary key(id));
	
create table conta(
	id serial,
	nome varchar(255),
	idade int,
	cpf varchar(255),
	agencia varchar(255),
	tipoConta varchar(255),
	usuarioAcesso varchar(255),
	acesso varchar(255),
	senhaOperacoes varchar(255),
	numeroConta varchar(255),
	saldo numeric,
	primary key (id));

create table profissional(
	id serial,
	nome varchar(255),
	idade int,
	usuario varchar(255),
	senhaAcesso varchar(255),
	senhaOperacoes varchar(255),
	tipoProfissional varchar(255),
	primary key (id));
	
	------------------------------
	Login do cliente:
	padrao
	Senha do cliente:
	padrao
	------------------------------
	Login Bancario:
	gerente
	Senha Bancario:
	gerente
INSERT INTO USUARIO (USUARIO, SENHA, TIPOUSUARIO) VALUES ('8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918','8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918','CLIENTE');
INSERT INTO USUARIO (USUARIO, SENHA, TIPOUSUARIO) VALUES ('21232f297a57a5a743894a0e4a801fc3','21232f297a57a5a743894a0e4a801fc3','BANCARIO');