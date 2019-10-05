package br.com.moosegroup.controllers;

import br.com.moosegroup.dao.GrupoDAO;
import br.com.moosegroup.dao.IntegranteDAO;
import br.com.moosegroup.models.Admin;
import br.com.moosegroup.models.Grupo;
import br.com.moosegroup.models.Integrante;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class FormAlterarIntegranteController implements Initializable {   
    @FXML
    private JFXTextField txtRm;

    @FXML
    private JFXComboBox cbbGrupo;
    @FXML
    private JFXButton btnAlterar;

    @FXML
    private JFXButton btnCancelar;

    @FXML
    private JFXTextField txtNome; 
    
    private Integrante integrante;
    private Grupo grupo;
    private Admin admin;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<String> listaGrupo = null;

        IntegranteDAO dao = new IntegranteDAO();
        listaGrupo = dao.getGrupos();

        for (int i = 0; i < listaGrupo.size(); i++) {
            cbbGrupo.getItems().addAll(listaGrupo.get(i));
        }
    }    
    
    public void initWithData(Integrante integrante, Grupo grupo) {
        this.integrante = integrante;
        this.grupo = grupo;
        txtNome.setText(this.integrante.getNomeCompleto());
        txtRm.setText(this.integrante.getRm());
        cbbGrupo.setValue(this.integrante.getGrupo());
        cbbGrupo.setDisable(true);
    }
    
    public void initWithData(Integrante integrante, Admin admin) {
        this.integrante = integrante;
        this.admin = admin;
        txtNome.setText(this.integrante.getNomeCompleto());
        txtRm.setText(this.integrante.getRm());
        cbbGrupo.setValue(this.integrante.getGrupo());
        cbbGrupo.setDisable(false);
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
    private void btnAlterarAction(ActionEvent event)throws Exception {
        String nome = txtNome.getText();
        String rm = txtRm.getText();
        
        if (rm.length() > 6) {
            JOptionPane.showMessageDialog(null, "Insira um rm com 6 digitos");
            return;
        }
        
        IntegranteDAO integranteDAO = new IntegranteDAO();
        Integrante integrante = new Integrante(this.integrante.getId_integrante(), nome, rm, this.integrante.getId_grupo(), this.integrante.getGrupo());
        integranteDAO.alterarIntegrante(integrante);
        
        
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
