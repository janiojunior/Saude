package br.unitins.saude.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.saude.application.RepositoryException;
import br.unitins.saude.model.Usuario;
import br.unitins.saude.repository.UsuarioRepository;

@Named
@ViewScoped
public class UsuarioController extends Controller<Usuario> {

	private static final long serialVersionUID = -1239534887785769178L;
	private List<Usuario> listaUsuario;

	@Override
	public Usuario getEntity() {
		if (entity == null)
			entity = new Usuario();
		return entity;
	}

	public void pesquisar() {
		System.out.println("Pesquisar");
		UsuarioRepository repo = new UsuarioRepository();
		try {
			listaUsuario = repo.findAll();
		} catch (RepositoryException e) {
			
		}
	}
	
	public List<Usuario> getListaUsuario() {
		if (listaUsuario==null)
			listaUsuario = new ArrayList<Usuario>();
		return listaUsuario;
	}



}
