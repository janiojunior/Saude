package br.unitins.saude.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.saude.application.RepositoryException;
import br.unitins.saude.application.Util;
import br.unitins.saude.model.Paciente;
import br.unitins.saude.repository.PacienteRepository;

@Named
@ViewScoped
public class RelatorioPacienteController implements Serializable {

	private static final long serialVersionUID = -6466793482965540067L;
	private String filtro;
	private List<Paciente> listaPaciente;
	
	public void pesquisar() {
		PacienteRepository repo = new PacienteRepository();
		try {
			setListaPaciente(repo.findByNome(filtro));
		} catch (RepositoryException e) {
			setListaPaciente(null);
			e.printStackTrace();
		}
	}
	
	public void limpar() {
		listaPaciente = null;
	}
	
	public void gerarRelatorio() {
		Util.redirect("/Saude/pacientereportservlet?NOME="+getFiltro());
//		Util.redirect("/Saude/pacientereportservlet");
	}


	public List<Paciente> getListaPaciente() {
		if (listaPaciente == null)
			listaPaciente = new ArrayList<Paciente>();
		return listaPaciente;
	}

	public void setListaPaciente(List<Paciente> listaPaciente) {
		this.listaPaciente = listaPaciente;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}
	
}