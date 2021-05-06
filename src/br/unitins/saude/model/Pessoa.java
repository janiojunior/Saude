package br.unitins.saude.model;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Inheritance(strategy = InheritanceType.JOINED)
@Entity
public class Pessoa extends DefaultEntity<Pessoa> {

	private static final long serialVersionUID = 7276102196311497790L;

	private String nome;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
