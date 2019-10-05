package br.com.moosegroup.controllers;

import br.com.moosegroup.dao.GrupoDAO;
import br.com.moosegroup.models.Admin;
import br.com.moosegroup.models.Grupo;
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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class FormPesquisarGrupoController implements Initializable {
    @FXML
    private TableView<Grupo> tblGrupos;

    @FXML
    private TableColumn<Grupo, String> colCodigo;

    @FXML
    private TableColumn<Grupo, String> colNomeGrupo;

    @FXML
    private TableColumn<Grupo, String> colCodFoguete;

    @FXML
    private TableColumn<Grupo, String> colFoguete;

    @FXML
    private TableColumn<Grupo, String> colPesoFoguete;

    @FXML
    private TableColumn<Grupo, String> colCodTurma;

    @FXML
    private TableColumn<Grupo, String> colTurma;

    @FXML
    private TableColumn<Grupo, String> colCodLogin;

    @FXML
    private TableColumn<Grupo, String> colLogin;

    @FXML
    private TableColumn<Grupo, String> colSenha;

    @FXML
    private JFXButton btnAlterar;

    @FXML
    private JFXButton btnCancelar;

    @FXML
    private JFXButton btnConsultar;

    @FXML
    private JFXButton btnExcluir;

    @FXML
    private JFXTextField txtPesquisar;

    private List<Grupo> listaGrupos = new ArrayList<>();
    private ObservableList<Grupo> observableListGrupos;
    private Admin admin;

    @FXML
    void btnCancelarAction(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/br/com/moosegroup/views/FormMenuAdmin.fxml"));
        Pane root =  fxmlLoader.load();
        FormMenuAdminController controller = fxmlLoader.<FormMenuAdminController>getController();
        controller.initWithData(admin);

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Menu");
        stage.show();
    }

    @FXML
    void btnConsultarAction(ActionEvent event) {
        String filtro = txtPesquisar.getText();

        GrupoDAO grupoDao = new GrupoDAO();
        listaGrupos = grupoDao.consultarGrupo(filtro);

        colCodigo.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNomeGrupo.setCellValueFactory(new PropertyValueFactory<>("nome"));

        colCodTurma.setCellValueFactory(new PropertyValueFactory<>("idTurma"));
        colTurma.setCellValueFactory(new PropertyValueFactory<>("turma"));

        colCodFoguete.setCellValueFactory(new PropertyValueFactory<>("idFoguete"));
        colFoguete.setCellValueFactory(new PropertyValueFactory<>("foguete"));
        colPesoFoguete.setCellValueFactory(new PropertyValueFactory<>("pesoFoguete"));

        colCodLogin.setCellValueFactory(new PropertyValueFactory<>("id"));
        colLogin.setCellValueFactory(new PropertyValueFactory<>("nomeAcesso"));
        colSenha.setCellValueFactory(new PropertyValueFactory<>("senha"));

        if (listaGrupos != null) {
            observableListGrupos = FXCollections.observableArrayList(listaGrupos);
            tblGrupos.setItems(observableListGrupos);
        }
        else {
            JOptionPane.showMessageDialog(null, "Grupo nao encontrado");
        }
    }

    @FXML
    void btnAlterarAction(ActionEvent event) throws IOException {
        Grupo grupo = tblGrupos.getSelectionModel().getSelectedItem();

        if (grupo == null) {
            JOptionPane.showMessageDialog(null, "Selecione um grupo para alterar.");
            return;
        }

        ((Node) (event.getSource())).getScene().getWindow().hide();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/br/com/moosegroup/views/FormAlterarGrupo.fxml"));
        Pane root = fxmlLoader.load();

        FormAlterarGrupoController formAlterarGrupoController = fxmlLoader.<FormAlterarGrupoController>getController();
        formAlterarGrupoController.initWithData(grupo, admin);

        Scene scene = new Scene(root);
 
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Alterar Grupo");
        stage.show();
    }

    @FXML
    void btnExcluirAction(ActionEvent event) throws IOException {
        Grupo grupo = tblGrupos.getSelectionModel().getSelectedItem();
        
        if (grupo == null) {
            JOptionPane.showMessageDialog(null, "Selecione um grupo para excluir.");
            return;
        }

        ((Node) (event.getSource())).getScene().getWindow().hide();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/br/com/moosegroup/views/FormExcluirGrupo.fxml"));
        Pane root =  fxmlLoader.load();

        FormExcluirGrupoController formExcluirGrupoController = fxmlLoader.<FormExcluirGrupoController>getController();
        formExcluirGrupoController.initWithData(grupo, admin);

        Scene scene = new Scene(root);

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Excluir Grupo");
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void initWithData(Admin admin) {
        this.admin = admin;
    }
}
