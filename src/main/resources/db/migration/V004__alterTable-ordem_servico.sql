alter table ordem_servico ADD cliente_id INT not null;

alter table comentario add ordem_servico_id int not null;

alter table ordem_servico ADD FOREIGN KEY (cliente_id) references cliente(id);

alter table comentario ADD FOREIGN KEY (ordem_servico_id) references ordem_servico(id);
