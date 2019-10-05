package br.com.moosegroup.controllers;

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

public class FormMenuController implements Initializable {
    //INTERFACE VARIABLES
    @FXML
    private JFXButton btnAdicionarIntegrantes;
    @FXML
    private Label lblAdicionarIntegrantes;
    @FXML
    private JFXButton btnConsultarIntegrantes;
    @FXML
    private Label lblConsultarIntegrantes;
    @FXML
    private JFXButton btnRegistrarLancamento;
    @FXML
    private Label lblRegistrarLancamento;
    @FXML
    private JFXButton btnConsultarLancamento;
    @FXML
    private Label lblConsultarLancamento;
    @FXML
    private JFXButton btnCancelar;
    @FXML
    private Label lblTitulo;
    
    //CLASS VARIABLES
    private Grupo grupo;
    
    //INIT CONTROLLER METHODS
    @Override
    public void initialize(URL url, ResourceBundle rb) {}
    
    public void initWithData(Grupo grupo) {
        this.grupo = grupo;
        lblTitulo.setText("Bem - vindo, "+ grupo.getNome());
    }
    
    @FXML
    private void btnIntegrantesAction(ActionEvent event){
        SequentialTransition fadeIn = FadeInIntegrantes(); //Carrega configuracao dos efeitos de FadeIn dos cntroles Integrantes
        
        if (btnAdicionarIntegrantes.isVisible() == false && lblAdicionarIntegrantes.isVisible() == false && 
            btnConsultarIntegrantes.isVisible() == false && lblConsultarIntegrantes.isVisible() == false) {
            
            if (btnRegistrarLancamento.isVisible() == true && lblRegistrarLancamento.isVisible() == true && 
                btnConsultarLancamento.isVisible() == true && lblConsultarLancamento.isVisible() == true) {
                
                btnRegistrarLancamento.setVisible(false);
                lblRegistrarLancamento.setVisible(false);

                btnConsultarLancamento.setVisible(false);
                lblConsultarLancamento.setVisible(false);
            }
            
            btnAdicionarIntegrantes.setVisible(true);
            lblAdicionarIntegrantes.setVisible(true);
            
            
            btnConsultarIntegrantes.setVisible(true);
            lblConsultarIntegrantes.setVisible(true);
            
            fadeIn.play(); //Ativa efeito FadeIn
            
        }
        else {           
            btnAdicionarIntegrantes.setVisible(false);
            lblAdicionarIntegrantes.setVisible(false);
            
            btnConsultarIntegrantes.setVisible(false);
            lblConsultarIntegrantes.setVisible(false);
        }      
    }
    
    @FXML
    private void btnLancamentosAction(ActionEvent event){
        SequentialTransition fadeIn = FadeInLancamentos(); //Carrega configuracao dos efeitos de FadeIn dos controles lancamentos
        
        if (btnRegistrarLancamento.isVisible() == false && lblRegistrarLancamento.isVisible() == false && 
            btnConsultarLancamento.isVisible() == false && lblConsultarLancamento.isVisible() == false) {
            
            if (btnAdicionarIntegrantes.isVisible() == true && lblAdicionarIntegrantes.isVisible() == true && 
                btnConsultarIntegrantes.isVisible() == true && lblConsultarIntegrantes.isVisible() == true) {
                
                btnAdicionarIntegrantes.setVisible(false);
                lblAdicionarIntegrantes.setVisible(false);


                btnConsultarIntegrantes.setVisible(false);
                lblConsultarIntegrantes.setVisible(false);                
            }
                        
            btnRegistrarLancamento.setVisible(true);
            lblRegistrarLancamento.setVisible(true);
            
            btnConsultarLancamento.setVisible(true);
            lblConsultarLancamento.setVisible(true);
            
            fadeIn.play(); //Ativa efetio FadeIn
        }
        else {
            btnRegistrarLancamento.setVisible(false);
            lblRegistrarLancamento.setVisible(false);
            
            btnConsultarLancamento.setVisible(false);
            lblConsultarLancamento.setVisible(false);
        }  
    }
    
