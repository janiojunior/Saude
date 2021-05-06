package br.unitins.saude.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Paciente extends DefaultEntity<Paciente> {

	private static final long serialVersionUID = 8955499426576665422L;

	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "id_pessoafisica", unique = true)
	private PessoaFisica pessoaFisica;

	@ManyToOne
	@JoinColumn(name = "id_municipio")
	private Municipio municipio;

	public PessoaFisica getPessoaFisica() {
		return pessoaFisica;
	}

	public void setPessoaFisica(PessoaFisica pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	@Override
	public String toString() {
		return "Paciente [id=" + getId() + ", cpf=" + pessoaFisica.getCpf() + ", nome=" + pessoaFisica.getNome() + "]";
	}

}
