package br.com.moosegroup.controllers;

import br.com.moosegroup.dao.GrupoDAO;
import br.com.moosegroup.models.Admin;
import br.com.moosegroup.models.Grupo;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class FormExcluirGrupoController implements Initializable {
    
    @FXML
    private AnchorPane apnTela;

    @FXML
    private Label lblFoguete;

    @FXML
    private JFXButton btnCancelar;

    @FXML
    private JFXButton btnExcluir;

    @FXML
    private Label lblTurma;

    @FXML
    private Label lblNome;
    
    private Grupo grupo;
    private Admin admin;

    @FXML
    void btnExcluirAction(ActionEvent event) throws IOException {
        try {
            GrupoDAO grupoDao = new GrupoDAO();
            boolean returnlancamento = grupoDao.excluirLancamentosGrupo(grupo);
            boolean returnGrupo = grupoDao.excluirGrupo(grupo);
            boolean returnfoguete = grupoDao.excluirFoguete(grupo);            
            boolean returnintegrante = grupoDao.excluirIntegrantesGrupo(grupo);
            
            if (returnlancamento == true && returnGrupo == true && returnfoguete == true && returnintegrante == true)
                JOptionPane.showMessageDialog(null, "Grupo Excluido!");
            else
                JOptionPane.showMessageDialog(null, "Falha ao Excluir Grupo:/");
            
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
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " +e);
        }
    }

    @FXML
    void btnCancelarAction(ActionEvent event) throws IOException {
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void initWithData(Grupo grupo, Admin admin) {
        this.grupo = grupo;
        this.admin = admin;
        lblNome.setText(grupo.getNome());
        lblTurma.setText(grupo.getTurma());
        lblFoguete.setText(grupo.getFoguete());
    }    
}
