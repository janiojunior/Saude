package br.unitins.saude.controller.listing;

import java.util.ArrayList;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.saude.application.RepositoryException;
import br.unitins.saude.model.Estado;
import br.unitins.saude.repository.EstadoRepository;

@Named
@ViewScoped
public class EstadoListingSql extends ListingSql<Estado> {

	private static final long serialVersionUID = 7051066688912408549L;
	private String filtro;
	
	public EstadoListingSql() {
		super("estadolistingsql", new EstadoRepository());
	}
	
	public void pesquisar() {
		EstadoRepository repo = new EstadoRepository();
		try {
			setList(repo.findByNomeSQL(filtro));
		} catch (RepositoryException e) {
			setList(new ArrayList<Object[]>());
		}
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}


}
