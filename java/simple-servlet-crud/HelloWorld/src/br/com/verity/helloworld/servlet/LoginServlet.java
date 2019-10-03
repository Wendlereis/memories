package br.com.verity.helloworld.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.verity.helloworld.bean.Usuario;
import br.com.verity.helloworld.business.UsuarioBusiness;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		Usuario usuario = new Usuario(login, senha);
		
		UsuarioBusiness usuarioBusiness = new UsuarioBusiness();
		
		boolean logar = false;	
		logar = usuarioBusiness.logar(usuario);
		
		RequestDispatcher requestDispatcher;
		
		if (logar == true) {
			requestDispatcher = request.getRequestDispatcher("/home.jsp");
			requestDispatcher.forward(request, response);
		}
		else {
			requestDispatcher = request.getRequestDispatcher("/index.jsp");
			requestDispatcher.forward(request, response);
		}
	}
}
