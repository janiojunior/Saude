package br.unitins.saude.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.unitins.saude.application.JPAUtil;
import br.unitins.saude.application.RepositoryException;
import br.unitins.saude.model.PessoaFisica;
import br.unitins.saude.model.Usuario;

public class PessoaFisicaRepository extends Repository<PessoaFisica> {
	
	public PessoaFisicaRepository() {
		super(JPAUtil.getEntityManager());
	}
	
	public PessoaFisicaRepository(EntityManager em) {
		super(em);
	}
	
	public PessoaFisica findByCpf(String cpf) throws RepositoryException {
		EntityManager em = getEntityManager();
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append(" p ");
		jpql.append("FROM ");
		jpql.append(" PessoaFisica p ");
		jpql.append("WHERE ");
		jpql.append(" p.cpf = :cpf ");
		
		Query query = em.createQuery(jpql.toString());
		query.setParameter("cpf", cpf);
		
		PessoaFisica pf = null;
		try {
			pf = (PessoaFisica) query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return pf;
	}
	
	
	public List<PessoaFisica> findByNome(String nome) throws RepositoryException {
		EntityManager em = getEntityManager();
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append(" p ");
		jpql.append("FROM ");
		jpql.append(" PessoaFisica p ");
		jpql.append("WHERE ");
		jpql.append(" UPPER(p.nome) LIKE UPPER(:nome) ");
		jpql.append("ORDER BY p.nome ");
		
		Query query = em.createQuery(jpql.toString());
		query.setParameter("nome", "%" + nome + "%");
		
		return query.getResultList();
	}
	
	public List<PessoaFisica> findAll() throws RepositoryException {
		EntityManager em = getEntityManager();
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append(" p ");
		jpql.append("FROM ");
		jpql.append(" PessoaFisica p ");
		jpql.append("ORDER BY p.nome ");
		
		Query query = em.createQuery(jpql.toString());
		return query.getResultList();
		 
	}
	
}
