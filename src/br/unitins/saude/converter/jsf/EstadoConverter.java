package br.unitins.saude.converter.jsf;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.unitins.saude.application.RepositoryException;
import br.unitins.saude.model.Estado;
import br.unitins.saude.repository.EstadoRepository;

@FacesConverter(forClass = Estado.class)
public class EstadoConverter implements Converter<Estado> {

	@Override
	public Estado getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.isEmpty())
			return null;
		
		EstadoRepository repo = new EstadoRepository();
		Estado estado;
		try {
			estado = repo.findById(Integer.valueOf(value.trim()));
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return null;
		} catch (RepositoryException e) {
			e.printStackTrace();
			return null;
		}
		return estado;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Estado value) {
		if (value == null || value.getId() == null)
			return null;
		return value.getId().toString();
	}

}