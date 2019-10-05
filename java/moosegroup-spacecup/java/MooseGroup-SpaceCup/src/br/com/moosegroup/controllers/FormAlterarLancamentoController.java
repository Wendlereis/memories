package br.com.moosegroup.controllers;

import br.com.moosegroup.dao.LancamentoDAO;
import br.com.moosegroup.models.Admin;
import br.com.moosegroup.models.Grupo;
import br.com.moosegroup.models.Lancamento;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class FormAlterarLancamentoController implements Initializable {

    @FXML
    private JFXTextField txtVelocidadeMaxima;

    @FXML
    private JFXTextField txtPesoFoguete;

    @FXML
    private JFXTextField txtAltitudeEjecao;

    @FXML
    private JFXTextField txtDistanciaAlvo;

    @FXML
    private JFXTextField txtTempEjecao;

    @FXML
    private JFXTextField txtNumeroLancamento;

    @FXML
    private DatePicker dtpDataLancamento;

    @FXML
    private JFXTextField txtPicoAceleracao;

    @FXML
    private JFXTextField txtTempoApogeuDescida;

    @FXML
    private JFXTextField txtNomeGrupo;

    @FXML
    private JFXTextField txtTempoPropulsao;

    @FXML
    private JFXButton btnAlterar;

    @FXML
    private JFXButton btnCancelar;

    @FXML
    private JFXTextField txtAceleracaoMedia;

    @FXML
    private JFXTextField txtNomeFoguete;

    @FXML
    private JFXTextField txtAnguloLancamento;

    @FXML
    private JFXTextField txtVelocidadeVento;

    @FXML
    private JFXTextField txtTaxaDescida;

    @FXML
    private JFXTextField txtAltitudeMaxima;

    @FXML
    private JFXTextField txtDuracaoVoo;
    private Grupo grupo;
    private Admin admin;
    private Lancamento lancamento;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void btnAlterarAction(ActionEvent event) throws IOException {
         try {
            if(txtNumeroLancamento.getText() == null || txtNumeroLancamento.getText().length() <= 0){
                JOptionPane.showMessageDialog(null, "Campo Número do lancamento é obrigatório.");
                return;
            }
            
            if(dtpDataLancamento.getValue() == null){
                JOptionPane.showMessageDialog(null, "Campo Data do lancamento é obrigatório.");
                return;
            }
            
            if(txtAnguloLancamento.getText() == null || txtAnguloLancamento.getText().length() <= 0){
                JOptionPane.showMessageDialog(null, "Campo Ângulo do lancamento é obrigatório.");
                return;
            }
            
            if(txtVelocidadeVento.getText() == null || txtVelocidadeVento.getText().length() <= 0){
                JOptionPane.showMessageDialog(null, "Campo Velocidade do Vento é obrigatório.");
                return;
            }
            
            if(txtAltitudeMaxima.getText() == null || txtAltitudeMaxima.getText().length() <= 0){
                JOptionPane.showMessageDialog(null, "Campo Altitude máxima é obrigatório.");
                return;
            }
            
            if(txtTempoPropulsao.getText() == null || txtTempoPropulsao.getText().length() <= 0){
                JOptionPane.showMessageDialog(null, "Campo Tempo Propulsão é obrigatório.");
                return;
            }
            
            if(txtPicoAceleracao.getText() == null || txtPicoAceleracao.getText().length() <= 0){
                JOptionPane.showMessageDialog(null, "Campo Pico Aceleração é obrigatório.");
                return;
            }
            
            if(txtTempEjecao.getText() == null || txtTempEjecao.getText().length() <= 0){
                JOptionPane.showMessageDialog(null, "Campo Tempo de Ejeção é obrigatório.");
                return;
            }
            
            if(txtTaxaDescida.getText() == null || txtTaxaDescida.getText().length() <= 0){
                JOptionPane.showMessageDialog(null, "Campo Taxa de Descida é obrigatório.");
                return;
            }
            
            if(txtTempoApogeuDescida.getText() == null || txtTempoApogeuDescida.getText().length() <= 0){
                JOptionPane.showMessageDialog(null, "Campo Tempo entre o Apogeu e Descida é obrigatório.");
                return;
            }
            
            if(txtVelocidadeMaxima.getText() == null || txtVelocidadeMaxima.getText().length() <= 0){
                JOptionPane.showMessageDialog(null, "Campo Velocidade Máxima é obrigatório.");
                return;
            }
            
            if(txtAceleracaoMedia.getText() == null || txtAceleracaoMedia.getText().length() <= 0){
                JOptionPane.showMessageDialog(null, "Campo Aceleração média é obrigatório.");
                return;
            }
            
            if(txtAltitudeEjecao.getText() == null || txtAltitudeEjecao.getText().length() <= 0){
                JOptionPane.showMessageDialog(null, "Campo Altitude Ejeção é obrigatório.");
                return;
            }
            
            if(txtDuracaoVoo.getText() == null || txtDuracaoVoo.getText().length() <= 0){
                JOptionPane.showMessageDialog(null, "Campo Duração do Voo é obrigatório.");
                return;
            }
            
            if(txtDistanciaAlvo.getText() == null || txtDistanciaAlvo.getText().length() <= 0){
                JOptionPane.showMessageDialog(null, "Campo Distância do Alvo é obrigatório.");
                return;
            }
            
           int numeroLancamento = Integer.valueOf(txtNumeroLancamento.getText());
            if (numeroLancamento < 0) {
                JOptionPane.showMessageDialog(null, "Digite um valor positivo para Número do Lançamento.");
                return;
            }
            Date dataLancamento = Date.valueOf(dtpDataLancamento.getValue());
            double anguloLancamento = Double.valueOf(txtAnguloLancamento.getText());
            if (anguloLancamento < 0) {
                JOptionPane.showMessageDialog(null, "Digite um valor positivo para Ângulo do Lançamento.");
                return;
            }
            double velocidadeVento = Double.valueOf(txtVelocidadeVento.getText());
            if (velocidadeVento < 0) {
                JOptionPane.showMessageDialog(null, "Digite um valor positivo para Velocidade do Vento.");
                return;
            }
            double altitudeMaxima = Double.valueOf(txtAltitudeMaxima.getText());
            if (altitudeMaxima < 0) {
                JOptionPane.showMessageDialog(null, "Digite um valor positivo para Altitude Máxima.");
                return;
            }
            double tempoPropulsao = Double.valueOf(txtTempoPropulsao.getText());
            if (tempoPropulsao < 0) {
                JOptionPane.showMessageDialog(null, "Digite um valor positivo para Tempo Propulsão máxima.");
                return;
            }
            double picoAceleracao = Double.valueOf(txtPicoAceleracao.getText());
            if (picoAceleracao < 0) {
                JOptionPane.showMessageDialog(null, "Digite um valor positivo para Pico Aceleração máxima.");
                return;
            }
            double tempoEjecao = Double.valueOf(txtTempEjecao.getText());
            if (tempoEjecao < 0) {
                JOptionPane.showMessageDialog(null, "Digite um valor positivo para Tempo Ejeção.");
                return;
            }
            double taxaDescida = Double.valueOf(txtTaxaDescida.getText());
            if (taxaDescida < 0) {
                JOptionPane.showMessageDialog(null, "Digite um valor positivo para Taxa de Descida.");
                return;
            }
            double tempoApogeuDescida = Double.valueOf(txtTempoApogeuDescida.getText());
            if (tempoApogeuDescida < 0) {
                JOptionPane.showMessageDialog(null, "Digite um valor positivo para Tempo Apogeu Descida.");
                return;
            }
            double velocidadeMaxima = Double.valueOf(txtVelocidadeMaxima.getText());
            if (velocidadeMaxima < 0) {
                JOptionPane.showMessageDialog(null, "Digite um valor positivo para Velocidade Máxima.");
                return;
            }
            double aceleracaoMedia = Double.valueOf(txtAceleracaoMedia.getText());
            if (aceleracaoMedia < 0) {
                JOptionPane.showMessageDialog(null, "Digite um valor positivo para Aceleração Média.");
                return;
            }
            double altitudeEjecao = Double.valueOf(txtAltitudeEjecao.getText());
            if (altitudeEjecao < 0) {
                JOptionPane.showMessageDialog(null, "Digite um valor positivo para Altitude de Ejeção.");
                return;
            }
            double duracaoVoo = Double.valueOf(txtDuracaoVoo.getText());
            if (duracaoVoo < 0) {
                JOptionPane.showMessageDialog(null, "Digite um valor positivo para Duração do Voo.");
                return;
            }
            double distanciaAlvo = Double.valueOf(txtDistanciaAlvo.getText());
            if (distanciaAlvo < 0) {
                JOptionPane.showMessageDialog(null, "Digite um valor positivo para Distância do Alvo.");
                return;
            }
            Lancamento l = new Lancamento(numeroLancamento,this.lancamento.getIdGrupo() , this.lancamento.getNomeGrupo(), this.lancamento.getNomeFoguete(), this.lancamento.getPesoFoguete(), altitudeMaxima, velocidadeMaxima, tempoPropulsao, picoAceleracao, aceleracaoMedia, tempoApogeuDescida, tempoEjecao, altitudeEjecao, taxaDescida, duracaoVoo, dataLancamento, distanciaAlvo, anguloLancamento, velocidadeVento);
            LancamentoDAO lancamentoDao = new LancamentoDAO();
            boolean sucess = lancamentoDao.alterarLancamento(l);
            
            if (sucess) {
               ((Node) (event.getSource())).getScene().getWindow().hide();
                if (this.grupo != null) {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/br/com/moosegroup/views/FormPesquisarLancamento.fxml"));
                    Pane root =  fxmlLoader.load();
                    FormPesquisarLancamentoController controller = fxmlLoader.<FormPesquisarLancamentoController>getController();
                    controller.initWithData(this.grupo);

                    Scene scene = new Scene(root);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.setTitle("Pesquisar Lançamentos");
                    stage.show();

                } else if(this.admin != null){
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/br/com/moosegroup/views/FormListarLancamento.fxml"));
                    Pane root =  fxmlLoader.load();
                    FormListarLancamentoController controller = fxmlLoader.<FormListarLancamentoController>getController();
                    controller.initWithData(this.admin);

                    Scene scene = new Scene(root);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.setTitle("Pesquisar Lançamentos");
                    stage.show();

                } else {
                    JOptionPane.showMessageDialog(null, "Não foi possível voltar para a Pesquisa de Lançamentos.");
                }
            }            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Algum valor numérico foi passado de forma errada, verifique os campos númericos e utilize ponto ao invés de virgula.");
        }
    }

    @FXML
    private void btnCancelarAction(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        if (this.grupo != null) {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/br/com/moosegroup/views/FormPesquisarLancamento.fxml"));
            Pane root =  fxmlLoader.load();
            FormPesquisarLancamentoController controller = fxmlLoader.<FormPesquisarLancamentoController>getController();
            controller.initWithData(this.grupo);

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Pesquisar Lançamentos");
            stage.show();

        } else if(this.admin != null) {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/br/com/moosegroup/views/FormListarLancamento.fxml"));
            Pane root =  fxmlLoader.load();
            FormListarLancamentoController controller = fxmlLoader.<FormListarLancamentoController>getController();
            controller.initWithData(this.admin);

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Pesquisar Lançamentos");
            stage.show();

        } else {
            JOptionPane.showMessageDialog(null, "Não foi possível voltar para a Pesquisa de Lançamentos.");
        }
    }

    void initWithData(Grupo grupo, Lancamento lancamento) {
        this.grupo = grupo;
        this.lancamento = lancamento;
        txtNumeroLancamento.setText(String.valueOf(this.lancamento.getId()));
        txtNomeGrupo.setText(this.lancamento.getNomeGrupo());
        txtNomeFoguete.setText(this.lancamento.getNomeFoguete());
        txtPesoFoguete.setText(String.valueOf(this.lancamento.getPesoFoguete()));
        dtpDataLancamento.setValue(this.lancamento.getDataLancamento().toLocalDate());
        txtAnguloLancamento.setText(String.valueOf(this.lancamento.getAnguloLancamento()));
        txtVelocidadeVento.setText(String.valueOf(this.lancamento.getVelocidadeVento()));
        txtAnguloLancamento.setText(String.valueOf(this.lancamento.getAnguloLancamento()));
        txtAltitudeMaxima.setText(String.valueOf(this.lancamento.getAltitudeMaxima()));
        txtTempoPropulsao.setText(String.valueOf(this.lancamento.getTempoPropulsao()));
        txtPicoAceleracao.setText(String.valueOf(this.lancamento.getPicoAceleracao()));
        txtTempEjecao.setText(String.valueOf(this.lancamento.getTempoEjecao()));
        txtTaxaDescida.setText(String.valueOf(this.lancamento.getTaxaDescida()));
        txtVelocidadeMaxima.setText(String.valueOf(this.lancamento.getVelocidadeMaxima()));
        txtAceleracaoMedia.setText(String.valueOf(this.lancamento.getAceleracaoMedia()));
        txtAltitudeEjecao.setText(String.valueOf(this.lancamento.getAltitudeEjecao()));
        txtDuracaoVoo.setText(String.valueOf(this.lancamento.getDuracaoVoo()));
        txtDistanciaAlvo.setText(String.valueOf(this.lancamento.getDistanciaAlvo()));
        txtTempoApogeuDescida.setText(String.valueOf(this.lancamento.getTempoApogeuDescida()));
    }

    void initWithData(Admin admin, Lancamento lancamento){
        this.admin = admin;
        this.lancamento = lancamento;
        txtNumeroLancamento.setText(String.valueOf(this.lancamento.getId()));
        txtNomeGrupo.setText(this.lancamento.getNomeGrupo());
        txtNomeFoguete.setText(this.lancamento.getNomeFoguete());
        txtPesoFoguete.setText(String.valueOf(this.lancamento.getPesoFoguete()));
        dtpDataLancamento.setValue(this.lancamento.getDataLancamento().toLocalDate());
        txtAnguloLancamento.setText(String.valueOf(this.lancamento.getAnguloLancamento()));
        txtVelocidadeVento.setText(String.valueOf(this.lancamento.getVelocidadeVento()));
        txtAnguloLancamento.setText(String.valueOf(this.lancamento.getAnguloLancamento()));
        txtAltitudeMaxima.setText(String.valueOf(this.lancamento.getAltitudeMaxima()));
        txtTempoPropulsao.setText(String.valueOf(this.lancamento.getTempoPropulsao()));
        txtPicoAceleracao.setText(String.valueOf(this.lancamento.getPicoAceleracao()));
        txtTempEjecao.setText(String.valueOf(this.lancamento.getTempoEjecao()));
        txtTaxaDescida.setText(String.valueOf(this.lancamento.getTaxaDescida()));
        txtVelocidadeMaxima.setText(String.valueOf(this.lancamento.getVelocidadeMaxima()));
        txtAceleracaoMedia.setText(String.valueOf(this.lancamento.getAceleracaoMedia()));
        txtAltitudeEjecao.setText(String.valueOf(this.lancamento.getAltitudeEjecao()));
        txtDuracaoVoo.setText(String.valueOf(this.lancamento.getDuracaoVoo()));
        txtDistanciaAlvo.setText(String.valueOf(this.lancamento.getDistanciaAlvo()));
        txtTempoApogeuDescida.setText(String.valueOf(this.lancamento.getTempoApogeuDescida()));
    }

}
