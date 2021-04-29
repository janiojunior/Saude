package br.unitins.saude.controller;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import br.unitins.saude.controller.listing.PessoaJuridicaListing;
import br.unitins.saude.model.PessoaJuridica;

@Named
@ViewScoped
public class PessoaJuridicaController extends Controller<PessoaJuridica> {
	private static final long serialVersionUID = -272034776042438457L;

	@Override
	public PessoaJuridica getEntity() {
		if (entity == null) {
			entity = new PessoaJuridica();
		}
		return entity;
	}
	
	public void abrirPessoaJuridicaListing() {
		PessoaJuridicaListing listing = new PessoaJuridicaListing();
		listing.open();
	}
	
	public void obterPessoaJuridicaListing(SelectEvent<PessoaJuridica> event) {
		setEntity(event.getObject());
	}
	
}
