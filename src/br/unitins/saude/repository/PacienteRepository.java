package br.unitins.saude.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.unitins.saude.application.JPAUtil;
import br.unitins.saude.application.RepositoryException;
import br.unitins.saude.model.Paciente;

public class PacienteRepository {
	
	public void save(Paciente paciente) throws RepositoryException {
		try {
			EntityManager em = JPAUtil.getEntityManager();
			
			em.getTransaction().begin();
			
			// insert or update
			em.merge(paciente);
			
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Erro ao executar o método Save do Repository");
			throw new RepositoryException("Erro ao Salvar");
		}
		
	}
	
	public void remove(Paciente paciente) throws RepositoryException {
		try {
			EntityManager em = JPAUtil.getEntityManager();
			
			em.getTransaction().begin();
			
			// insert or update
			em.remove(paciente);
			
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Erro ao executar o método Remove do Repository");
			throw new RepositoryException("Erro ao Remover");
		}
	}
	
	public List<Paciente> findAll() throws RepositoryException {
		EntityManager em = JPAUtil.getEntityManager();
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append(" p ");
		jpql.append("FROM ");
		jpql.append(" Paciente p ");
		jpql.append("ORDER BY p.nome ");
		
		Query query = em.createQuery(jpql.toString());
		return query.getResultList();
		 
	}
	public Paciente findId(Paciente paciente) throws RepositoryException {
		EntityManager em = JPAUtil.getEntityManager();
		return em.find(paciente.getClass(), paciente.getId());
	}

}
