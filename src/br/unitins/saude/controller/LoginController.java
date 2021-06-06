package br.unitins.saude.controller;

import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.unitins.saude.application.Security;
import br.unitins.saude.application.Session;
import br.unitins.saude.application.Util;
import br.unitins.saude.model.Usuario;
import br.unitins.saude.repository.UsuarioRepository;

@Named
@RequestScoped
public class LoginController {

	private Usuario usuario;

	public void logar() {
		
		UsuarioRepository dao = new UsuarioRepository();
		try {
			Usuario usuarioLogado = dao.findByLogin(getUsuario().getLogin(), Security.hash(getUsuario()));
			if (usuarioLogado == null)
				Util.addErrorMessage("Usuário ou senha inválido.");
			else {
				// Usuario existe com as credenciais
				Session.getInstance().setAttribute("usuarioLogado", usuarioLogado);
				Util.redirect("index.xhtml");
			}
				
		} catch (Exception e) {
			e.printStackTrace();
			Util.addErrorMessage("Problema ao verificar o Login. Entre em contato pelo email: contato@email.com.br");
		}
	}

	public Usuario getUsuario() {
		if (usuario == null)
			usuario = new Usuario();
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}