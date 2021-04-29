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
	private Estado estado;

	public PessoaFisica getPessoaFisica() {
		return pessoaFisica;
	}

	public void setPessoaFisica(PessoaFisica pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Paciente [id=" + getId() + ", cpf=" + pessoaFisica.getCpf() + ", nome=" + pessoaFisica.getNome() + "]";
	}

}
