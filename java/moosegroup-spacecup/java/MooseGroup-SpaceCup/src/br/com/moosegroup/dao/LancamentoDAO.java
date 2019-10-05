package br.com.moosegroup.dao;

import br.com.moosegroup.connection.DBConnection;
import br.com.moosegroup.models.Grupo;
import br.com.moosegroup.models.Lancamento;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class LancamentoDAO {
    public void registrarLancamento(Lancamento lancamento) {
        Connection connection = DBConnection.getConnection();
        String query = "INSERT INTO LANCAMENTOS VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, lancamento.getId());
            preparedStatement.setInt(2, lancamento.getIdGrupo());
            preparedStatement.setDouble(3, lancamento.getAltitudeMaxima());
            preparedStatement.setDouble(4, lancamento.getVelocidadeMaxima());
            preparedStatement.setDouble(5, lancamento.getTempoPropulsao());
            preparedStatement.setDouble(6, lancamento.getPicoAceleracao());
            preparedStatement.setDouble(7, lancamento.getAceleracaoMedia());
            preparedStatement.setDouble(8, lancamento.getTempoApogeuDescida());
            preparedStatement.setDouble(9, lancamento.getTempoEjecao());
            preparedStatement.setDouble(10, lancamento.getAltitudeEjecao());
            preparedStatement.setDouble(11, lancamento.getTaxaDescida());
            preparedStatement.setDouble(12, lancamento.getDuracaoVoo());
            preparedStatement.setDate(13, lancamento.getDataLancamento());
            preparedStatement.setDouble(14, lancamento.getDistanciaAlvo());
            preparedStatement.setDouble(15, lancamento.getAnguloLancamento());
            preparedStatement.setDouble(16, lancamento.getVelocidadeVento());
            preparedStatement.execute();

            JOptionPane.showMessageDialog(null, "Lancamento registrado com sucesso.");

        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao registrar um lançamento.");
        } catch(NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado.");
        } catch(HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro no código.");
        }
    }

    public List<Lancamento> listarLancamento(String term, Grupo g) {
        Connection connection = DBConnection.getConnection();
        String query = "";
        if (g == null) {
            query = "select l.*, g.nome nome_grupo, f.id_foguete, f.nome nome_foguete, f.peso "+
                    "from lancamentos l "+
                    "join grupos g "+
                    "on g.id_grupo = l.id_grupo "+
                    "join foguetes f "+
                    "on f.id_foguete = g.id_foguete "+
                    "where l.altitude_maxima = ? "+
                    "or l.tempo_propulsao = ? "+
                    "or l.pico_aceleracao = ? "+
                    "or l.aceleracao_media = ? "+
                    "or l.tempo_apogeu_descida = ? "+
                    "or l.tempo_ejecao = ? "+
                    "or l.altitude_ejecao = ? "+
                    "or l.taxa_descida = ? "+
                    "or l.duracao_voo = ? "+
                    "or l.distancia_alvo = ? "+
                    "or l.angulo_lancamento = ? "+
                    "or l.velocidade_vento = ?";
        } else {
            query = "select l.*, g.nome nome_grupo, f.id_foguete, f.nome nome_foguete, f.peso "+
                    "from lancamentos l "+
                    "join grupos g "+
                    "on g.id_grupo = l.id_grupo "+
                    "join foguetes f "+
                    "on f.id_foguete = g.id_foguete "+
                    "and g.id_grupo = "+ g.getIdGrupo() +
                    "where l.altitude_maxima = ? "+
                    "or l.tempo_propulsao = ? "+
                    "or l.pico_aceleracao = ? "+
                    "or l.aceleracao_media = ? "+
                    "or l.tempo_apogeu_descida = ? "+
                    "or l.tempo_ejecao = ? "+
                    "or l.altitude_ejecao = ? "+
                    "or l.taxa_descida = ? "+
                    "or l.duracao_voo = ? "+
                    "or l.distancia_alvo = ? "+
                    "or l.angulo_lancamento = ? "+
                    "or l.velocidade_vento = ?";
        }
       
                       
        List<Lancamento> list = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareCall(query);
            preparedStatement.setDouble(1, Double.valueOf(term));
            preparedStatement.setDouble(2, Double.valueOf(term));
            preparedStatement.setDouble(3, Double.valueOf(term));
            preparedStatement.setDouble(4, Double.valueOf(term));
            preparedStatement.setDouble(5, Double.valueOf(term));
            preparedStatement.setDouble(6, Double.valueOf(term));
            preparedStatement.setDouble(7, Double.valueOf(term));
            preparedStatement.setDouble(8, Double.valueOf(term));
            preparedStatement.setDouble(9, Double.valueOf(term));
            preparedStatement.setDouble(10, Double.valueOf(term));
            preparedStatement.setDouble(11, Double.valueOf(term));
            preparedStatement.setDouble(12, Double.valueOf(term));
            
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add(new Lancamento(
                    resultSet.getInt("ID_LANCAMENTO"),
                    resultSet.getInt("ID_GRUPO"),
                    resultSet.getString("NOME_GRUPO"),
                    resultSet.getString("NOME_FOGUETE"),
                    resultSet.getDouble("PESO"),
                    resultSet.getDouble("ALTITUDE_MAXIMA"),
                    resultSet.getDouble("VELOCIDADE_MAXIMA"),
                    resultSet.getDouble("TEMPO_PROPULSAO"),
                    resultSet.getDouble("PICO_ACELERACAO"),
                    resultSet.getDouble("ACELERACAO_MEDIA"),
                    resultSet.getDouble("TEMPO_APOGEU_DESCIDA"),
                    resultSet.getDouble("TEMPO_EJECAO"),
                    resultSet.getDouble("ALTITUDE_EJECAO"),
                    resultSet.getDouble("TAXA_DESCIDA"),
                    resultSet.getDouble("DURACAO_VOO"),
                    resultSet.getDate("DATA_LANCAMENTO"),
                    resultSet.getDouble("DISTANCIA_ALVO"),
                    resultSet.getDouble("ANGULO_LANCAMENTO"),
                    resultSet.getDouble("VELOCIDADE_VENTO")
                ));
            }
            return list;
        } catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor digite somente numeros inteiros ou decimais usando ponto.\n\n");
        } catch(NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado.\n\n" + e);
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar lançamentos.\n\n" + e);
        }
        return null;
    }

    public void excluirLancamento(int id) {
        Connection connection = DBConnection.getConnection();
        String query = "DELETE LANCAMENTOS WHERE ID_LANCAMENTO = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            JOptionPane.showMessageDialog(null, "Lançamento excluído com sucesso.");
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir um Lançamento.\n\n" + e);
        } catch(NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado.\n\n" + e);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro no código.\n\n" + e);
        }
    }

    public boolean alterarLancamento(Lancamento lancamento) {
        Connection connection = DBConnection.getConnection();
        String query = "UPDATE LANCAMENTOS SET ID_GRUPO = ?, ALTITUDE_MAXIMA = ?, VELOCIDADE_MAXIMA = ?,"
                + " TEMPO_PROPULSAO = ?, PICO_ACELERACAO = ?, ACELERACAO_MEDIA = ?, TEMPO_APOGEU_DESCIDA = ?, TEMPO_EJECAO = ?,"
                + " ALTITUDE_EJECAO = ?, TAXA_DESCIDA = ?, DURACAO_VOO = ?, DATA_LANCAMENTO = ?, DISTANCIA_ALVO = ?,"
                + " ANGULO_LANCAMENTO = ?, VELOCIDADE_VENTO = ? WHERE ID_LANCAMENTO = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, lancamento.getIdGrupo());
            preparedStatement.setDouble(2, lancamento.getAltitudeMaxima());
            preparedStatement.setDouble(3, lancamento.getVelocidadeMaxima());
            preparedStatement.setDouble(4, lancamento.getTempoPropulsao());
            preparedStatement.setDouble(5, lancamento.getPicoAceleracao());
            preparedStatement.setDouble(6, lancamento.getAceleracaoMedia());
            preparedStatement.setDouble(7, lancamento.getTempoApogeuDescida());
            preparedStatement.setDouble(8, lancamento.getTempoEjecao());
            preparedStatement.setDouble(9, lancamento.getAltitudeEjecao());
            preparedStatement.setDouble(10, lancamento.getTaxaDescida());
            preparedStatement.setDouble(11, lancamento.getDuracaoVoo());
            preparedStatement.setDate(12, lancamento.getDataLancamento());
            preparedStatement.setDouble(13, lancamento.getDistanciaAlvo());
            preparedStatement.setDouble(14, lancamento.getAnguloLancamento());
            preparedStatement.setDouble(15, lancamento.getVelocidadeVento());
            preparedStatement.setInt(16, lancamento.getId());
            preparedStatement.execute();
            JOptionPane.showMessageDialog(null, "Lançamento alterado com sucesso.");
            return true;
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar um lançamento.\n\n" + e);
        } catch(NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado.\n\n" + e);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro no código.\n\n" + e);
        }
        return false;
    }

    public int getIdLancamento(){
        int idLancamento = 0;

        Connection connection = DBConnection.getConnection();
        String sql = "select max(id_lancamento) + 1 id_lancamento from lancamentos";

        try {
            PreparedStatement p = connection.prepareStatement(sql);
            ResultSet rs = p.executeQuery();

            if (rs.next()) {
                idLancamento = rs.getInt("id_lancamento");
            }
        }
        catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Id Foguete." + e);
        }

        return idLancamento;
    }

}
