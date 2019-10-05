package br.com.moosegroup.dao;

import br.com.moosegroup.connection.DBConnection;
import br.com.moosegroup.models.Admin;
import br.com.moosegroup.models.Grupo;
import br.com.moosegroup.models.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class UsuarioDAO {
    public Usuario logarSistema(String nomeAcesso, String senha) {
        Connection connection = DBConnection.getConnection();
        String query = "select l.id_login, l.login, l.senha , g.id_grupo , g.nome, t.id_turma, t.nome as NOME_TURMA, f.id_foguete, f.nome as NOME_FOGUETE, f.peso "
                + "from logins l "
                + "join grupos g "
                + "on l.id_login = g.id_login "
                + "join turmas t "
                + "on g.id_turma = t.id_turma "
                + "left join foguetes f "
                + "on g.id_foguete = f.id_foguete "
                + "where l.login = '"+ nomeAcesso +"' and l.senha = '"+ senha +"'";
        try {
            PreparedStatement p = connection.prepareStatement(query);
            ResultSet rs = p.executeQuery();
            
            if(rs.next()) {
                String idLogin = rs.getString("id_login"); 
                String login = rs.getString("login");
                String senhaGrupo = rs.getString("senha");
                int idGrupo = rs.getInt("id_grupo");
                String nomeGrupo = rs.getString("nome");
                String nomeTurma = rs.getString("NOME_TURMA");
                int idTurma = rs.getInt("id_turma");
                int idFoguete = rs.getInt("id_foguete");
                String nomeFoguete = rs.getString("NOME_FOGUETE");
                Double pesoFoguete = rs.getDouble("peso");
                return nomeFoguete == null ? new Admin(Integer.parseInt(idLogin), login, senhaGrupo) : 
                      new Grupo(idGrupo, nomeGrupo, idTurma, nomeTurma, idFoguete, nomeFoguete, idFoguete, nomeAcesso, senha, pesoFoguete);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro Usuário não encontrado.\n\n" + e);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excutar a ação de login, formatação incorreta.\n\n" + e);
        }
        return null;
    }

    public void alterarUsuario(Usuario usuario) {
        Connection connection = DBConnection.getConnection();
        String query = "UPDATE LOGINS SET LOGIN = ?, SENHA = ? WHERE ID_LOGIN = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, usuario.getNomeAcesso());
            preparedStatement.setString(2, usuario.getSenha());
            preparedStatement.setInt(3, usuario.getId());
            preparedStatement.execute();
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar no usuário.");
        } catch(NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado.");
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro no código.");
        }
    }

    public void excluirUsuario(Usuario usuario) {
        Connection connection = DBConnection.getConnection();
        String query = "DELETE LOGINS WHERE ID_LOGIN = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(0, usuario.getId());
            preparedStatement.execute();
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir o usuário.");
        } catch(NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado.");
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro no código.");
        }
    }
}
