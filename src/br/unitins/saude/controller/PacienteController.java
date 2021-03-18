package br.unitins.saude.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.saude.application.RepositoryException;
import br.unitins.saude.model.Paciente;
import br.unitins.saude.repository.PacienteRepository;

@Named
@ViewScoped
public class PacienteController extends Controller<Paciente> {

	private static final long serialVersionUID = 593324931325951976L;
	private List<Paciente> listaPaciente;

	@Override
	public Paciente getEntity() {
		if (entity == null)
			entity = new Paciente();
		return entity;
	}

	public void pesquisar() {
		System.out.println("Pesquisar");
		PacienteRepository repo = new PacienteRepository();
		try {
			listaPaciente = repo.findAll();
		} catch (RepositoryException e) {
			
		}
	}
	
	public List<Paciente> getListaPaciente() {
		if (listaPaciente==null)
			listaPaciente = new ArrayList<Paciente>();
		return listaPaciente;
	}



}
