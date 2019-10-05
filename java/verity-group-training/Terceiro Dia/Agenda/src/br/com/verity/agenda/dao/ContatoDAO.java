package br.com.verity.agenda.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static javax.swing.JOptionPane.*;

import br.com.verity.agenda.bean.Contato;
import br.com.verity.agenda.connection.ConnectionFactory;

public class ContatoDAO {
	private Connection connection;
	String sql = "";
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	
	public void inserirContato(Contato contato) {
		connection = ConnectionFactory.getConnection();
		sql = "Insert Into Contato Values(?,?,?,?)";
		
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, contato.getNome());
			preparedStatement.setString(2, contato.getEmail());
			preparedStatement.setDate(3, contato.getDataNascimento());
			preparedStatement.setString(4, contato.getEndereco());
			
			preparedStatement.execute();
			
		} catch (SQLException e) {
			System.out.println("Erro ao inserir: " + e);
		}
	}

	public List<Contato> getLista(){
		List<Contato> lista = new ArrayList<Contato>();
		
		connection = ConnectionFactory.getConnection();
		sql = "Select * From Contato";
		
		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				String nome = resultSet.getString("Nome");
				String endereco = resultSet.getString("Endereco");
				String email = resultSet.getString("Email");
				Date dataNascimento = resultSet.getDate("DataNascimento");
			
				lista.add(new Contato(nome, email, endereco, dataNascimento));
			}
		}
		catch (Exception e) {
			System.out.println("Erro ao Pesquisar: " + e);
		}
		
		return lista;
	}

	public static void main(String[] args) {
		List<Contato> contato = new ArrayList<Contato>();
		String listaContatos = "";		
		
		ContatoDAO dao = new ContatoDAO();
		contato = dao.getLista(); 
		
		if (contato != null) {
			for(Contato p : contato){
				listaContatos += "Nomw: " + p.getNome() + " Email: " + p.getEmail() + " Datanascimetp: " + p.getDataNascimento() + " Endereco: " + p.getEndereco() + "\n";
			}
		}
		
		System.out.println(listaContatos);
	}
}

