package br.unitins.saude.controller;

import java.io.Serializable;

import br.unitins.saude.application.RepositoryException;
import br.unitins.saude.application.Util;
import br.unitins.saude.model.DefaultEntity;
import br.unitins.saude.repository.Repository;

public abstract class Controller<T extends DefaultEntity<T>> implements Serializable {
	
	private static final long serialVersionUID = -7172376339410561672L;
	
	protected T entity;

	public Controller() {
		super();
	}
	
	public abstract T getEntity();
	
	public void setEntity(T entity) {
		this.entity = entity;
	}
	

	public void salvar() {
		Repository<T> repo = new Repository<T>();
	
		try {
			repo.beginTransaction();
			repo.save(getEntity());
			repo.commitTransaction();
			
			limpar();
			Util.addInfoMessage("Cadastro realizado com sucesso.");
		} catch (RepositoryException e) {
			repo.rollbackTransaction();
		}
	}

	public void excluir() {
		Repository<T> repo = new Repository<T>();
		try {
			repo.beginTransaction();
			repo.remove(getEntity());
			repo.commitTransaction();
			
			Util.addInfoMessage("Paciente removido com sucesso.");
		} catch (RepositoryException e) {
			Util.addErrorMessage(e.getMessage());
		}
	}
	
	public void limpar() {
		entity = null;
	}

	public void editar(T entity) {
		System.out.println("Entrou no editar");
		setEntity(entity);
	}

}