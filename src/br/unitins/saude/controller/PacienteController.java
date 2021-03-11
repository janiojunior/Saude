package br.unitins.saude.controller;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.unitins.saude.application.RepositoryException;
import br.unitins.saude.application.Util;
import br.unitins.saude.model.Paciente;
import br.unitins.saude.repository.PacienteRepository;

@Named
@RequestScoped
public class PacienteController {

	private List<Paciente> listaPaciente;
	private Paciente paciente = null;

	public Paciente getPaciente() {
		if (paciente == null)
			paciente = new Paciente();
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	public void salvar() {
		try {
			PacienteRepository repo = new PacienteRepository();
			repo.save(getPaciente());
			limpar();
			Util.addInfoMessage("Cadastro realizado com sucesso.");
		} catch (RepositoryException e) {
			Util.addErrorMessage(e.getMessage());
		}
	}
	
	public void excluir() {
		try {
			PacienteRepository repo = new PacienteRepository();
			repo.remove(getPaciente());
			Util.addInfoMessage("Paciente removido com sucesso.");
		} catch (RepositoryException e) {
			Util.addErrorMessage(e.getMessage());
		}
	}
	
	public void limpar() {
		System.out.println("Entrou no limpar");
		paciente = null;
	}
	
	public void editar(Paciente paciente) {
		System.out.println("Entrou no editar");
		setPaciente(paciente);
	}
	
//	public void pesquisar() {
//		PacienteRepository repo = new PacienteRepository();
//		try {
//			listaPaciente = repo.findAll();
//		} catch (RepositoryException e) {
//			
//		}
//	}
	
	public List<Paciente> getListaPaciente() {
		PacienteRepository repo = new PacienteRepository();
		try {
			listaPaciente = repo.findAll();
		} catch (RepositoryException e) {
			listaPaciente = new ArrayList<Paciente>();
		}
		return listaPaciente;
	}

}
