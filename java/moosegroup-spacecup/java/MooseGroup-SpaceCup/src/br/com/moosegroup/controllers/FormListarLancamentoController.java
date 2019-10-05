package br.com.moosegroup.controllers;

import br.com.moosegroup.dao.LancamentoDAO;
import br.com.moosegroup.models.Lancamento;
import br.com.moosegroup.models.Admin;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
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
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.collections.FXCollections;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

public class FormListarLancamentoController implements Initializable {

    @FXML
    private TableView<Lancamento> tblLancamentos;
    @FXML
    private TableColumn<Lancamento, String> colId;
    @FXML
    private TableColumn<Lancamento, String> colIdGrupo;
    @FXML
    private TableColumn<Lancamento, String> colAltitudeMaxima;
    @FXML
    private TableColumn<Lancamento, String> colVelocidadeMaxima;
    @FXML
    private TableColumn<Lancamento, String> colTempoPropulsao;
    @FXML
    private TableColumn<Lancamento, String> colPicoAceleracao;
    @FXML
    private TableColumn<Lancamento, String> colAceleracaoMedia;
    @FXML
    private TableColumn<Lancamento, String> colTempoApogeuDescida;
    @FXML
    private TableColumn<Lancamento, String> colTempoEjecao;
    @FXML
    private TableColumn<Lancamento, String> colAltitudeEjecao;
    @FXML
    private TableColumn<Lancamento, String> colTaxaDescida;
    @FXML
    private TableColumn<Lancamento, String> colDuracaoVoo;
    @FXML
    private TableColumn<Lancamento, String> colDataLancamento;
    @FXML
    private TableColumn<Lancamento, String> colDistanciaAlvo;
    @FXML
    private TableColumn<Lancamento, String> colAnguloLancamento;
    @FXML
    private TableColumn<Lancamento, String> colVelocidadeVento;

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
    private Lancamento lancamento;

    private List<Lancamento> list;
    private ObservableList<Lancamento> observableListLancamento;

    private Admin admin;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void initWithData(Admin admin) {
        if (admin != null) {
            this.admin = admin;
        }
    }

    @FXML
    void btnConsultarAction(ActionEvent event) throws IOException {
        String search = txtPesquisa.getText();

        LancamentoDAO lancamentoDAO = new LancamentoDAO();
        list = new ArrayList<>();

        list = lancamentoDAO.listarLancamento(search, null);
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colIdGrupo.setCellValueFactory(new PropertyValueFactory<>("idGrupo"));
        colAltitudeMaxima.setCellValueFactory(new PropertyValueFactory<>("altitudeMaxima"));
        colVelocidadeMaxima.setCellValueFactory(new PropertyValueFactory<>("velocidadeMaxima"));
        colTempoPropulsao.setCellValueFactory(new PropertyValueFactory<>("tempoPropulsao"));
        colPicoAceleracao.setCellValueFactory(new PropertyValueFactory<>("picoAceleracao"));
        colAceleracaoMedia.setCellValueFactory(new PropertyValueFactory<>("aceleracaoMedia"));
        colTempoApogeuDescida.setCellValueFactory(new PropertyValueFactory<>("tempoApogeuDescida"));
        colTempoEjecao.setCellValueFactory(new PropertyValueFactory<>("tempoEjecao"));
        colAltitudeEjecao.setCellValueFactory(new PropertyValueFactory<>("altitudeEjecao"));
        colTaxaDescida.setCellValueFactory(new PropertyValueFactory<>("taxaDescida"));
        colDuracaoVoo.setCellValueFactory(new PropertyValueFactory<>("duracaoVoo"));
        colDataLancamento.setCellValueFactory(new PropertyValueFactory<>("dataLancamento"));
        colDistanciaAlvo.setCellValueFactory(new PropertyValueFactory<>("distanciaAlvo"));
        colAnguloLancamento.setCellValueFactory(new PropertyValueFactory<>("anguloLancamento"));
        colVelocidadeVento.setCellValueFactory(new PropertyValueFactory<>("velocidadeVento"));
        
        if (!list.isEmpty()) {
          observableListLancamento = FXCollections.observableArrayList(list);
          tblLancamentos.setItems(observableListLancamento);
        }
        else {
          JOptionPane.showMessageDialog(null, "Não foi encontrado nenhum lançamento.");
        }
    }

    @FXML
    void btnAlterarAction(ActionEvent event) throws IOException {
        Lancamento selectedLancamento = tblLancamentos.getSelectionModel().getSelectedItem();

        if (selectedLancamento == null) {
            JOptionPane.showMessageDialog(null, "Selecione um lançamento para alterar.");
            return;
        }

        ((Node) (event.getSource())).getScene().getWindow().hide();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/br/com/moosegroup/views/FormAlterarLancamento.fxml"));
        Pane root =  fxmlLoader.load();
        FormAlterarLancamentoController controller = fxmlLoader.<FormAlterarLancamentoController>getController();
        controller.initWithData(admin, selectedLancamento);

        Scene scene = new Scene(root);
        Stage stage = new Stage();

        stage.setScene(scene);
        stage.setTitle("Alterar Lançamento");
        stage.show();
    }

    @FXML
    void btnExcluirAction(ActionEvent event) throws IOException {
        Lancamento selectedLancamento = tblLancamentos.getSelectionModel().getSelectedItem();

        if (selectedLancamento == null) {
            JOptionPane.showMessageDialog(null, "Selecione um lançamento para excluir.");
            return;
        }
        ((Node) (event.getSource())).getScene().getWindow().hide();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/br/com/moosegroup/views/FormExcluirLancamento.fxml"));
        Pane root =  fxmlLoader.load();
        FormExcluirLancamentoController controller = fxmlLoader.<FormExcluirLancamentoController>getController();
        controller.initWithData(admin, selectedLancamento);

        Scene scene = new Scene(root);
        Stage stage = new Stage();

        stage.setScene(scene);
        stage.setTitle("Excluir Lançamento");
        stage.show();
    }

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
}
