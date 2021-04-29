package br.unitins.saude.controller.listing;

import java.util.ArrayList;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.saude.application.RepositoryException;
import br.unitins.saude.model.PessoaJuridica;
import br.unitins.saude.repository.PessoaJuridicaRepository;

@Named
@ViewScoped
public class PessoaJuridicaListing extends Listing<PessoaJuridica> {

	private static final long serialVersionUID = -4518061019218179489L;
	private String filtro;
	
	public PessoaJuridicaListing() {
		super("pessoajuridicalisting", new PessoaJuridicaRepository());
	}
	
	public void pesquisar() {
		PessoaJuridicaRepository repo = new PessoaJuridicaRepository();
		try {
			setList(repo.findByNome(filtro));
		} catch (RepositoryException e) {
			setList(new ArrayList<PessoaJuridica>());
		}
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}


}
