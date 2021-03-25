package br.unitins.saude.controller.listing;

import java.util.ArrayList;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.saude.application.RepositoryException;
import br.unitins.saude.model.Paciente;
import br.unitins.saude.repository.PacienteRepository;

@Named
@ViewScoped
public class PacienteListing extends Listing<Paciente> {

	private static final long serialVersionUID = 1753552924233677646L;
	private String filtro;
	
	public PacienteListing() {
		super("pacientelisting", new PacienteRepository());
	}
	
	public void pesquisar() {
		PacienteRepository repo = new PacienteRepository();
		try {
			setList(repo.findByNome(filtro));
		} catch (RepositoryException e) {
			setList(new ArrayList<Paciente>());
		}
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}


}
