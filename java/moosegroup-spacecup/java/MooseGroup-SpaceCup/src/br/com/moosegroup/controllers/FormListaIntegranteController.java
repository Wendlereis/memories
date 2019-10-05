package br.com.moosegroup.controllers;

import br.com.moosegroup.dao.IntegranteDAO;
import br.com.moosegroup.models.Admin;
import br.com.moosegroup.models.Grupo;
import br.com.moosegroup.models.Integrante;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class FormListaIntegranteController implements Initializable {
    //INTERFACE VARIABLES
    @FXML
    private TableView<Integrante> tblIntegrante;
    @FXML
    private TableColumn<Integrante, String> colIdIntegrante;
    @FXML
    private TableColumn<Integrante, String> colNomeIntegrante;
    @FXML
    private TableColumn<Integrante, String> colRm;
    @FXML
    private TableColumn<Integrante, String> colIdGrupo;
    @FXML
    private TableColumn<Integrante, String> colGrupo;
    @FXML
    private JFXTextField txtPesquisa;
    @FXML
    private JFXButton btnAlterar;
    @FXML
    private JFXButton btnCancelar;
    @FXML
    private JFXButton btnConsultar;
    @FXML
    private JFXButton btnExcluir;

    // CLASS VARIABLES
    private Grupo grupo;
    private Admin admin;

    private List<Integrante> list;
    private ObservableList<Integrante> observableListGrupos;

    // INIT CONTROLLER METHODS
    @Override
    public void initialize(URL url, ResourceBundle rb) {}

    public void initWithData(Grupo grupo) {
        this.grupo = grupo;
    }
    public void initWithData(Admin admin) {
        this.admin = admin;
    }

    @FXML
    void btnConsultarAction(ActionEvent event) {
        String search = txtPesquisa.getText();

        IntegranteDAO integranteDAO = new IntegranteDAO();
        list = new ArrayList<>();
        list = integranteDAO.listarIntegrante(search, this.grupo);

        colIdIntegrante.setCellValueFactory(new PropertyValueFactory<>("id_integrante"));
        colNomeIntegrante.setCellValueFactory(new PropertyValueFactory<>("nomeCompleto"));
        colRm.setCellValueFactory(new PropertyValueFactory<>("rm"));            
        colIdGrupo.setCellValueFactory(new PropertyValueFactory<>("id_grupo"));
        colGrupo.setCellValueFactory(new PropertyValueFactory<>("grupo")); 

        if (!list.isEmpty()) {
            observableListGrupos = FXCollections.observableArrayList(list);
            tblIntegrante.setItems(observableListGrupos);
        }
        else {
            JOptionPane.showMessageDialog(null, "Não foi encontrado nenhum integrante.");
        }
    }

    @FXML
    void btnAlterarAction(ActionEvent event) throws IOException {
        Integrante selectedIntegrante = tblIntegrante.getSelectionModel().getSelectedItem();
        if (selectedIntegrante == null) {
            JOptionPane.showMessageDialog(null, "Selecione um integrante para alterar.");
            return;
        }
        ((Node) (event.getSource())).getScene().getWindow().hide();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/br/com/moosegroup/views/FormAlterarIntegrante.fxml"));
        Pane root =  fxmlLoader.load();
        FormAlterarIntegranteController controller = fxmlLoader.<FormAlterarIntegranteController>getController();

        if (grupo != null) {
            controller.initWithData(selectedIntegrante, grupo);
        } else {
            controller.initWithData(selectedIntegrante, admin);
        }

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Alterar Integrante");
        stage.show();
    }

    @FXML
    void btnExcluirAction(ActionEvent event) throws IOException {
        Integrante selectedIntegrante = tblIntegrante.getSelectionModel().getSelectedItem();
        if (selectedIntegrante == null) {
            JOptionPane.showMessageDialog(null, "Selecione um integrante para excluir.");
            return;
        }
        ((Node) (event.getSource())).getScene().getWindow().hide();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/br/com/moosegroup/views/FormExcluirIntegrante.fxml"));
        Pane root =  fxmlLoader.load();
        FormExcluirIntegranteController controller = fxmlLoader.<FormExcluirIntegranteController>getController();

        if (grupo != null) {
            controller.initWithData(selectedIntegrante, grupo);
        } else {
            controller.initWithData(selectedIntegrante, admin);
        }

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Excluir integrante");
        stage.show();
    }

    @FXML
    void btnCancelarAction(ActionEvent event) throws IOException {
        if (this.grupo != null) {
            ((Node) (event.getSource())).getScene().getWindow().hide();

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/br/com/moosegroup/views/FormMenu.fxml"));
            Pane root =  fxmlLoader.load();
            FormMenuController controller = fxmlLoader.<FormMenuController>getController();
            controller.initWithData(this.grupo);

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Menu");
            stage.show();

        } else if(this.admin != null){
            ((Node) (event.getSource())).getScene().getWindow().hide();

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/br/com/moosegroup/views/FormMenuAdmin.fxml"));
            Pane root =  fxmlLoader.load();
            FormMenuAdminController controller = fxmlLoader.<FormMenuAdminController>getController();
            controller.initWithData(this.admin);

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Menu");
            stage.show();

        } else {
            JOptionPane.showMessageDialog(null, "Não foi possível voltar para o Menu.");
            return;
        }
    }
}
