package br.unitins.saude.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.unitins.saude.model.Estado;

public class TesteJPA {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Saude");
		EntityManager em1 = emf.createEntityManager();
		EntityManager em2 = emf.createEntityManager();
		
		Estado estado = new Estado();
		estado.setNome("São Paulo");
		estado.setSigla("SP");
		
		em1.getTransaction().begin();
		estado = em1.merge(estado);
		em1.getTransaction().commit();
		
		em2.getTransaction().begin();
		estado = em2.merge(estado);
		em2.remove(estado);
		em2.getTransaction().commit();
		
		
//		
//		Paciente paciente = new Paciente();
//		paciente.setId(2);
//		paciente.setCpf("123456789012345");
//		paciente.setNome("Maria");
//		
//		em.getTransaction().begin();
//		em.persist(paciente);
//		em.getTransaction().commit();
//		
//		System.out.println("Funcionou.");
	}

}