    @FXML
    private void pnMiddlePaneOnMouseClicked() {
        if (btnAdicionarIntegrantes.isVisible() == true && lblAdicionarIntegrantes.isVisible() == true && 
            btnConsultarIntegrantes.isVisible() == true && lblConsultarIntegrantes.isVisible() == true) {
                        
            btnAdicionarIntegrantes.setVisible(false);
            lblAdicionarIntegrantes.setVisible(false);
            
            
            btnConsultarIntegrantes.setVisible(false);
            lblConsultarIntegrantes.setVisible(false);
        }
        
        if (btnRegistrarLancamento.isVisible() == true && lblRegistrarLancamento.isVisible() == true && 
            btnConsultarLancamento.isVisible() == true && lblConsultarLancamento.isVisible() == true) {
            
            btnRegistrarLancamento.setVisible(false);
            lblRegistrarLancamento.setVisible(false);
            
            btnConsultarLancamento.setVisible(false);
            lblConsultarLancamento.setVisible(false);
        }
    }
    
    //Metodos navegação proximas telas
    @FXML
    private void btnAdicionarIntegrantesAction(ActionEvent event) throws IOException{
        ((Node) (event.getSource())).getScene().getWindow().hide();
        
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/br/com/moosegroup/views/FormRegistrarIntegrante.fxml"));
        Pane root =  fxmlLoader.load();
        FormRegistrarIntegranteController controller = fxmlLoader.<FormRegistrarIntegranteController>getController();
        controller.initWithData(grupo);

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Cadastrar Integrantes");
        stage.show();
    }
    
    @FXML
    private void btnConsultarIntegrantesAction(ActionEvent event) throws IOException{
        ((Node) (event.getSource())).getScene().getWindow().hide();
        
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/br/com/moosegroup/views/FormListaIntegrante.fxml"));
        Pane root =  fxmlLoader.load();
        FormListaIntegranteController controller = fxmlLoader.<FormListaIntegranteController>getController();
        controller.initWithData(grupo);

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Consulta de Integrantes");
        stage.show();
    }
    
    @FXML
    private void btnRegistrarLancamentoAction(ActionEvent event) throws IOException{
        ((Node) (event.getSource())).getScene().getWindow().hide();
        
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/br/com/moosegroup/views/FormRegistrarLancamento.fxml"));
        Pane root =  fxmlLoader.load();
        FormRegistrarLancamentoController controller = fxmlLoader.<FormRegistrarLancamentoController>getController();
        controller.initWithData(grupo);

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Cadastrar Lançamentos");
        stage.show();
    }
    
    @FXML
    private void btnConsultarLancamentoAction(ActionEvent event) throws IOException{
        ((Node) (event.getSource())).getScene().getWindow().hide();
        
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/br/com/moosegroup/views/FormPesquisarLancamento.fxml"));
        Pane root =  fxmlLoader.load();
        FormPesquisarLancamentoController controller = fxmlLoader.<FormPesquisarLancamentoController>getController();
        controller.initWithData(grupo);

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Consulta de Lançamentos");
        stage.show();
    }
    
    @FXML
    private void btnCancelarAction(ActionEvent event) throws IOException{
        ((Node) (event.getSource())).getScene().getWindow().hide();
        
        Parent parent =  FXMLLoader.load(getClass().getResource("/br/com/moosegroup/views/FormLogin.fxml"));

        Stage stage = new Stage();
        Scene scene = new Scene(parent);

        stage.setScene(scene);
        stage.setTitle("Login");
        stage.show();
    }
    
    //Metodo configuracao doss efeitos
    private SequentialTransition FadeInIntegrantes(){
        FadeTransition ftBtnAdicionarIntegrantes = 
            new FadeTransition(Duration.millis(600), btnAdicionarIntegrantes);
        ftBtnAdicionarIntegrantes.setFromValue(0.0f);
        ftBtnAdicionarIntegrantes.setToValue(1.0f);
        ftBtnAdicionarIntegrantes.setCycleCount(1);
        
        FadeTransition ftLblAdicionarIntegrantes = 
            new FadeTransition(Duration.millis(300), lblAdicionarIntegrantes);
        ftLblAdicionarIntegrantes.setFromValue(0.0f);
        ftLblAdicionarIntegrantes.setToValue(0.8f);
        ftLblAdicionarIntegrantes.setCycleCount(1);
        
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
        sequentialTransition.getChildren().addAll(ftBtnAdicionarIntegrantes, ftLblAdicionarIntegrantes,
                ftBtnConsultarIntegrantes, ftLblConsultarIntegrantes);
        sequentialTransition.setCycleCount(1);
        sequentialTransition.setAutoReverse(true);  
        
        return sequentialTransition;
    }
    
