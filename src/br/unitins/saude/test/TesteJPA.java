package br.unitins.saude.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.unitins.saude.model.Paciente;

public class TesteJPA {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Saude");
		EntityManager em = emf.createEntityManager();
		
		Paciente paciente = new Paciente();
		paciente.setId(1);
		paciente.setCpf("111");
		paciente.setNome("Joao");
		
		em.getTransaction().begin();
		em.persist(paciente);
		em.getTransaction().commit();
		
		System.out.println("Funcionou.");
	}

}
