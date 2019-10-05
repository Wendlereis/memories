package br.com.verity.helloworld.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import br.com.verity.helloworld.business.ProdutoBusiness;

@WebServlet("/ExcluirProdutoServlet")
public class ExcluirProdutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		ProdutoBusiness produtoBusiness = new ProdutoBusiness();
		produtoBusiness.deletar(id);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/listar-produtos.jsp");
		requestDispatcher.forward(request, response);
	}
}
