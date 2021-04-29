package br.unitins.saude.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class PessoaFisica extends Pessoa {
	
	private static final long serialVersionUID = -7078343162378376674L;
	
	@Column(unique = true)
	private String cpf;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
}
