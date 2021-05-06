package br.unitins.saude.converter.jsf;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.unitins.saude.application.RepositoryException;
import br.unitins.saude.model.Municipio;
import br.unitins.saude.repository.MunicipioRepository;

@FacesConverter(forClass = Municipio.class)
public class MunicipioConverter implements Converter<Municipio> {

	@Override
	public Municipio getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.isEmpty())
			return null;
		
		MunicipioRepository repo = new MunicipioRepository();
		Municipio municipio;
		try {
			municipio = repo.findById(Integer.valueOf(value.trim()));
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return null;
		} catch (RepositoryException e) {
			e.printStackTrace();
			return null;
		}
		return municipio;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Municipio value) {
		if (value == null || value.getId() == null)
			return null;
		return value.getId().toString();
	}

}