package br.com.verity.helloworld.dao;

import static javax.swing.JOptionPane.showMessageDialog;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.regexp.internal.RE;

import br.com.verity.helloworld.bean.Produto;
import br.com.verity.helloworld.connection.ConnectionFactory;

public class ProdutoDAO {
	private Connection connection;
	private String sql;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	public void inserirProduto(Produto produto){
		connection = ConnectionFactory.createConnection();
		sql = "Insert Into Produto Values(?,?,?,?,?)";
		
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, produto.getNome());
			preparedStatement.setDate(2, produto.getDataCompra());
			preparedStatement.setString(3, produto.getDescricao());
			preparedStatement.setInt(4, produto.getQtEstoque());
			preparedStatement.setDouble(5, produto.getPreco());
			
			preparedStatement.execute();
			
		} catch (SQLException e) {
			System.out.println("Erro SQL ao Inserir: " + e);
		}
	}
	
	public List<Produto> getLista(){
		List<Produto> listaProduto = new ArrayList<Produto>();
		
		connection = ConnectionFactory.createConnection();
		sql = "Select * From Produto";
		
		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				int id = resultSet.getInt("idProduto");
				String nome = resultSet.getString("nome");
				Date dataCompra = resultSet.getDate("dataCompra");
				String descricao = resultSet.getString("descricao");
				int qtEstoque = resultSet.getInt("qtEstoque");
				double preco = resultSet.getDouble("preco");
				
				listaProduto.add(new Produto(id, nome, dataCompra, descricao, qtEstoque, preco));
			}
		} catch (SQLException e) {
			System.out.println("Erro SQL ao Listar Produtos: " + e);
		}
		
		return listaProduto;		
	}

	public int consultarProduto(String nomeProduto) {
		int idProduto = 0;
		
		connection = ConnectionFactory.createConnection();
		sql = "Select * From Produto where nome like ?";
		
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, nomeProduto);
			
			resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				idProduto = resultSet.getInt("idProduto");
			}
			
		} catch (SQLException e) {
			System.out.println("Erro SQL ao Listar Produtos: " + e);
		}
		
		return idProduto;
	}
		
	public Produto consultarProduto(int idProduto) {		
		Produto produto = null;
		
		connection = ConnectionFactory.createConnection();
		sql = "Select * From Produto where idProduto=?";
		
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, idProduto);
			
			resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				String nome = resultSet.getString("nome");
				Date dataCompra = resultSet.getDate("dataCompra");
				String descricao = resultSet.getString("descricao");
				int qtEstoque = resultSet.getInt("qtEstoque");
				double preco = resultSet.getDouble("preco");
				
				produto = new Produto(nome, dataCompra, descricao, qtEstoque, preco);
			}
			
		} catch (SQLException e) {
			System.out.println("Erro SQL ao buscar Produto: " + e);
		}
		
		return produto;
	}
	
	public void deletarProduto(int idProduto) {
		connection = ConnectionFactory.createConnection();
		sql = "Delete From Produto Where idProduto = ?";
		
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, idProduto);
			
			preparedStatement.execute();
			
		} catch (SQLException e) {
			showMessageDialog(null, "Erro SQL ao Deletar Produto" + e);
		}
	}

	public void atualizarProduto(Produto produto, int idProduto) {
		connection = ConnectionFactory.createConnection();
		sql = "Update Produto set nome=?, dataCompra=?, descricao=?, qtEstoque=?, preco=? where idProduto=?";
		
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, produto.getNome());
			preparedStatement.setDate(2, produto.getDataCompra());
			preparedStatement.setString(3, produto.getDescricao());
			preparedStatement.setInt(4, produto.getQtEstoque());
			preparedStatement.setDouble(5, produto.getPreco());
			preparedStatement.setDouble(6, idProduto);
			
			preparedStatement.execute();
		}  catch (SQLException e) {
			System.out.println("Erro SQL ao Deletar Produto: " + e);
		}
	}
}
