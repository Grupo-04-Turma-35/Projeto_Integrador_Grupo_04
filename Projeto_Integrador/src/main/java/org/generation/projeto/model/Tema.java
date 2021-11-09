package org.generation.projeto.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_tema")
public class Tema {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idtema;
	
	@NotBlank(message = "O título do tema é obrigatório")
	@Size(min = 5, max = 100, message = "O título precisa conter de 5 a 100 caracteres")
	private String titulo;
	
	@NotBlank(message = "O texto do tema é obrigatório")
	@Size(min = 5, max = 500, message = "O texto precisa conter de 5 a 500 caracteres")
	private String descricao;
	
	private long qtdtema;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date datatema = new java.sql.Date(System.currentTimeMillis());

	public long getIdtema() {
		return idtema;
	}

	public void setIdtema(long idtema) {
		this.idtema = idtema;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public long getQtdtema() {
		return qtdtema;
	}

	public void setQtdtema(long qtdtema) {
		this.qtdtema = qtdtema;
	}

	public Date getDatatema() {
		return datatema;
	}

	public void setDatatema(Date datatema) {
		this.datatema = datatema;
	}
}
