package br.com.verity.helloworld.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConnectionFactory {
	private static Connection conexao = null;
	private static String url = "jdbc:sqlserver://localhost:1433;databaseName=Loja;";
	private static String user = "weis";
	private static String password = "w42443890.";
	
	public static Connection createConnection() {		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conexao = DriverManager.getConnection(url, user, password);
		} 
		catch(ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar o driver de conex�o\n"+ e);
            System.out.println(e);
        }
        catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao estabelecer conex�o com o banco de dados\n"+ e);
            System.out.println(e);
        }
		
		return conexao;
	}
}
