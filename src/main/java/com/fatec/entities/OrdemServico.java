package com.fatec.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fatec.entities.Comentario;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

  @JsonFormat(pattern ="dd/MM/yyyy HH:mm")
  private Date dataAbertura;

  @JsonFormat(pattern ="dd/MM/yyyy HH:mm")
  private Date dataFinalizacao;

  private String status;

  @ManyToOne //Maybe we need here to use JoinColumn
  @JoinColumn(name="cliente_id")
  private Cliente cliente;

  @OneToMany
  @JoinColumn(name="comentario_id")
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

  public OrdemServico(Integer id, String descricao, Float preco, Date dataAbertura, Date dataFinalizacao,
      Cliente cliente) {
    this.id = id;
    this.descricao = descricao;
    this.preco = preco;
    this.dataAbertura = dataAbertura;
    this.dataFinalizacao = dataFinalizacao;
    this.cliente = cliente;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public Float getPreco() {
    return preco;
  }

  public void setPreco(Float preco) {
    this.preco = preco;
  }
  
  
  public Date getDataAbertura() {
    return dataAbertura;
  }

  public void setDataAbertura(Date dataAbertura) {
    this.dataAbertura = dataAbertura;
  }

  public Date getDataFinalizacao() {
    return dataFinalizacao;
  }

  public void setDataFinalizacao(Date dataFinalizacao) {
    this.dataFinalizacao = dataFinalizacao;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public List<Comentario> getComentarios() {
    return comentarios;
  }

  public void setComentarios(List<Comentario> comentarios) {
    this.comentarios = comentarios;
  }

  
  
  
}