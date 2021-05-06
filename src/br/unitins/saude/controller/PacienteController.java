package br.unitins.saude.controller;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import br.unitins.saude.application.RepositoryException;
import br.unitins.saude.controller.listing.EstadoListing;
import br.unitins.saude.controller.listing.PacienteListing;
import br.unitins.saude.model.Estado;
import br.unitins.saude.model.Municipio;
import br.unitins.saude.model.Paciente;
import br.unitins.saude.model.PessoaFisica;
import br.unitins.saude.repository.PacienteRepository;
import br.unitins.saude.repository.PessoaFisicaRepository;

@Named
@ViewScoped
public class PacienteController extends Controller<Paciente> {

	private static final long serialVersionUID = 593324931325951976L;

	@Override
	public Paciente getEntity() {
		if (entity == null) {
			entity = new Paciente();
			entity.setPessoaFisica(new PessoaFisica());
			entity.setMunicipio(new Municipio());
			entity.getMunicipio().setEstado(new Estado());
		}
		return entity;
	}
	
	public void buscarPessoaFisica() {
		PessoaFisicaRepository repo = new PessoaFisicaRepository();
		PacienteRepository repoPaciente = new PacienteRepository();
		try {
			PessoaFisica pf = repo.findByCpf(getEntity().getPessoaFisica().getCpf());
			if (pf != null) {
				Paciente p = repoPaciente.findByPessoaFisica(pf);
				if (p != null)
					setEntity(p);
				else
					getEntity().setPessoaFisica(pf);
			}
		} catch (RepositoryException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void abrirPacienteListing() {
		PacienteListing listing = new PacienteListing();
		listing.open();
	}
	
	public void obterPacienteListing(SelectEvent<Paciente> event) {
		setEntity(event.getObject());
	}
	
//	public void abrirEstadoListing() {
//		EstadoListing listing = new EstadoListing();
//		listing.open();
//	}
//	
//	public void obterEstadoListing(SelectEvent<Estado> event) {
//		getEntity().setEstado(event.getObject());
//	}
	
}
