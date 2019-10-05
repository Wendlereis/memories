package br.com.moosegroup.dao;

import br.com.moosegroup.connection.DBConnection;
import br.com.moosegroup.models.Grupo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class GrupoDAO {        
    public boolean cadastrarGrupo(Grupo grupo) {
        Connection connection = DBConnection.getConnection();
        String sql = "Insert Into Grupos Values (?, ?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, getIdGrupo() + 1);
            preparedStatement.setString(2, grupo.getNome());
            preparedStatement.setInt(3, getIdAcesso());
            preparedStatement.setInt(4, getIdTurma(grupo.getTurma())); 
            preparedStatement.setInt(5, getMaxFoguete());    
            preparedStatement.execute();
            
            return true;
        } 
        catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar um grupo.\n\n" + e);
        }
        catch(NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado.\n\n" + e);
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro no código.\n\n" + e);
        }
        
        return false;
    }

    private int getIdGrupo(){
        int IdGrupo = 0;

        Connection connection = DBConnection.getConnection();
        String sql = "Select Max(id_grupo) idGrupo From Grupos";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                IdGrupo = rs.getInt("idGrupo");
            }
        }
        catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Id Grupo.\n\n" + e);
        }

        return IdGrupo;
    }    
    
    public boolean cadastrarFoguete(Grupo grupo, double peso){                
        Connection connection = DBConnection.getConnection();

        String sql = "Insert Into Foguetes Values(?, ?, ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, getMaxFoguete()+1);
            preparedStatement.setString(2, grupo.getFoguete());
            preparedStatement.setDouble(3, peso);

            preparedStatement.execute();
            
            return true;
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar o foguete.\n\n" + e);
        }
        
        return false;
    }
    
    private int getMaxFoguete(){
        int idFoguete = 0;

        Connection connection = DBConnection.getConnection();
        String sql = "Select Max(id_foguete) idFoguete From Foguetes";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                idFoguete = rs.getInt("idFoguete");
            }
        }
        catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar o Foguete.\n\n" + e);
        }
        catch (Exception e) {
          JOptionPane.showMessageDialog(null, "Erro.\n\n" + e);
        }

        return idFoguete;
    }
    
    private int getIdFoguete(Grupo grupo){
        int idFoguete = 0;
        
        Connection connection = DBConnection.getConnection();
        String sql = "Select id_foguete idFoguete From Foguetes where nome = ?";       
                      
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, grupo.getFoguete());
            
            ResultSet rs = p.executeQuery();
            
            if (rs.next()) {
                idFoguete = rs.getInt("idFoguete");
            }
        }
        catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Id Foguete." + e);
        } 
        
        return idFoguete;
    }
    
    public boolean cadastrarAcesso(Grupo grupo){
        Connection connection = DBConnection.getConnection();

        String sql = "Insert Into Logins Values(?, ?, ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, getIdAcesso()+1);
            preparedStatement.setString(2, grupo.getNomeAcesso());
            preparedStatement.setString(3, grupo.getSenha());

            preparedStatement.execute();
            
            return true;
        } 
        catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar um Login." +e);
        } 
        
        return false;
    }

    private int getIdAcesso(){
        int idAcesso = 0;

        Connection connection = DBConnection.getConnection();
        String sql = "Select Max(id_login) idlogin From Logins";

        try {
            PreparedStatement p = connection.prepareStatement(sql);
            ResultSet rs = p.executeQuery();

            if (rs.next()) {
                idAcesso = rs.getInt("idlogin");
            }
        }
        catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar um Login.\n\n" + e);
        }
        catch (Exception e) {
          JOptionPane.showMessageDialog(null, "Erro.\n\n" + e);
        }

        return idAcesso;
    }

    private int getIdTurma(String turma){
        int IdTurma = 0;

        Connection connection = DBConnection.getConnection();
        String sql = "Select id_turma idTurma From Turmas Where nome = ?";

        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, turma);

            ResultSet rs = p.executeQuery();

            if (rs.next()) {
                IdTurma = rs.getInt("idTurma");
            }
        }
        catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar um Id Turma.\n\n" + e);
        }
        catch (Exception e) {
          JOptionPane.showMessageDialog(null, "Erro.\n\n" + e);
        }
        return IdTurma;
    }

    public List<String> getTurma(){
        List<String> listaTurma = new ArrayList<>();

        Connection connection = DBConnection.getConnection();
        String sql = "Select nome From Turmas";

        try {
            PreparedStatement p = connection.prepareStatement(sql);
            ResultSet rs = p.executeQuery();

            while (rs.next()) {
                String grupo = rs.getString("nome");
                listaTurma.add(grupo);
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

        return listaTurma;
    }

    public boolean alterarGrupo( Grupo grupo) {
        Connection connection = DBConnection.getConnection();
        String sql = "Update Grupos set nome = ?, id_turma = ? where id_grupo = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, grupo.getNome());
            preparedStatement.setInt(2, getIdTurma(grupo.getTurma()));
            preparedStatement.setInt(3, grupo.getIdGrupo());
            
            preparedStatement.execute();
            
            return true;
        } 
        catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar um grupo." + e);
        } 
        catch(NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado." + e);
        } 
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro no código." + e);
        }
        
        return false;
    }
    
    public boolean alterarAcesso(Grupo grupo){
        Connection connection = DBConnection.getConnection();
        String sql = "Update Logins set Login = ?, senha = ? where id_Login = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, grupo.getNomeAcesso());
            preparedStatement.setString(2, grupo.getSenha());
            preparedStatement.setInt(3, grupo.getId());
            
            preparedStatement.execute();
            
            return true;
        } 
        catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar um Acesso." + e);
        } 
        catch(NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado." + e);
        } 
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro no código." + e);
        }
        
        return false;
    }
    
    public boolean alterarFoguete(Grupo grupo){
        Connection connection = DBConnection.getConnection();
        String sql = "Update Foguetes set nome = ?, peso = ? where id_foguete = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, grupo.getFoguete());
            preparedStatement.setDouble(2,grupo.getPesoFoguete());
            preparedStatement.setInt(3, grupo.getIdFoguete());
            
            preparedStatement.execute();
            
            return true;
        } 
        catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar um Foguete." + e);
        } 
        catch(NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado." + e);
        } 
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro no código." + e);
        }
        
        return false;
    }
    
    public boolean excluirGrupo(Grupo grupo){
        Connection connection = DBConnection.getConnection();
        String sql = "Delete From Grupos Where id_grupo = ?";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setInt(1, grupo.getIdGrupo());
            
            p.execute();
            
            return true;
        } 
        catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir um grupo." + e);
        } 
        catch(NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado." + e);
        } 
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro no código." + e);
        }
        
        return false;
    }
    
    public boolean excluirFoguete(Grupo grupo){
        Connection connection = DBConnection.getConnection();
        String sql = "Delete From Foguetes Where id_foguete = ?";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setInt(1, grupo.getIdFoguete());
            
            p.execute();
            
            return true;
        } 
        catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir um foguete do grupo." + e);
        } 
        catch(NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado." + e);
        } 
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro no código." + e);
        }
        
        return false;
    } 
    
    public boolean excluirIntegrantesGrupo(Grupo grupo){
        Connection connection = DBConnection.getConnection();
        String sql = "Delete From Integrantes Where id_grupo = ?";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setInt(1, grupo.getIdGrupo());
            
            p.execute();
            
            return true;
        } 
        catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir integrantes do grupo." + e);
        } 
        catch(NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado." + e);
        } 
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro no código." + e);
        }
        
        return false;
    }
    
    public boolean excluirLancamentosGrupo(Grupo grupo){
        Connection connection = DBConnection.getConnection();
        String sql = "Delete From Lancamentos Where id_grupo = ?";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setInt(1, grupo.getIdGrupo());
            
            p.execute();
            
            return true;
        } 
        catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir Lancamento do grupo." + e);
        } 
        catch(NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado." + e);
        } 
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro no código." + e);
        }
        
        return false;
    }
    
    public  List<Grupo> consultarGrupo(String filtro){
        List<Grupo> listaGrupo = null;

        Connection connection = DBConnection.getConnection();
        String sql = "Select g.id_grupo idGrupo, g.nome Grupo, t.id_turma idTurma, t.nome Turma, f.id_foguete idFoguete, f.nome Foguete, l.id_login idLogin, l.login, l.senha, f.peso pesoFoguete "
             +"From Grupos g "
             +"Join Turmas t On t.Id_Turma = g.Id_Turma "
             +"Join Foguetes f On f.id_foguete = g.id_foguete "
             +"Join Logins l On l.id_login = g.id_login "
             +"Where g.nome like ? or "
             +"t.nome like ? or "
             +"f.nome like ? or "
             +"l.login like ?";       
                      
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, '%'+filtro+'%');
            p.setString(2, '%'+filtro+'%');
            p.setString(3, '%'+filtro+'%');
            p.setString(4, '%'+filtro+'%');           
            
            ResultSet rs = p.executeQuery();

            listaGrupo = listarGrupo(rs);
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro - Grupo não encontrado\n\n" + e);
        }
        catch(NullPointerException e) {
          JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado.\n\n" + e);
        }
        catch(Exception e) {
          JOptionPane.showMessageDialog(null, "Ocorreu um erro no código.\n\n" + e);
        }

        return listaGrupo;
    }

    private List<Grupo> listarGrupo(ResultSet rs) throws SQLException{
        List<Grupo> listaGrupo = new ArrayList<>();
        
        int idGrupo = 0, idTurma = 0, idFoguete = 0, idLogin = 0;
        String nomeGrupo, turma, foguete, login, senha;
        double pesoFoguete;
        
        while (rs.next()) {           
            idGrupo = rs.getInt("idGrupo");
            nomeGrupo = rs.getString("Grupo");            
            idTurma = rs.getInt("idTurma");
            turma = rs.getString("Turma");            
            idFoguete = rs.getInt("idFoguete");
            foguete = rs.getString("Foguete");            
            idLogin = rs.getInt("idLogin");
            login = rs.getString("login");
            senha = rs.getString("senha");
            pesoFoguete = rs.getDouble("pesoFoguete");
                        
            listaGrupo.add(new Grupo(idGrupo, nomeGrupo, idTurma, turma, idFoguete, foguete, idLogin, login, senha, pesoFoguete));
        }

        return listaGrupo;
    }
}
