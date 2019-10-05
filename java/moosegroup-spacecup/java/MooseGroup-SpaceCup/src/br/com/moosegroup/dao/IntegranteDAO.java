package br.com.moosegroup.dao;

import br.com.moosegroup.connection.DBConnection;
import br.com.moosegroup.models.Grupo;
import br.com.moosegroup.models.Integrante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class IntegranteDAO {
    public boolean registrarIntegrante(Integrante integrante) {
        Connection connection = DBConnection.getConnection();
        String query = "INSERT INTO INTEGRANTES VALUES(?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, integrante.getId_integrante());
            preparedStatement.setString(2, integrante.getNomeCompleto());
            preparedStatement.setString(3, integrante.getRm());
            preparedStatement.setInt(4, integrante.getId_grupo());
            preparedStatement.execute();
            return true;
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao registrar integrante.\n\n" + e);
        } catch(NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado.\n\n" + e);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro no código.\n\n" + e);
        }

        return false;
    }

    public void alterarIntegrante(Integrante integrante) {
        Connection connection = DBConnection.getConnection();
        String query = "UPDATE INTEGRANTES SET NOME = ?, RM = ?, ID_GRUPO = ? WHERE ID_INTEGRANTE = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, integrante.getNomeCompleto());
            preparedStatement.setString(2, integrante.getRm());
            preparedStatement.setInt(3, integrante.getId_grupo());
            preparedStatement.setInt(4, integrante.getId_integrante());
            preparedStatement.execute();
            JOptionPane.showMessageDialog(null, "Integrante alterado com sucesso.");
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar o integrante.");
        } catch(NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado.");
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro no código.");
        }
    }

    public void excluirIntegrante(int id) {
        Connection connection = DBConnection.getConnection();
        String query = "DELETE INTEGRANTES WHERE ID_INTEGRANTE = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            JOptionPane.showMessageDialog(null, "Integrante deletado com sucesso.");
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir o integrante.");
        } catch(NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado.");
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro no código.");
        }
    }

    public List<Integrante> listarIntegrante(String term, Grupo grupo) {
        Connection connection = DBConnection.getConnection();
        String query = "";
        if (grupo != null) {
             query = "select i.id_integrante, i.nome nome_integrante , i.rm, i.id_grupo , g.nome nome_grupo "
                   + "from integrantes i "
                   + "join grupos g "
                   + "on g.id_grupo = i.id_grupo "
                   + "and g.id_grupo = "+ grupo.getIdGrupo()
                   + " where i.nome like ? or i.rm like ? or g.nome like ?"
                   + " order by i.nome";
        } else {
             query = "select i.id_integrante, i.nome nome_integrante , i.rm, i.id_grupo , g.nome nome_grupo "
                + "from integrantes i "
                + "join grupos g "
                + "on g.id_grupo = i.id_grupo "
                + "where i.nome like ? or i.rm like ? or g.nome like ? "
                + "order by g.id_grupo, i.nome";
        }

        List<Integrante> list = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, ('%' + term + '%'));
            preparedStatement.setString(2, ('%' + term + '%'));
            preparedStatement.setString(3, ('%' + term + '%'));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idInt = resultSet.getInt("id_integrante");
                String nomeInt = resultSet.getString("nome_integrante");
                String rm = resultSet.getString("rm");
                int idGrupo = resultSet.getInt("id_grupo");
                String nomeGrupo = resultSet.getString("nome_grupo");
                list.add(new Integrante(idInt, nomeInt, rm, idGrupo, nomeGrupo));
            }
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar o(s) integrante(s)." + e);
        } catch(NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado.");
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro no código.");
        }

        return list;
    }

    public int getIdIntegrante(){
        int idIntegrante = 0;

        Connection connection = DBConnection.getConnection();
        String sql = "select max(id_integrante) + 1 id_integrante from integrantes";

        try {
            PreparedStatement p = connection.prepareStatement(sql);
            ResultSet rs = p.executeQuery();

            if (rs.next()) {
                idIntegrante = rs.getInt("id_integrante");
            }
        }
        catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Id Foguete." + e);
        }

        return idIntegrante;
    }
    
    public List<String> getGrupos(){
        List<String> listaGrupo = new ArrayList<>();

        Connection connection = DBConnection.getConnection();
        String sql = "Select nome From Grupos where nome <> 'ADMIN'";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String grupo = resultSet.getString("nome");
                listaGrupo.add(grupo);
            }
        }
        catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Turma.\n\n" + e);
        }
        catch(NullPointerException e) {
          JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado.\n\n" + e);
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Turma.\n\n" + e);
        }

        return listaGrupo;
    }
}
