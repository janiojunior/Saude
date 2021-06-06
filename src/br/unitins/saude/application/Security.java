package br.unitins.saude.application;

import org.apache.commons.codec.digest.DigestUtils;

import br.unitins.saude.model.Usuario;

public class Security {
	
	public static String hash(Usuario usuario) {
		return DigestUtils.sha256Hex(usuario.getSenha()+usuario.getLogin());
	}
}
