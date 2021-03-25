package br.unitins.saude.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;

import br.unitins.saude.application.RepositoryException;
import br.unitins.saude.controller.listing.EstadoListing;
import br.unitins.saude.controller.listing.Listing;
import br.unitins.saude.controller.listing.PacienteListing;
import br.unitins.saude.model.Estado;
import br.unitins.saude.model.Paciente;
import br.unitins.saude.repository.PacienteRepository;

@Named
@ViewScoped
public class PacienteController extends Controller<Paciente> {

	private static final long serialVersionUID = 593324931325951976L;

	@Override
	public Paciente getEntity() {
		if (entity == null) {
			entity = new Paciente();
			entity.setEstado(new Estado());
		}
		return entity;
	}
	
	public void abrirPacienteListing() {
		PacienteListing listing = new PacienteListing();
		listing.open();
	}
	
	public void obterPacienteListing(SelectEvent<Paciente> event) {
		setEntity(event.getObject());
	}
	
	public void abrirEstadoListing() {
		EstadoListing listing = new EstadoListing();
		listing.open();
	}
	
	public void obterEstadoListing(SelectEvent<Estado> event) {
		getEntity().setEstado(event.getObject());
	}
	
}
