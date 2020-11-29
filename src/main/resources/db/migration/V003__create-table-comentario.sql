create table if not exists comentario(
  id int NOT NULL AUTO_INCREMENT,
  descricao TEXT NOT NULL,
  dataEnvio DATETIME NOT NULL,
  primary key (id)
);
