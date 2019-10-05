package br.com.moosegroup.controllers;

import br.com.moosegroup.dao.LancamentoDAO;
import br.com.moosegroup.models.Admin;
import br.com.moosegroup.models.Grupo;
import br.com.moosegroup.models.Lancamento;
import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class FormExcluirLancamentoController implements Initializable {

    @FXML
    private Label lblFoguete;

    @FXML
    private Label lblnumeroLancamento;

    @FXML
    private Label lblGrupo;

    @FXML
    private JFXButton btnCancelar;

    @FXML
    private JFXButton btnExcluir;

    @FXML
    private Label lblData;

    private Lancamento lancamento;
    private Grupo grupo;
    private Admin admin;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    void btnExcluirAction(ActionEvent event) throws Exception {
        int id = lancamento.getId();
        LancamentoDAO lancamentoDAO = new LancamentoDAO();
        lancamentoDAO.excluirLancamento(id);

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

    @FXML
    void btnCancelarAction(ActionEvent event) throws Exception {
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

        lblnumeroLancamento.setText(String.valueOf(this.lancamento.getId()));
        lblGrupo.setText(this.grupo.getNome());
        lblFoguete.setText(this.grupo.getFoguete());
        lblData.setText(String.valueOf(this.lancamento.getDataLancamento()));
    }

    void initWithData(Admin admin, Lancamento lancamento){
        this.admin = admin;
        this.lancamento = lancamento;

        lblnumeroLancamento.setText(String.valueOf(this.lancamento.getId()));
        lblGrupo.setText(String.valueOf(this.lancamento.getIdGrupo()));
        // lblFoguete.setText(this.grupo.getFoguete());
        // lblData.setText(this.lancamento.getDataLancamento());
    }
}
