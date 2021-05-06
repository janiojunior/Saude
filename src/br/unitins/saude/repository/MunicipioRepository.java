package br.unitins.saude.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.unitins.saude.application.JPAUtil;
import br.unitins.saude.application.RepositoryException;
import br.unitins.saude.model.Estado;
import br.unitins.saude.model.Municipio;

public class MunicipioRepository extends Repository<Municipio> {
	
	public MunicipioRepository() {
		super(JPAUtil.getEntityManager());
	}
	
	public MunicipioRepository(EntityManager em) {
		super(em);
	}
	
	public List<Municipio> findByEstado(Integer id) throws RepositoryException {
		EntityManager em = getEntityManager();
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append(" m ");
		jpql.append("FROM ");
		jpql.append(" Municipio m ");
		jpql.append("WHERE ");
		jpql.append(" m.estado.id = :id ");
		jpql.append("ORDER BY m.nome ");
		
		Query query = em.createQuery(jpql.toString());
		query.setParameter("id", id);
		
		return query.getResultList();
	}
	
	public List<Municipio> findByNome(String nome) throws RepositoryException {
		EntityManager em = getEntityManager();
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append(" m ");
		jpql.append("FROM ");
		jpql.append(" Municipio m ");
		jpql.append("WHERE ");
		jpql.append(" UPPER(m.nome) LIKE UPPER(:nome) ");
		jpql.append("ORDER BY m.nome ");
		
		Query query = em.createQuery(jpql.toString());
		query.setParameter("nome", "%" + nome + "%");
		
		return query.getResultList();
	}
	
	public List<Municipio> findAll() throws RepositoryException {
		EntityManager em = getEntityManager();
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append(" m ");
		jpql.append("FROM ");
		jpql.append(" Municipio m ");
		jpql.append("ORDER BY m.nome ");
		
		Query query = em.createQuery(jpql.toString());
		return query.getResultList();
	}
	
}