    private SequentialTransition FadeOutIntegrantes() {
        FadeTransition ftBtnAdicionarIntegrantes = 
            new FadeTransition(Duration.millis(800), btnAdicionarIntegrantes);
        ftBtnAdicionarIntegrantes.setFromValue(1.0f);
        ftBtnAdicionarIntegrantes.setToValue(0.0f);
        ftBtnAdicionarIntegrantes.setCycleCount(1);
        
        FadeTransition ftLblAdicionarIntegrantes = 
            new FadeTransition(Duration.millis(500), lblAdicionarIntegrantes);
        ftLblAdicionarIntegrantes.setFromValue(0.8f);
        ftLblAdicionarIntegrantes.setToValue(0.0f);
        ftLblAdicionarIntegrantes.setCycleCount(1);
        
        FadeTransition ftBtnConsultarIntegrantes = 
            new FadeTransition(Duration.millis(800), btnConsultarIntegrantes);
        ftBtnConsultarIntegrantes.setFromValue(1.0f);
        ftBtnConsultarIntegrantes.setToValue(0.0f);
        ftBtnConsultarIntegrantes.setCycleCount(1);
        
        FadeTransition ftLblConsultarIntegrantes = 
            new FadeTransition(Duration.millis(500), lblConsultarIntegrantes);
        ftLblConsultarIntegrantes.setFromValue(0.8f);
        ftLblConsultarIntegrantes.setToValue(0.0f);
        ftLblConsultarIntegrantes.setCycleCount(1);

        SequentialTransition sequentialTransition = new SequentialTransition();
        sequentialTransition.getChildren().addAll(ftLblConsultarIntegrantes, ftBtnConsultarIntegrantes, 
                ftLblAdicionarIntegrantes, ftBtnAdicionarIntegrantes);
        sequentialTransition.setCycleCount(1); 
        
        return sequentialTransition;
    }
    
    private SequentialTransition FadeInLancamentos(){
        FadeTransition ftBtnRegistrarLancamento = 
            new FadeTransition(Duration.millis(600), btnRegistrarLancamento);
        ftBtnRegistrarLancamento.setFromValue(0.0f);
        ftBtnRegistrarLancamento.setToValue(1.0f);
        ftBtnRegistrarLancamento.setCycleCount(1);
        
        FadeTransition ftLblRegistrarLancamento = 
            new FadeTransition(Duration.millis(300), lblRegistrarLancamento);
        ftLblRegistrarLancamento.setFromValue(0.0f);
        ftLblRegistrarLancamento.setToValue(0.8f);
        ftLblRegistrarLancamento.setCycleCount(1);
        
        FadeTransition ftBtnConsultarLancamento = 
            new FadeTransition(Duration.millis(600), btnConsultarLancamento);
        ftBtnConsultarLancamento.setFromValue(0.0f);
        ftBtnConsultarLancamento.setToValue(1.0f);
        ftBtnConsultarLancamento.setCycleCount(1);
        
        FadeTransition ftLblConsultarLancamento = 
            new FadeTransition(Duration.millis(300), lblConsultarLancamento);
        ftLblConsultarLancamento.setFromValue(0.0f);
        ftLblConsultarLancamento.setToValue(0.8f);
        ftLblConsultarLancamento.setCycleCount(1);

        SequentialTransition sequentialTransition = new SequentialTransition();
        sequentialTransition.getChildren().addAll(ftBtnRegistrarLancamento, ftLblRegistrarLancamento,
                ftBtnConsultarLancamento, ftLblConsultarLancamento);
        sequentialTransition.setCycleCount(1);
        sequentialTransition.setAutoReverse(true);  
        
        return sequentialTransition;
    }
}