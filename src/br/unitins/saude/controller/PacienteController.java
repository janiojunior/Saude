package br.unitins.saude.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import br.unitins.saude.application.RepositoryException;
import br.unitins.saude.controller.listing.EstadoListing;
import br.unitins.saude.controller.listing.PacienteListing;
import br.unitins.saude.controller.listing.PessoaFisicaListing;
import br.unitins.saude.model.Estado;
import br.unitins.saude.model.Municipio;
import br.unitins.saude.model.Paciente;
import br.unitins.saude.model.PessoaFisica;
import br.unitins.saude.model.Usuario;
import br.unitins.saude.repository.MunicipioRepository;
import br.unitins.saude.repository.PacienteRepository;
import br.unitins.saude.repository.PessoaFisicaRepository;
import br.unitins.saude.repository.UsuarioRepository;

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
	
	public void abrirPessoaFisicaListing() {
		PessoaFisicaListing listing = new PessoaFisicaListing();
		listing.open();
	}
	
	public void obterPessoaFisicaListing(SelectEvent<PessoaFisica> event) {
		getEntity().setPessoaFisica(event.getObject());
		
		PacienteRepository repo = new PacienteRepository();
		try {
			Paciente p = repo.findByPessoaFisica(getEntity().getPessoaFisica());
			if (p != null) {
				setEntity(repo.findByPessoaFisica(getEntity().getPessoaFisica()));
			}
		} catch (RepositoryException e) {
			e.printStackTrace();
		}
	}
	
	public List<Municipio> completeMunicipio(String filtro) {
		MunicipioRepository repo = new MunicipioRepository();
		try {
			return repo.findByNome(filtro, 5);
		} catch (RepositoryException e) {
			e.printStackTrace();
			return new ArrayList<Municipio>();
		}
	}
	
}
