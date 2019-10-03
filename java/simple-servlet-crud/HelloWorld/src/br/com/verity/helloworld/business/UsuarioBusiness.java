package br.com.verity.helloworld.business;

import br.com.verity.helloworld.bean.Usuario;
import br.com.verity.helloworld.dao.UsuarioDAO;

public class UsuarioBusiness {
	
	public boolean logar(Usuario usuario){
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		return usuarioDAO.logar(usuario);
	}
}
