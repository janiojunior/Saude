package br.unitins.saude.controller;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import br.unitins.saude.controller.listing.PessoaFisicaListing;
import br.unitins.saude.model.PessoaFisica;

@Named
@ViewScoped
public class PessoaFisicaController extends Controller<PessoaFisica> {

	private static final long serialVersionUID = 593324931325951976L;

	@Override
	public PessoaFisica getEntity() {
		if (entity == null) {
			entity = new PessoaFisica();
		}
		return entity;
	}
	
	public void abrirPessoaFisicaListing() {
		PessoaFisicaListing listing = new PessoaFisicaListing();
		listing.open();
	}
	
	public void obterPessoaFisicaListing(SelectEvent<PessoaFisica> event) {
		setEntity(event.getObject());
	}
	
}
