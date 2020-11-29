package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cliente implements Serializable{
	private static final long serialVersionUID = 1L;

@Id
@GeneratedValue	(strategy= GenerationType.IDENTITY)
private long id;

@Column(name="nome")
private String nome;

private String email;

private String telefone;

public Cliente(long id, String nome, String email, String telefone) {
	super();
	this.id = id;
	this.nome = nome;
	this.email = email;
	this.telefone = telefone;
}

public Cliente() {
	super();
}

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getTelefone() {
	return telefone;
}

public void setTelefone(String telefone) {
	this.telefone = telefone;
}





}

