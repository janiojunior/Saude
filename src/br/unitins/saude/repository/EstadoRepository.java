package br.unitins.saude.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.unitins.saude.application.JPAUtil;
import br.unitins.saude.application.RepositoryException;
import br.unitins.saude.model.Estado;

public class EstadoRepository extends Repository<Estado> {
	
	public EstadoRepository() {
		super(JPAUtil.getEntityManager());
	}
	
	public EstadoRepository(EntityManager em) {
		super(em);
	}
	
	public List<Estado> findByNome(String nome) throws RepositoryException {
		EntityManager em = getEntityManager();
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append(" e ");
		jpql.append("FROM ");
		jpql.append(" Estado e ");
		jpql.append("WHERE ");
		jpql.append(" UPPER(e.nome) LIKE UPPER(:nome) ");
		jpql.append("ORDER BY e.nome ");
		
		Query query = em.createQuery(jpql.toString());
		query.setParameter("nome", "%" + nome + "%");
		
		return query.getResultList();
	}
	
	public List<Estado> findAll() throws RepositoryException {
		EntityManager em = getEntityManager();
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append(" u ");
		jpql.append("FROM ");
		jpql.append(" Estado u ");
		jpql.append("ORDER BY u.nome ");
		
		Query query = em.createQuery(jpql.toString());
		return query.getResultList();
	}
	
}
