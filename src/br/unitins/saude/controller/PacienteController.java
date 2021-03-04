package br.unitins.saude.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.unitins.saude.application.JPAUtil;
import br.unitins.saude.application.Util;
import br.unitins.saude.model.Paciente;

@Named
@RequestScoped
public class PacienteController {

	private Paciente paciente = null;

	public Paciente getPaciente() {
		if (paciente == null)
			paciente = new Paciente();
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	public void salvar() {
		EntityManager em = JPAUtil.getEntityManager();
		
		em.getTransaction().begin();
		getPaciente().setId(3);
		em.merge(getPaciente());
		em.getTransaction().commit();
		
		Util.addErrorMessage("Cadastro realizado com sucesso.");
		System.out.println("Funcionou.");
	}
	
	public void limpar() {
		System.out.println("Entrou no limpar");
		paciente = null;
	}

}
