package br.unitins.saude.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.file.UploadedFile;

import br.unitins.saude.application.RepositoryException;
import br.unitins.saude.application.Security;
import br.unitins.saude.application.Util;
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
	
	private InputStream fotoInputStream = null;
	private String nomeFoto = null;
	
	public InputStream getFotoInputStream() {
		return fotoInputStream;
	}

	public void setFotoInputStream(InputStream fotoInputStream) {
		this.fotoInputStream = fotoInputStream;
	}

	public String getNomeFoto() {
		if (nomeFoto == null)
			nomeFoto = "Selecione uma foto...";
		return nomeFoto;
	}
	
	public void upload(FileUploadEvent event) {
		System.out.println("Entrou");
		UploadedFile uploadFile = event.getFile();
		System.out.println("nome arquivo: " + uploadFile.getFileName());
		System.out.println("tipo: " + uploadFile.getContentType());
		System.out.println("tamanho: " + uploadFile.getSize());

		if (uploadFile.getContentType().equals("image/png")) {
			try {
				fotoInputStream = uploadFile.getInputStream();
				nomeFoto = uploadFile.getFileName();
				System.out.println("inputStream: " + uploadFile.getInputStream().toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Util.addInfoMessage("Upload realizado com sucesso.");
		} else {
			Util.addErrorMessage("O tipo da image deve ser png.");
		}

	}
	
	public Estado getEstado() {
		if (estado == null)
			estado = new Estado();
		return estado;
	}
	
	@Override
	public void salvar() {
		// salvando a imagem
		if (! Util.saveImageUsuario(fotoInputStream, "png", getEntity().getId())) {
			Util.addErrorMessage("Erro ao salvar. N�o foi poss�vel salvar a imagem do usu�rio.");
			return;
		}
		// gerando o hash da senha
		getEntity().setSenha(Security.hash(getEntity()));
		// salvando no banco
		super.salvar();
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
		nomeFoto = null;
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
			if (getEntity().getMunicipio() != null)
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
