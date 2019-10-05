package br.com.moosegroup.controllers;

import br.com.moosegroup.models.Admin;
import br.com.moosegroup.models.Grupo;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class FormMenuAdminController implements Initializable {
    //INTERFACE VARIABLES
    @FXML
    private JFXButton btnRegistrarGrupos;
    @FXML
    private Label lblRegistrarGrupos;
    @FXML
    private JFXButton btnConsultarGrupos;
    @FXML
    private Label lblConsultarGrupos;
    @FXML
    private JFXButton btnConsultarIntegrantes;
    @FXML
    private Label lblConsultarIntegrantes;
    @FXML
    private JFXButton btnListarLancamentos;
    @FXML
    private Label lblListarLancamentos;
    @FXML
    private Label lblTeste;

    //CLASS VARIABLES
    private Admin admin;

    //INIT CONTROLLER METHODS
    @Override
    public void initialize(URL url, ResourceBundle rb) {}

    public void initWithData(Admin admin) {
        this.admin = admin;
    }

    @FXML
    private void btnGruposAction(ActionEvent event){
        SequentialTransition FadeIn = FadeInGrupos();

        if (btnRegistrarGrupos.isVisible() == false && lblRegistrarGrupos.isVisible() == false &&
            btnConsultarGrupos.isVisible() == false && lblConsultarGrupos.isVisible() == false) {

            if (btnConsultarIntegrantes.isVisible() == true && lblConsultarIntegrantes.isVisible() == true ||
                btnListarLancamentos.isVisible() == true && lblListarLancamentos.isVisible() == true) {

                btnConsultarIntegrantes.setVisible(false);
                lblConsultarIntegrantes.setVisible(false);

                btnListarLancamentos.setVisible(false);
                lblListarLancamentos.setVisible(false);
            }

            btnRegistrarGrupos.setVisible(true);
            lblRegistrarGrupos.setVisible(true);

            btnConsultarGrupos.setVisible(true);
            lblConsultarGrupos.setVisible(true);

            FadeIn.play();
        }
        else {
            btnRegistrarGrupos.setVisible(false);
            lblRegistrarGrupos.setVisible(false);

            btnConsultarGrupos.setVisible(false);
            lblConsultarGrupos.setVisible(false);
        }

    }

    @FXML
    private void btnIntegrantesAction(ActionEvent event) {
        SequentialTransition FadeIn = FadeInIntegrantes();

        if (btnConsultarIntegrantes.isVisible() == false && lblConsultarIntegrantes.isVisible() == false) {

            if (btnRegistrarGrupos.isVisible() == true && lblRegistrarGrupos.isVisible() == true &&
                btnConsultarGrupos.isVisible() == true && lblConsultarGrupos.isVisible() == true ||
                btnListarLancamentos.isVisible() == true && lblListarLancamentos.isVisible() == true) {

                btnRegistrarGrupos.setVisible(false);
                lblRegistrarGrupos.setVisible(false);

                btnConsultarGrupos.setVisible(false);
                lblConsultarGrupos.setVisible(false);

                btnListarLancamentos.setVisible(false);
                lblListarLancamentos.setVisible(false);
            }

            btnConsultarIntegrantes.setVisible(true);
            lblConsultarIntegrantes.setVisible(true);

            FadeIn.play();
        }
        else {
            btnConsultarIntegrantes.setVisible(false);
            lblConsultarIntegrantes.setVisible(false);
        }
    }

    @FXML
    private void btnLancamentosAction(ActionEvent event) {
        SequentialTransition FadeIn = FadeInLancamentos();

        if (btnListarLancamentos.isVisible() == false && lblListarLancamentos.isVisible() == false) {

            if (btnRegistrarGrupos.isVisible() == true && lblRegistrarGrupos.isVisible() == true &&
                btnConsultarGrupos.isVisible() == true && lblConsultarGrupos.isVisible() == true ||
                btnConsultarIntegrantes.isVisible() == true && lblConsultarIntegrantes.isVisible() == true) {

                btnRegistrarGrupos.setVisible(false);
                lblRegistrarGrupos.setVisible(false);

                btnConsultarGrupos.setVisible(false);
                lblConsultarGrupos.setVisible(false);

                btnConsultarIntegrantes.setVisible(false);
            lblConsultarIntegrantes.setVisible(false);
            }

            btnListarLancamentos.setVisible(true);
            lblListarLancamentos.setVisible(true);

            FadeIn.play();
        }
        else {
            btnListarLancamentos.setVisible(false);
            lblListarLancamentos.setVisible(false);
        }
    }

    @FXML
    private void pnMiddlePaneOnMouseClicked(){
        if (btnRegistrarGrupos.isVisible() == true && lblRegistrarGrupos.isVisible() == true &&
            btnConsultarGrupos.isVisible() == true && lblConsultarGrupos.isVisible() == true) {

            btnRegistrarGrupos.setVisible(false);
            lblRegistrarGrupos.setVisible(false);

            btnConsultarGrupos.setVisible(false);
            lblConsultarGrupos.setVisible(false);
        }

        if (btnConsultarIntegrantes.isVisible() == true && lblConsultarIntegrantes.isVisible() == true) {

            btnConsultarIntegrantes.setVisible(false);
            lblConsultarIntegrantes.setVisible(false);
        }

        if (btnListarLancamentos.isVisible() == true && lblListarLancamentos.isVisible() == true) {

            btnListarLancamentos.setVisible(false);
            lblListarLancamentos.setVisible(false);
        }
    }

    //Navegacao Proximas Telas
    @FXML
    private void btnRegistrarGruposAction(ActionEvent event) throws IOException{
        ((Node) (event.getSource())).getScene().getWindow().hide();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/br/com/moosegroup/views/FormCadastroGrupo.fxml"));
        Pane root =  fxmlLoader.load();
        FormCadastroGrupoController controller = fxmlLoader.<FormCadastroGrupoController>getController();
        controller.initWithData(admin);

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Cadastrar Grupo");
        stage.show();
    }

    @FXML
    private void btnConsultarGruposAction(ActionEvent event) throws IOException{
        ((Node) (event.getSource())).getScene().getWindow().hide();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/br/com/moosegroup/views/FormPesquisarGrupo.fxml"));
        Pane root =  fxmlLoader.load();
        FormPesquisarGrupoController controller = fxmlLoader.<FormPesquisarGrupoController>getController();
        controller.initWithData(admin);

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Consultar de Grupos");
        stage.show();
    }

    @FXML
    private void btnConsultarIntegrantesAction(ActionEvent event) throws IOException{
        ((Node) (event.getSource())).getScene().getWindow().hide();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/br/com/moosegroup/views/FormListaIntegrante.fxml"));
        Pane root =  fxmlLoader.load();
        FormListaIntegranteController controller = fxmlLoader.<FormListaIntegranteController>getController();
        controller.initWithData(admin);

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Consulta de Integrantes");
        stage.show();
    }

    @FXML
    private void btnListarLancamentosAction(ActionEvent event) throws IOException{
                ((Node) (event.getSource())).getScene().getWindow().hide();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/br/com/moosegroup/views/FormListarLancamento.fxml"));
                Pane root =  fxmlLoader.load();
                FormListarLancamentoController controller = fxmlLoader.<FormListarLancamentoController>getController();
                controller.initWithData(admin);

                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Consulta de Lancamentos");
                stage.show();
    }

    @FXML
    private void btnSairAction(ActionEvent event) throws IOException{
       ((Node) (event.getSource())).getScene().getWindow().hide();

        Parent parent =  FXMLLoader.load(getClass().getResource("/br/com/moosegroup/views/FormLogin.fxml"));

        Stage stage = new Stage();
        Scene scene = new Scene(parent);

        stage.setScene(scene);
        stage.setTitle("Listar Lancamentos");
        stage.show();
    }

    //Metodos configuração efeito FadeIn
    private SequentialTransition FadeInGrupos(){
        FadeTransition ftBtnRegistrarGrupos =
            new FadeTransition(Duration.millis(600), btnRegistrarGrupos);
        ftBtnRegistrarGrupos.setFromValue(0.0f);
        ftBtnRegistrarGrupos.setToValue(1.0f);
        ftBtnRegistrarGrupos.setCycleCount(1);

        FadeTransition ftLblRegistrarGrupos =
            new FadeTransition(Duration.millis(300), lblRegistrarGrupos);
        ftLblRegistrarGrupos.setFromValue(0.0f);
        ftLblRegistrarGrupos.setToValue(0.8f);
        ftLblRegistrarGrupos.setCycleCount(1);

        FadeTransition ftBtnConsultarGrupos =
            new FadeTransition(Duration.millis(600), btnConsultarGrupos);
        ftBtnConsultarGrupos.setFromValue(0.0f);
        ftBtnConsultarGrupos.setToValue(1.0f);
        ftBtnConsultarGrupos.setCycleCount(1);

        FadeTransition ftLblConsultarGrupos =
            new FadeTransition(Duration.millis(300), lblConsultarGrupos);
        ftLblConsultarGrupos.setFromValue(0.0f);
        ftLblConsultarGrupos.setToValue(0.8f);
        ftLblConsultarGrupos.setCycleCount(1);

        SequentialTransition sequentialTransition = new SequentialTransition();
        sequentialTransition.getChildren().addAll(ftBtnRegistrarGrupos, ftLblRegistrarGrupos,
                ftBtnConsultarGrupos, ftLblConsultarGrupos);
        sequentialTransition.setCycleCount(1);
        sequentialTransition.setAutoReverse(true);

        return sequentialTransition;
    }

    private SequentialTransition FadeInIntegrantes(){
        FadeTransition ftBtnConsultarIntegrantes =
            new FadeTransition(Duration.millis(600), btnConsultarIntegrantes);
        ftBtnConsultarIntegrantes.setFromValue(0.0f);
        ftBtnConsultarIntegrantes.setToValue(1.0f);
        ftBtnConsultarIntegrantes.setCycleCount(1);

        FadeTransition ftLblConsultarIntegrantes =
            new FadeTransition(Duration.millis(300), lblConsultarIntegrantes);
        ftLblConsultarIntegrantes.setFromValue(0.0f);
        ftLblConsultarIntegrantes.setToValue(0.8f);
        ftLblConsultarIntegrantes.setCycleCount(1);

        SequentialTransition sequentialTransition = new SequentialTransition();
        sequentialTransition.getChildren().addAll(ftBtnConsultarIntegrantes, ftLblConsultarIntegrantes);
        sequentialTransition.setCycleCount(1);
        sequentialTransition.setAutoReverse(true);

        return sequentialTransition;
    }

    private SequentialTransition FadeInLancamentos(){
       FadeTransition ftBtnListarLancamentos =
            new FadeTransition(Duration.millis(600), btnListarLancamentos);
        ftBtnListarLancamentos.setFromValue(0.0f);
        ftBtnListarLancamentos.setToValue(1.0f);
        ftBtnListarLancamentos.setCycleCount(1);

        FadeTransition ftLblListarLancamentos =
            new FadeTransition(Duration.millis(300), lblListarLancamentos);
        ftLblListarLancamentos.setFromValue(0.0f);
        ftLblListarLancamentos.setToValue(0.8f);
        ftLblListarLancamentos.setCycleCount(1);

        SequentialTransition sequentialTransition = new SequentialTransition();
        sequentialTransition.getChildren().addAll(ftBtnListarLancamentos, ftLblListarLancamentos);
        sequentialTransition.setCycleCount(1);
        sequentialTransition.setAutoReverse(true);

        return sequentialTransition;
    }
}
