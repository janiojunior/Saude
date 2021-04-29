package br.unitins.saude.controller;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import br.unitins.saude.application.RepositoryException;
import br.unitins.saude.controller.listing.PessoaFisicaListing;
import br.unitins.saude.model.PessoaFisica;
import br.unitins.saude.model.Usuario;
import br.unitins.saude.repository.UsuarioRepository;

@Named
@ViewScoped
public class UsuarioController extends Controller<Usuario> {

	private static final long serialVersionUID = -1239534887785769178L;

	@Override
	public Usuario getEntity() {
		if (entity == null)
			entity = new Usuario();
		return entity;
	}
	
	public void abrirPessoaFisicaListing() {
		PessoaFisicaListing listing = new PessoaFisicaListing();
		listing.open();
	}
	
	public void obterPessoaFisicaListing(SelectEvent<PessoaFisica> event) {
		getEntity().setPessoaFisica(event.getObject());
		
		UsuarioRepository repo = new UsuarioRepository();
		try {
			Usuario usu = repo.findByPessoaFisica(getEntity().getPessoaFisica());
			if (usu != null)
				setEntity(repo.findByPessoaFisica(getEntity().getPessoaFisica()));
		} catch (RepositoryException e) {
			e.printStackTrace();
		}
	}

}
