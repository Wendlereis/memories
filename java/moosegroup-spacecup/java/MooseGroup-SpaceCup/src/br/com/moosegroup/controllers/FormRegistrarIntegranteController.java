package br.com.moosegroup.controllers;

import com.jfoenix.controls.JFXButton;
import br.com.moosegroup.dao.IntegranteDAO;
import br.com.moosegroup.models.Grupo;
import br.com.moosegroup.models.Integrante;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class FormRegistrarIntegranteController implements Initializable {
    // INTERFACE VARIABLE
    @FXML
    private JFXButton btnCancelar;
    @FXML
    private JFXButton btnRegistrar;
    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtRm;
    
    // CLASS VARIABLES
    private Grupo grupo;
    
    // INIT CONTROLLER METHODS
    @Override
    public void initialize(URL url, ResourceBundle rb) {}
    
    public void initWithData(Grupo grupo) {
        this.grupo = grupo;
    }
    
    @FXML
    private void btnCancelarAction(ActionEvent event) throws Exception {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/br/com/moosegroup/views/FormMenu.fxml"));
        Pane root =  fxmlLoader.load();
        FormMenuController controller = fxmlLoader.<FormMenuController>getController();
        controller.initWithData(this.grupo);

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Menu Grupo");
        stage.show();
    }
    
    @FXML
    private void btnRegistrarAction(ActionEvent event) throws Exception {
        String nome = txtNome.getText();
        String rm = txtRm.getText();
        
        if (rm.length() > 6) {
            JOptionPane.showMessageDialog(null, "Insira um rm com 6 digitos");
            return;
        }
        
        IntegranteDAO integranteDAO = new IntegranteDAO();
        
        int id = integranteDAO.getIdIntegrante();
        Integrante integrante = new Integrante(id, nome, rm, this.grupo.getIdGrupo(), this.grupo.getNome());
        
        boolean success = integranteDAO.registrarIntegrante(integrante);
        
        if (success) {
            JOptionPane.showMessageDialog(null, "Registrado com sucesso.");
            txtNome.setText("");
            txtRm.setText("");
        }
    }
}
