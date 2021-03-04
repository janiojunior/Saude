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
		paciente.setId(2);
		paciente.setCpf("123456789012345");
		paciente.setNome("Maria");
		
		em.getTransaction().begin();
		em.persist(paciente);
		em.getTransaction().commit();
		
		System.out.println("Funcionou.");
	}

}
