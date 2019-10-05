package br.com.verity.helloworld.servlet;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import br.com.verity.helloworld.bean.Produto;
import br.com.verity.helloworld.business.ProdutoBusiness;

@WebServlet(name = "adicionaProduto", urlPatterns = "/adicionaProduto")
public class AdicionaProdutoServlet extends HttpServlet {
	private static final long serialVersionUID = 7618883699074676521L;

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		
		String descricao = request.getParameter("descricao");
		int qtEstoque = Integer.parseInt(request.getParameter("quantidade"));
		double preco = Double.parseDouble(request.getParameter("preco"));
				
		try {
			Date dataCompra = new Date(format.parse(request.getParameter("datacompra")).getTime());
			
			Produto produto = new Produto(nome, dataCompra, descricao, qtEstoque, preco);
			
			ProdutoBusiness produtoBusiness = new ProdutoBusiness();
			produtoBusiness.inserir(produto);
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/adicionar-produtos.jsp");
			requestDispatcher.forward(request, response);
		} 
		catch (ParseException e) {
			e.printStackTrace();
		}		
	}
}
