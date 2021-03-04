package br.unitins.saude.application;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private static EntityManagerFactory emf = null;
	
	private JPAUtil() {
		// nao permitir a instancia
	}
	
	public static EntityManager getEntityManager() {
		if (emf == null)
			emf = Persistence.createEntityManagerFactory("Saude");
		return emf.createEntityManager();
	}
}
