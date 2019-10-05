package br.com.verity.helloworld.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.verity.helloworld.bean.Usuario;
import br.com.verity.helloworld.connection.ConnectionFactory;

public class UsuarioDAO {
	private Connection connection;
	private String sql;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	public boolean logar(Usuario usuario) {
		boolean logar = false;
		
		connection = ConnectionFactory.createConnection();
		sql = "Select * From Login where usuario like ? and senha like ?";
	
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, usuario.getLogin());
			preparedStatement.setString(2, usuario.getSenha());
			
			resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				logar = true;
			}
		} catch (SQLException e) {
			System.out.println("Erro SQL ao buscar login" + e);
		}
		
		return logar;
	}
}
