package br.unitins.saude.controller;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import br.unitins.saude.controller.listing.EstadoListingSql;
import br.unitins.saude.model.Estado;

@Named
@ViewScoped
public class EstadoController extends Controller<Estado> {

	private static final long serialVersionUID = 6024138957156293437L;

	@Override
	public Estado getEntity() {
		if (entity == null) {
			entity = new Estado();
		}
		return entity;
	}
	
	public void abrirEstadoListing() {
//		EstadoListing listing = new EstadoListing();
		EstadoListingSql listing = new EstadoListingSql();
		listing.open();
	}
	
	public void obterEstadoListing(SelectEvent<Estado> event) {
		setEntity(event.getObject());
	}
	
}
