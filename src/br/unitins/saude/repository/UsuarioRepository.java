package br.unitins.saude.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.unitins.saude.application.JPAUtil;
import br.unitins.saude.application.RepositoryException;
import br.unitins.saude.model.Paciente;
import br.unitins.saude.model.Usuario;

public class UsuarioRepository extends Repository<Usuario> {
	
	public UsuarioRepository() {
		super(JPAUtil.getEntityManager());
	}
	
	public UsuarioRepository(EntityManager em) {
		super(em);
	}
	
	public List<Usuario> findAll() throws RepositoryException {
		EntityManager em = getEntityManager();
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append(" u ");
		jpql.append("FROM ");
		jpql.append(" Usuario u ");
		jpql.append("ORDER BY u.nome ");
		
		Query query = em.createQuery(jpql.toString());
		return query.getResultList();
	}
	
}
