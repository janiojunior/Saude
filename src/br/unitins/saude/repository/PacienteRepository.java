package br.unitins.saude.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.unitins.saude.application.JPAUtil;
import br.unitins.saude.application.RepositoryException;
import br.unitins.saude.model.Paciente;
import br.unitins.saude.model.PessoaFisica;

public class PacienteRepository extends Repository<Paciente> {
	
	public PacienteRepository() {
		super(JPAUtil.getEntityManager());
	}
	
	public PacienteRepository(EntityManager em) {
		super(em);
	}
	
	public Paciente findByPessoaFisica(PessoaFisica pessoaFisica) throws RepositoryException {
		EntityManager em = getEntityManager();
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append(" p ");
		jpql.append("FROM ");
		jpql.append(" Paciente p ");
		jpql.append("WHERE ");
		jpql.append(" p.pessoaFisica.id = :id ");
		
		Query query = em.createQuery(jpql.toString());
		query.setParameter("id", pessoaFisica.getId());
		
		Paciente paciente = null;
		try {
			paciente = (Paciente) query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return paciente;
	}
	
	public List<Paciente> findByNome(String nome) throws RepositoryException {
		EntityManager em = getEntityManager();
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append(" p ");
		jpql.append("FROM ");
		jpql.append(" Paciente p ");
		jpql.append("WHERE ");
		jpql.append(" UPPER(p.pessoaFisica.nome) LIKE UPPER(:nome) ");
		jpql.append("ORDER BY p.pessoaFisica.nome ");
		
		Query query = em.createQuery(jpql.toString());
		query.setParameter("nome", "%" + nome + "%");
		
		return query.getResultList();
	}
	
	public List<Paciente> findAll() throws RepositoryException {
		EntityManager em = getEntityManager();
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append(" p ");
		jpql.append("FROM ");
		jpql.append(" Paciente p ");
		jpql.append("ORDER BY p.pessoaFisica.nome ");
		
		Query query = em.createQuery(jpql.toString());
		return query.getResultList();
		 
	}
	
}
