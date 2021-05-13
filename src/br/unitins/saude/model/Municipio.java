package br.unitins.saude.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Municipio extends DefaultEntity<Municipio>{
	
	private static final long serialVersionUID = -443304948100465257L;
	
	private String nome;
	private String sigla;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_estado")
	private Estado estado;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
}
