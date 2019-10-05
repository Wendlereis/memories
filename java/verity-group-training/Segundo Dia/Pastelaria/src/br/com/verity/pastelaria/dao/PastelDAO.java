package br.com.verity.pastelaria.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static javax.swing.JOptionPane.*;

import br.com.verity.pastelaria.bean.Pastel;
import br.com.verity.pastelaria.connection.ConnectionFactory;

public class PastelDAO {
	private Connection connection;
	String sql = "";
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	
	public void inserirPastel(Pastel pastel) {
		connection = ConnectionFactory.createConnection();
		sql = "Insert into Pastel values(?,?,?,?)";
		
		try {			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, pastel.getNmPastel());
			preparedStatement.setInt(2, pastel.getQtdEstoque());
			preparedStatement.setDate(3, pastel.getDtValidade());
			preparedStatement.setString(4, pastel.getDsPastel());
			
			preparedStatement.execute();
			
		}
		catch (SQLException e) {
			showMessageDialog(null, "Erro SQL ao Inserir Pastel" + e);
		}
	}
	
	public List<Pastel> getPasteis() {
		List<Pastel> pasteis = new ArrayList<Pastel>();
		
		connection = ConnectionFactory.createConnection();
		sql = "Select * From Pastel";
		
		try {							
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				String nmPastel = resultSet.getString("nmPastel");
				int qtdEstoque = resultSet.getInt("qtdEstoque");
				Date dtValidade = resultSet.getDate("dtValidade");
				String dsPastel = resultSet.getString("dsPastel");
								
				pasteis.add(new Pastel(nmPastel, qtdEstoque, dtValidade, dsPastel));
			}
		}
		catch (SQLException e) {
			showMessageDialog(null, "Erro SQL ao Buscar Todos Pasteis" + e);
		}
		catch (NullPointerException e) {
			showMessageDialog(null, "Erro NullPointer ao Buscar Todos Pasteis" + e);
		}
		
		return pasteis;
	}
	
	public Pastel pesquisarPastel(String saborPastel) {
		Pastel pastel = null;
		
		connection = ConnectionFactory.createConnection();
		sql = "Select * From Pastel where nmPastel = ?";
		
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, saborPastel);
			
			resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				String nmPastel = resultSet.getString("nmPastel");
				int qtdEstoque = resultSet.getInt("qtdEstoque");
				Date dtValidade = resultSet.getDate("dtValidade");
				String dsPastel = resultSet.getString("dsPastel");
				
				pastel = new Pastel(nmPastel, qtdEstoque, dtValidade, dsPastel);
			}
			
		} 
		catch (SQLException e) {
			showMessageDialog(null, "Erro SQL ao Buscar Todos Pasteis" + e);
		}
		catch (NullPointerException e) {
			showMessageDialog(null, "Erro NullPointer ao Buscar Todos Pasteis" + e);
		}
		
		return pastel;
	}
	
	public void deletarPastel(String pastel) {
		try {
			connection = ConnectionFactory.createConnection();
			sql = "Delete From Pastel Where nmPastel = ?";
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, pastel);
			
			preparedStatement.execute();
			
		} 
		catch (SQLException e) {
			showMessageDialog(null, "Erro SQL ao Deletar Pastel" + e);
		}
	}
	
	public void atualizarPastel(Pastel pastel, String antigoPastel) {
		connection = ConnectionFactory.createConnection();
		sql = "Update Pastel set nmPastel=?, qtdEstoque=?, dtValidade=?, dsPastel=? Where nmPastel=?";
		
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, pastel.getNmPastel());
			preparedStatement.setInt(2, pastel.getQtdEstoque());
			preparedStatement.setDate(3, pastel.getDtValidade());
			preparedStatement.setString(4, pastel.getDsPastel());
			preparedStatement.setString(5, antigoPastel);
			
			preparedStatement.execute();			
		}
		catch (SQLException e) {
			showMessageDialog(null, "Erro SQL ao Atualizar Pastel" + e);
		}
	}
} 
