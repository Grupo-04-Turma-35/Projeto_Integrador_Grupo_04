package org.generation.projeto.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_postagem")
public class Postagem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idpostagem;

	@NotBlank(message = "O titulo é obrigatório")
	@Size(min = 3, max = 255, message = "O titulo precisa ter entre 3 a 255 caracteres")
	private String titulo;

	@NotBlank(message = "O texto é obrigatório")
	@Size(min = 20, max = 10000, message = "O texto precisa ter entre 20 a 10000 caracteres")
	private String texto;

	@Temporal(TemporalType.TIMESTAMP)
	private Date datapostagem = new java.sql.Date(System.currentTimeMillis());

	// todo
	private long curtidas;

	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Tema tema;

	public long getIdpostagem() {
		return idpostagem;
	}

	public void setIdpostagem(long idpostagem) {
		this.idpostagem = idpostagem;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getDatapostagem() {
		return datapostagem;
	}

	public void setDatapostagem(Date datapostagem) {
		this.datapostagem = datapostagem;
	}

	public long getCurtidas() {
		return curtidas;
	}

	public void setCurtidas(long curtidas) {
		this.curtidas = curtidas;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

}
