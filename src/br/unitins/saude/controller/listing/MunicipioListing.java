package br.unitins.saude.controller.listing;

import java.util.ArrayList;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.saude.application.RepositoryException;
import br.unitins.saude.model.Municipio;
import br.unitins.saude.repository.MunicipioRepository;

@Named
@ViewScoped
public class MunicipioListing extends Listing<Municipio> {

	private static final long serialVersionUID = -1800622632771618402L;
	private String filtro;
	
	public MunicipioListing() {
		super("municipiolisting", new MunicipioRepository());
	}
	
	public void pesquisar() {
		MunicipioRepository repo = new MunicipioRepository();
		try {
			setList(repo.findByNome(filtro));
		} catch (RepositoryException e) {
			setList(new ArrayList<Municipio>());
		}
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}


}
