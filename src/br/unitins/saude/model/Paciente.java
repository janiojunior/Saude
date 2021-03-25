package br.unitins.saude.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Paciente extends DefaultEntity<Paciente>{
	
	private static final long serialVersionUID = 8955499426576665422L;

	@Column(unique = true, length = 14)
	private String cpf;
	
	@Column(length = 120)
	private String nome;
	
	@ManyToOne
	private Estado estado;
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Paciente [id=" + getId() + ", cpf=" + cpf + ", nome=" + nome + "]";
	}
	
}
