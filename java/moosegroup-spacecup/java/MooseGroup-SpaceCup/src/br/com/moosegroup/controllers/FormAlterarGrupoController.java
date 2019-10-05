package br.com.moosegroup.controllers;

import br.com.moosegroup.dao.GrupoDAO;
import br.com.moosegroup.models.Admin;
import br.com.moosegroup.models.Grupo;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class FormAlterarGrupoController implements Initializable {   
    
    @FXML
    private JFXTextField txtLogin;

    @FXML
    private JFXPasswordField txtSenha;

    @FXML
    private JFXTextField txtNomeGrupo;

    @FXML
    private JFXTextField txtPesoFoguete;

    @FXML
    private JFXButton btnAlterar;

    @FXML
    private JFXButton btnCancelar;

    @FXML
    private JFXComboBox cbbTurma;

    @FXML
    private JFXTextField txtNomeFoguete;
    private Admin admin;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<String> listaTurma = null;
        
        GrupoDAO grupoDao = new GrupoDAO();
        listaTurma = grupoDao.getTurma();
        
        for (int i = 0; i < listaTurma.size(); i++) {
            cbbTurma.getItems().addAll(listaTurma.get(i));
        }
    }   
    
    private Grupo grupo;
    
    public void initWithData(Grupo grupo, Admin admin) {
        this.grupo = grupo;
        
        this.admin = admin;
        
        txtNomeGrupo.setText(this.grupo.getNome());
        cbbTurma.setValue(grupo.getTurma());
        txtNomeFoguete.setText(grupo.getFoguete());
        txtPesoFoguete.setText(String.valueOf(grupo.getPesoFoguete()));
        txtLogin.setText(grupo.getNomeAcesso());
        txtSenha.setText(grupo.getSenha());
    }
    
    @FXML
    private void btnAlterarAction(ActionEvent event) {
        try {
            if(txtNomeGrupo.getText() == null || txtNomeGrupo.getText().length() <= 0){
                JOptionPane.showMessageDialog(null, "Campo Nome do Grupo do  é obrigatório.");
                return;
            }

            if(cbbTurma.getValue() == null || cbbTurma.getValue().equals("")){
                JOptionPane.showMessageDialog(null, "Campo Turma é obrigatório.");
                return;
            }

            if(txtNomeFoguete.getText() == null || txtNomeFoguete.getText().length() <= 0){
                JOptionPane.showMessageDialog(null, "Campo Foguete é obrigatório.");
                return;
            }

            if(Double.parseDouble(txtPesoFoguete.getText()) <= 0 || txtPesoFoguete.getText().equals(" ")){
                JOptionPane.showMessageDialog(null, "Campo Peso é obrigatório.");
                return;
            }

            if(txtLogin.getText() == null || txtLogin.getText().length() <= 0){
                JOptionPane.showMessageDialog(null, "Campo Login é obrigatório.");
                return;
            }

            if(txtSenha.getText() == null || txtSenha.getText().length() <= 0){
                JOptionPane.showMessageDialog(null, "Campo Senha é obrigatório.");
                return;
            }

            String nomeGrupo = txtNomeGrupo.getText();
            String turma = cbbTurma.getSelectionModel().getSelectedItem().toString();
            String nomeFoguete = txtNomeFoguete.getText();
            double peso = Double.parseDouble(txtPesoFoguete.getText());
            String login = txtLogin.getText();
            String senha = txtSenha.getText();
        
        
            grupo = new Grupo(this.grupo.getIdGrupo(), nomeGrupo, this.grupo.getIdTurma(), turma, this.grupo.getIdFoguete(), nomeFoguete, this.grupo.getId(), login, senha, peso);
        
            GrupoDAO grupoDao = new GrupoDAO();
            boolean returnFoguete = grupoDao.alterarFoguete(grupo);
            boolean returnAcesso = grupoDao.alterarAcesso(grupo);
            boolean returnGrupo = grupoDao.alterarGrupo(grupo);
            
            if (returnFoguete == true && returnAcesso == true && returnGrupo == true )
                JOptionPane.showMessageDialog(null, "Grupo Alterado!");
            else
                JOptionPane.showMessageDialog(null, "Falha ao Alterar Grupo: ");
            
            limparCampos();
            
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
        catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Campo Peso é obrigatório.");
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro " + e);
        }       
    }
    
    @FXML
    private void btnCancelarAction(ActionEvent event) throws Exception {
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
    
    private void limparCampos() {
        txtLogin.setText("");
        txtSenha.setText("");
        txtNomeGrupo.setText("");
        txtPesoFoguete.setText("");      
    }
}
