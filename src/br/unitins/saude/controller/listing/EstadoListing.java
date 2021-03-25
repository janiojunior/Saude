package br.unitins.saude.controller.listing;

import java.util.ArrayList;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.saude.application.RepositoryException;
import br.unitins.saude.model.Estado;
import br.unitins.saude.repository.EstadoRepository;

@Named
@ViewScoped
public class EstadoListing extends Listing<Estado> {

	private static final long serialVersionUID = -4010944566429542698L;
	private String filtro;
	
	public EstadoListing() {
		super("estadolisting", new EstadoRepository());
	}
	
	public void pesquisar() {
		EstadoRepository repo = new EstadoRepository();
		try {
			setList(repo.findByNome(filtro));
		} catch (RepositoryException e) {
			setList(new ArrayList<Estado>());
		}
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}


}
