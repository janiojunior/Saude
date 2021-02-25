package br.unitins.saude.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.unitins.saude.model.Paciente;

@Named
@RequestScoped
public class PacienteController {

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
		System.out.println("Entrou no salvar");
		System.out.println(getPaciente());
	}
	
	public void limpar() {
		System.out.println("Entrou no limpar");
		paciente = null;
	}

}
