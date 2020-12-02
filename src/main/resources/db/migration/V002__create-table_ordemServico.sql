create table  if not exists ordem_servico(
  id int NOT NULL AUTO_INCREMENT,
  descricao TEXT NOT NULL ,
  preco DECIMAL(10,2) NOT NULL ,
  data_abertura DATETIME NOT NULL ,
  data_finalizacao DATETIME,
  cliente_id int,
  status varchar(20),
  primary key(id)
);