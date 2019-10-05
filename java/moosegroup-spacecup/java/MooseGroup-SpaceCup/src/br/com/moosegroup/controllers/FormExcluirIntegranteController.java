package br.com.moosegroup.controllers;

import br.com.moosegroup.dao.IntegranteDAO;
import br.com.moosegroup.models.Admin;
import br.com.moosegroup.models.Grupo;
import br.com.moosegroup.models.Integrante;
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

public class FormExcluirIntegranteController implements Initializable {

    @FXML
    private Label lblRm;

    @FXML
    private Label lblGrupo;

    @FXML
    private JFXButton btnCancelar;

    @FXML
    private JFXButton btnExcluir;

    @FXML
    private Label lblNome;

    private Integrante integrante;
    private Admin admin;
    private Grupo grupo;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void initWithData(Integrante integrante, Grupo grupo) {
        this.integrante = integrante;
        this.grupo = grupo;
        lblNome.setText(this.integrante.getNomeCompleto());
        lblRm.setText(this.integrante.getRm());
        lblGrupo.setText(this.integrante.getGrupo());
    }

    public void initWithData(Integrante integrante, Admin admin) {
        this.integrante = integrante;
        this.admin = admin;
        lblNome.setText(this.integrante.getNomeCompleto());
        lblRm.setText(this.integrante.getRm());
        lblGrupo.setText(this.integrante.getGrupo());
    }

    @FXML
    private void btnCancelarAction(ActionEvent event) throws Exception {
        ((Node) (event.getSource())).getScene().getWindow().hide();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/br/com/moosegroup/views/FormListaIntegrante.fxml"));
        Pane root =  fxmlLoader.load();
        FormListaIntegranteController controller = fxmlLoader.<FormListaIntegranteController>getController();
        if (this.grupo != null) {
            controller.initWithData(this.grupo);
        } else {
            controller.initWithData(this.admin);
        }

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Consulta de Integrantes");
        stage.show();
    }

    @FXML
    void btnExcluirAction(ActionEvent event) throws Exception {
        int id = integrante.getId_integrante();
        IntegranteDAO integranteDAO = new IntegranteDAO();
        integranteDAO.excluirIntegrante(id);

        ((Node) (event.getSource())).getScene().getWindow().hide();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/br/com/moosegroup/views/FormListaIntegrante.fxml"));
        Pane root =  fxmlLoader.load();
        FormListaIntegranteController controller = fxmlLoader.<FormListaIntegranteController>getController();
        if (this.grupo != null) {
            controller.initWithData(this.grupo);
        } else {
            controller.initWithData(this.admin);
        }

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Consulta de Integrantes");
        stage.show();
    }
}
