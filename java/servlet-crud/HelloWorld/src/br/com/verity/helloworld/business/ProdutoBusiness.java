package br.com.verity.helloworld.business;

import java.util.ArrayList;
import java.util.List;

import br.com.verity.helloworld.bean.Produto;
import br.com.verity.helloworld.dao.ProdutoDAO;

public class ProdutoBusiness {
		
	public void inserir(Produto produto) {
		ProdutoDAO produtoDAO = new ProdutoDAO(); 
		produtoDAO.inserirProduto(produto);		
	}

	public List<Produto> getLista() {
		List<Produto> listaProdutos = new ArrayList<Produto>();  
		
		ProdutoDAO produtoDAO = new ProdutoDAO(); 
		listaProdutos = produtoDAO.getLista();
		
		return listaProdutos;
	}

	public int cosultarID(String nome) {
		ProdutoDAO produtoDAO = new ProdutoDAO(); 
		return produtoDAO.consultarProduto(nome);
	}
	
	public Produto consultarProduto(int id) {
		ProdutoDAO produtoDao = new ProdutoDAO();
		return produtoDao.consultarProduto(id);
	}
	
	public void deletar(int id) {
		ProdutoDAO produtoDAO = new ProdutoDAO(); 		
		produtoDAO.deletarProduto(id);
	}

	public void atualizar(Produto produto, int id) {
		ProdutoDAO dao = new ProdutoDAO();
		dao.atualizarProduto(produto, id);		
	}
}
