package br.unitins.saude.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.unitins.saude.application.JPAUtil;
import br.unitins.saude.application.RepositoryException;
import br.unitins.saude.model.PessoaJuridica;

public class PessoaJuridicaRepository extends Repository<PessoaJuridica> {
	
	public PessoaJuridicaRepository() {
		super(JPAUtil.getEntityManager());
	}
	
	public PessoaJuridicaRepository(EntityManager em) {
		super(em);
	}
	
	public List<PessoaJuridica> findByNome(String nome) throws RepositoryException {
		EntityManager em = getEntityManager();
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append(" p ");
		jpql.append("FROM ");
		jpql.append(" PessoaJuridica p ");
		jpql.append("WHERE ");
		jpql.append(" UPPER(p.nome) LIKE UPPER(:nome) ");
		jpql.append("ORDER BY p.nome ");
		
		Query query = em.createQuery(jpql.toString());
		query.setParameter("nome", "%" + nome + "%");
		
		return query.getResultList();
	}
	
	public List<PessoaJuridica> findAll() throws RepositoryException {
		EntityManager em = getEntityManager();
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append(" p ");
		jpql.append("FROM ");
		jpql.append(" PessoaJuridica p ");
		jpql.append("ORDER BY p.nome ");
		
		Query query = em.createQuery(jpql.toString());
		return query.getResultList();
		 
	}
	
}
