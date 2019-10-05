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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.threads.ResizableExecutor;

import br.com.verity.helloworld.bean.Produto;
import br.com.verity.helloworld.business.ProdutoBusiness;

@WebServlet("/AlterarProdutoServlet")
public class AlterarProdutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int id = Integer.parseInt(request.getParameter("id"));
    	
    	ProdutoBusiness produtoBusiness = new ProdutoBusiness();
    	Produto produto = produtoBusiness.consultarProduto(id);
    	
    	request.setAttribute("produto", produto);
    	
    	RequestDispatcher requestDispatcher = request.getRequestDispatcher("alterar-produtos.jsp");
    	requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int id = Integer.parseInt(request.getParameter("id"));
    	String nome = request.getParameter("nome");
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		
		String descricao = request.getParameter("descricao");
		int qtEstoque = Integer.parseInt(request.getParameter("quantidade"));
		double preco = Double.parseDouble(request.getParameter("preco"));
		
		try {
			Date dataCompra = new Date(format.parse(request.getParameter("datacompra")).getTime());
			
			Produto produto = new Produto(nome, dataCompra, descricao, qtEstoque, preco);
			
			ProdutoBusiness produtoBusiness = new ProdutoBusiness();
			produtoBusiness.atualizar(produto, id);
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/listar-produtos.jsp");
			requestDispatcher.forward(request, response);
		} 
		catch (ParseException e) {
			System.out.println("Erro converter data" + e);
		}
    }
}
