package br.unitins.saude.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import br.unitins.saude.application.RepositoryException;
import br.unitins.saude.controller.listing.PessoaFisicaListing;
import br.unitins.saude.model.Estado;
import br.unitins.saude.model.Municipio;
import br.unitins.saude.model.Perfil;
import br.unitins.saude.model.PessoaFisica;
import br.unitins.saude.model.Usuario;
import br.unitins.saude.repository.EstadoRepository;
import br.unitins.saude.repository.MunicipioRepository;
import br.unitins.saude.repository.UsuarioRepository;

@Named
@ViewScoped
public class UsuarioController extends Controller<Usuario> {

	private static final long serialVersionUID = -1239534887785769178L;
	
	private List<Municipio> listaMunicipio = null;
	
	private Estado estado = null;
	
	private List<Estado> listaEstado = null;
	
	public Estado getEstado() {
		if (estado == null)
			estado = new Estado();
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	@Override
	public void limpar() {
		super.limpar();
		estado = null;
		listaEstado = null;
		listaMunicipio = null;
	}

	@Override
	public Usuario getEntity() {
		if (entity == null) {
			entity = new Usuario();
			entity.setMunicipio(new Municipio());
			entity.getMunicipio().setEstado(new Estado());
		}
		return entity;
	}
	
	public void abrirPessoaFisicaListing() {
		PessoaFisicaListing listing = new PessoaFisicaListing();
		listing.open();
	}
	
	public void obterPessoaFisicaListing(SelectEvent<PessoaFisica> event) {
		getEntity().setPessoaFisica(event.getObject());
		
		UsuarioRepository repo = new UsuarioRepository();
		try {
			Usuario usu = repo.findByPessoaFisica(getEntity().getPessoaFisica());
			if (usu != null) {
				setEntity(repo.findByPessoaFisica(getEntity().getPessoaFisica()));
			}
			setEstado(getEntity().getMunicipio().getEstado());
			filtrarMunicipios();
		} catch (RepositoryException e) {
			e.printStackTrace();
		}
	}
	
	public Perfil[] getListaPerfil() {
		return Perfil.values();
	}
	
	public List<Estado> getListaEstado() {
		if (listaEstado == null) {
			EstadoRepository repo = new EstadoRepository();
			try {
				listaEstado =  repo.findAll();
			} catch (RepositoryException e) {
				listaEstado =  new ArrayList<Estado>();
			}
		}
		return listaEstado;
	}
	
	public List<Municipio> filtrarMunicipios() {
		MunicipioRepository repo = new MunicipioRepository();
		try {
			listaMunicipio =  repo.findByEstado(getEstado().getId());
		} catch (RepositoryException e) {
			listaMunicipio =  new ArrayList<Municipio>();
		}
		return listaMunicipio;
	}
	
	public List<Municipio> getListaMunicipio() {
		if (listaMunicipio == null) {
			listaMunicipio =  new ArrayList<Municipio>();
		}
		return listaMunicipio;
	}
			
}
