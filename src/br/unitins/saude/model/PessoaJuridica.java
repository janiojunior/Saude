package br.unitins.saude.model;

import javax.persistence.Entity;

@Entity
public class PessoaJuridica extends Pessoa {

	private static final long serialVersionUID = 3126699330642853208L;
	private String cnpj;

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

}
