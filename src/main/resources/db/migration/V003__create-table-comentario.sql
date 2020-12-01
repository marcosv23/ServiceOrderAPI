create table if not exists comentario(
  id int NOT NULL AUTO_INCREMENT,
  descricao TEXT NOT NULL,
  dataEnvio DATETIME NOT NULL,
  ordem_servico_id int,
  primary key (id)
);
