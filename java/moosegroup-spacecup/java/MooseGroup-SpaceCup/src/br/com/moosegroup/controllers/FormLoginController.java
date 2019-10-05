package br.com.moosegroup.controllers;

import br.com.moosegroup.dao.UsuarioDAO;
import br.com.moosegroup.models.Admin;
import br.com.moosegroup.models.Grupo;
import br.com.moosegroup.models.Usuario;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class FormLoginController implements Initializable {
    //INTERFACE VARIABLES
    @FXML
    private AnchorPane apnTela;
    @FXML
    private JFXTextField txtUsuario;
    @FXML
    private JFXPasswordField txtSenha;

    //INIT CONTROLLER METHODS
    @Override
    public void initialize(URL url, ResourceBundle rb) {}

    @FXML
    private void btnEntrarAction(ActionEvent event) throws Exception {
        String user = txtUsuario.getText().trim();
        String password = txtSenha.getText().trim();
        if (user == null || user.length() == 0 || password == null || password.length() == 0) {
            JOptionPane.showMessageDialog(null, "Campo de login ou de senha vazia. Digite corretamente e tente de novo.");
            return;
        }
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = usuarioDAO.logarSistema(user, password);
        if (usuario == null) {
            JOptionPane.showMessageDialog(null, "Login / Senha inválido.");
        } else {
            if (usuario instanceof Admin) {
                ((Node) (event.getSource())).getScene().getWindow().hide();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/br/com/moosegroup/views/FormMenuAdmin.fxml"));
                Pane root =  fxmlLoader.load();
                FormMenuAdminController controller = fxmlLoader.<FormMenuAdminController>getController();
                controller.initWithData((Admin)usuario);

                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Menu Administrador");
                stage.show();
            } else {
                ((Node) (event.getSource())).getScene().getWindow().hide();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/br/com/moosegroup/views/FormMenu.fxml"));
                Pane root =  fxmlLoader.load();
                FormMenuController controller = fxmlLoader.<FormMenuController>getController();
                controller.initWithData((Grupo) usuario);

                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Menu Grupo");
                stage.show();
            }
        }
    }

    @FXML
    private void btnCancelarAction(ActionEvent event) throws Exception {
        System.exit(0);
    }
}
