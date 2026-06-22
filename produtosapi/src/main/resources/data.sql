create table produto(
	id bigint auto_increment not null primary key,
	nome varchar(60) not null,
	descricao varchar(255) not null,
	preco numeric(18,2)
);