package br.unitins.saude.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.unitins.saude.application.JPAUtil;
import br.unitins.saude.application.RepositoryException;
import br.unitins.saude.model.PessoaFisica;
import br.unitins.saude.model.Usuario;

public class UsuarioRepository extends Repository<Usuario> {
	
	public UsuarioRepository() {
		super(JPAUtil.getEntityManager());
	}
	
	public UsuarioRepository(EntityManager em) {
		super(em);
	}
	
	public Usuario findByLogin(String login, String senha) throws RepositoryException {
		EntityManager em = getEntityManager();
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append(" u ");
		jpql.append("FROM ");
		jpql.append(" Usuario u ");
		jpql.append("WHERE ");
		jpql.append(" u.login = :login ");
		jpql.append(" AND u.senha = :senha ");
		
		Query query = em.createQuery(jpql.toString());
		query.setParameter("login", login);
		query.setParameter("senha", senha);
		
		Usuario usuario = null;
		try {
			usuario = (Usuario) query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return usuario;
	}
	
	
	public Usuario findByEmail(String email) throws RepositoryException {
		EntityManager em = getEntityManager();
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append(" u ");
		jpql.append("FROM ");
		jpql.append(" Usuario u ");
		jpql.append("WHERE ");
		jpql.append(" u.login = :email ");
		
		Query query = em.createQuery(jpql.toString());
		query.setParameter("email", email);
		
		Usuario usuario = null;
		try {
			usuario = (Usuario) query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return usuario;
	}
	
	public Usuario findByPessoaFisica(PessoaFisica pessoaFisica) throws RepositoryException {
		EntityManager em = getEntityManager();
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append(" u ");
		jpql.append("FROM ");
		jpql.append(" Usuario u ");
		jpql.append("WHERE ");
		jpql.append(" u.pessoaFisica.id = :id ");
		
		Query query = em.createQuery(jpql.toString());
		query.setParameter("id", pessoaFisica.getId());
		
		Usuario usuario = null;
		try {
			usuario = (Usuario) query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return usuario;
	}
	
	public List<Usuario> findAll() throws RepositoryException {
		EntityManager em = getEntityManager();
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append(" u ");
		jpql.append("FROM ");
		jpql.append(" Usuario u ");
		jpql.append("ORDER BY u.pessoaFisica.nome ");
		
		Query query = em.createQuery(jpql.toString());
		return query.getResultList();
	}
	
}
