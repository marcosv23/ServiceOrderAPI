create table if not exists fornecedor(
id int not null auto_increment,
nome varchar(60) not null,
email varchar(60) not null,
telefone varchar(20) not null,
primary key (id)
);
