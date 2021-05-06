package br.unitins.saude.model;

public enum Perfil {
	
	FUNCIONARIO(2, "Funcionário"),
	ADMINISTRADOR(1, "Administrador"); 
	
	private int id;
	private String label;
	
	Perfil(int id, String label) {
		this.id = id;
		this.label = label;
	}
	
	public int getId() {
		return id;
	}
	
	public String getLabel() {
		return label;
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
