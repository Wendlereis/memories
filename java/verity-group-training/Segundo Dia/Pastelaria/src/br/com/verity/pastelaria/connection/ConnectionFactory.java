package br.com.verity.pastelaria.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConnectionFactory {
	private static Connection conexao = null;
	private static String url = "jdbc:sqlserver://localhost:1433;databaseName=Pastelaria;";
	private static String user = "weis";
	private static String password = "w42443890.";
	
	public static Connection createConnection() {		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conexao = DriverManager.getConnection(url, user, password);
		} 
		catch(ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar o driver de conexão\n"+ e);
        }
        catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao estabelecer conexão com o banco de dados\n"+ e);
        }
		
		return conexao;
	}
}
