create table if not exists comentario(
  id int NOT NULL AUTO_INCREMENT,
  descricao TEXT NOT NULL,
  data_envio DATETIME NOT NULL,
  ordem_servico_id int not null,
  primary key (id)
);
