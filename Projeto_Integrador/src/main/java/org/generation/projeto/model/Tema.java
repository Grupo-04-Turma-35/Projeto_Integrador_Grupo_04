package org.generation.projeto.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_tema")
public class Tema {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idTema;
	
	@NotNull(message = "O título do tema é obrigatório")
	@Size(min = 5, max = 100, message = "O título precisa conter de 5 a 100 caracteres")
	private String tituloTema;
	
	@NotNull(message = "O texto do tema é obrigatório")
	@Size(min = 5, max = 500, message = "O texto precisa conter de 5 a 500 caracteres")
	private String descricaoTema;
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long qtdTema;

	public long getIdTema() {
		return idTema;
	}

	public void setIdTema(long idTema) {
		this.idTema = idTema;
	}

	public String getTituloTema() {
		return tituloTema;
	}

	public void setTituloTema(String tituloTema) {
		this.tituloTema = tituloTema;
	}

	public String getDescricaoTema() {
		return descricaoTema;
	}

	public void setDescricaoTema(String descricaoTema) {
		this.descricaoTema = descricaoTema;
	}

	public long getQtdTema() {
		return qtdTema;
	}

	public void setQtdTema(long qtdTema) {
		this.qtdTema = qtdTema;
	}

}
