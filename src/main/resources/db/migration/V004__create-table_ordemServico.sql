create table  if not exists ordem_servico(
  id int NOT NULL AUTO_INCREMENT,
  descricao TEXT,
  preco FLOAT,
  dataAbertura DATETIME,
  dataFinalizacao DATETIME,
  primary key(id)
);