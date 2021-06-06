package br.unitins.saude.model;

import java.util.ArrayList;
import java.util.List;

public enum Perfil {

	FUNCIONARIO(2, "Funcionário"), ADMINISTRADOR(1, "Administrador");

	private int id;
	private String label;
	private List<String> paginasComPermissao;

	Perfil(int id, String label) {
		this.id = id;
		this.label = label;
		paginasComPermissao = new ArrayList<String>();

		paginasComPermissao.add("/Saude/pages/usuario.xhtml");
		paginasComPermissao.add("/Saude/pages/usuariolisting.xhtml");
		paginasComPermissao.add("/Saude/pages/municipio.xhtml");
		paginasComPermissao.add("/Saude/pages/municipiolisting.xhtml");
		paginasComPermissao.add("/Saude/pages/img-usuario");

		if (id == 1) {
			paginasComPermissao.add("/Saude/pages/pessoafisica.xhtml");
			paginasComPermissao.add("/Saude/pages/pessoafisicalisting.xhtml");
			paginasComPermissao.add("/Saude/pages/pessoajuridica.xhtml");
			paginasComPermissao.add("/Saude/pages/pessoajuridicalisting.xhtml");
			paginasComPermissao.add("/Saude/pages/paciente.xhtml");
			paginasComPermissao.add("/Saude/pages/pacientelisting.xhtml");
			paginasComPermissao.add("/Saude/pages/estado.xhtml");
			paginasComPermissao.add("/Saude/pages/estadolisting.xhtml");
		}

	}

	public int getId() {
		return id;
	}

	public String getLabel() {
		return label;
	}

	public List<String> getPaginasComPermissao() {
		return paginasComPermissao;
	}

	@SuppressWarnings("unused")
	public static Perfil valueOf(Integer id) {
		if (id == null)
			return null;

		for (Perfil perfil : Perfil.values()) {
			if (perfil.id == id)
				return perfil;
		}

		return null;

	}

}
