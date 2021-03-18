package br.unitins.saude.repository;

import javax.persistence.EntityManager;

import br.unitins.saude.application.JPAUtil;
import br.unitins.saude.application.RepositoryException;
import br.unitins.saude.model.Paciente;

public class LogRepository {
	
	private EntityManager entityManager = null;
	
	public LogRepository() {
		EntityManager em = JPAUtil.getEntityManager();
	}
	
	public void save(Paciente paciente) throws RepositoryException {
		
	}
	
	public void remove(Paciente paciente) throws RepositoryException {
	}
	

	public EntityManager getEntityManager() {
		return entityManager;
	}
	
}
