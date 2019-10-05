package br.com.verity.agenda.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConnectionFactory {
	private static Connection connection = null;
	private static String url = "jdbc:sqlserver://localhost:1433;databaseName=Agenda;";
	private static String user = "weis";
	private static String password = "w42443890.";
	
	public static Connection getConnection(){
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection(url, user, password);
		} 
		catch(ClassNotFoundException e) {
			System.out.println("Erro ao carregar o driver de conexão\n"+ e);
        }
        catch(SQLException e) {
            System.out.println("Erro ao estabelecer conexão com o banco de dados\n"+ e);
        }
		
		return connection;
	}
}
