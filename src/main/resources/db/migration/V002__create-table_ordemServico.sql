create table  if not exists ordem_servico(
  id int NOT NULL AUTO_INCREMENT,
  descricao TEXT NOT NULL ,
  preco FLOAT NOT NULL ,
  dataAbertura DATETIME NOT NULL ,
  dataFinalizacao DATETIME,
  status varchar(20),
  primary key(id)
);