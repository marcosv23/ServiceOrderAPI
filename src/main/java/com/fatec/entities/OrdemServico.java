package com.fatec.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import com.fatec.entities.Comentario;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class OrdemServico implements Serializable {
	private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue( strategy = GenerationType.IDENTITY)
  private Integer id;

  private String descricao;
  
  private Float preco;

  private Date dataAbertura;

  private Date dataFinalizacao;

  @OneToOne //Maybe we need here to use JoinColumn
  @JoinColumn(name="cliente_id")
  private Cliente cliente;

  @OneToMany
  private List<Comentario> comentarios;

  public OrdemServico(Integer id, String descricao, Float preco, Date dataAbertura, Date dataFinalizacao,
      Cliente cliente, List<Comentario> comentarios) {
    this.id = id;
    this.descricao = descricao;
    this.preco = preco;
    this.dataAbertura = dataAbertura;
    this.dataFinalizacao = dataFinalizacao;
    this.cliente = cliente;
    this.comentarios = comentarios;
  }

  public OrdemServico() {
  }

  
  
}