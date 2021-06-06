package br.unitins.saude.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.unitins.saude.model.Usuario;

@WebFilter(filterName = "SecurityFilter", urlPatterns = {"/pages/*"})
public class SecurityFilter implements Filter {
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		// removendo o cache das paginas 
		HttpServletResponse resp = (HttpServletResponse) response;
		resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		resp.setHeader("Pragma", "no-cache"); 
		resp.setDateHeader("Expires", 0); 
		
//	 	Para desabilitar o filter, descomente as duas proximas linhas e comente o restante	
		chain.doFilter(request, response);
		return;
		
//		HttpServletRequest servletRequest = (HttpServletRequest) request;
//		// imprime o endereco da pagina
//		String endereco = servletRequest.getRequestURI();
//		System.out.println(endereco);
////	    ex.	/Saude/pages/usuario.xhtml
//		
//		// retorna a sessao corrente (false - para nao criar uma nova sessao)
//		HttpSession session = servletRequest.getSession(false);
//		
//		Usuario usuario = null;
//		if (session != null)
//			usuario = (Usuario) session.getAttribute("usuarioLogado");
//		
//		if (usuario == null) {
//			((HttpServletResponse) response).sendRedirect("/Saude/login.xhtml");
//		}  else {
//			if (usuario.getPerfil().getPaginasComPermissao().contains(endereco)) {
//				// segue o fluxo 
//				chain.doFilter(request, response);
//				return;
//			} else {
//				((HttpServletResponse) response).sendRedirect("/Saude/semacesso.xhtml");
//			}
//		}
				
		
	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("SecurityFilter Iniciado.");
		Filter.super.init(filterConfig);
	}

}
