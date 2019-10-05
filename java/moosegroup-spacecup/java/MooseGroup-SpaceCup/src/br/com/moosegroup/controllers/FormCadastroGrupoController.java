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

public class FormCadastroGrupoController implements Initializable {

    @FXML
    private JFXTextField txtLogin;

    @FXML
    private JFXTextField txtPeso;

    @FXML
    private JFXPasswordField txtSenha;

    @FXML
    private JFXTextField txtNomeGrupo;

    @FXML
    private JFXButton btnCancelar;

    @FXML
    private JFXComboBox cbbTurma;

    @FXML
    private JFXTextField txtNomeFoguete;

    @FXML
    private JFXButton btnRegistrar;

    private Admin admin;

    @FXML
    void btnRegistrarAction(ActionEvent event) {   
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
            
            if(Double.parseDouble(txtPeso.getText()) <= 0 || txtPeso.getText().equals(" ")){
                JOptionPane.showMessageDialog(null, "Campo Peso é obrigatório.");
                return;
            }
            
            if(txtLogin.getText().trim() == null || txtLogin.getText().trim().length() <= 0){
                JOptionPane.showMessageDialog(null, "Campo Login é obrigatório.");
                return;
            }
            
            if(txtSenha.getText().trim() == null || txtSenha.getText().trim().length() <= 0){
                JOptionPane.showMessageDialog(null, "Campo Senha é obrigatório.");
                return;
            }
            
            String nomeGrupo = txtNomeGrupo.getText();
            String turma = cbbTurma.getSelectionModel().getSelectedItem().toString();
            String nomeFoguete = txtNomeFoguete.getText();
            double peso = Double.parseDouble(txtPeso.getText());
            String login = txtLogin.getText().trim();
            String senha = txtSenha.getText().trim();
        
            Grupo grupo = new Grupo(nomeGrupo, turma, nomeFoguete, login, senha);            
           
            GrupoDAO grupoDao = new GrupoDAO();
            boolean returnFoguete = grupoDao.cadastrarFoguete(grupo, peso);
            boolean returnAcesso = grupoDao.cadastrarAcesso(grupo);
            boolean returnGrupo = grupoDao.cadastrarGrupo(grupo);

            if (returnFoguete == true && returnAcesso == true && returnGrupo == true )
                JOptionPane.showMessageDialog(null, "Grupo Cadastrado!");
            else
                JOptionPane.showMessageDialog(null, "Falha ao Cadastra Grupo: ");

            limparCampos();  
                       
        }
        catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Campo Peso é obrigatório.");
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro " + e);
        }
    }
    
    public boolean validarInput(Grupo grupo){
            if(grupo.getNome() == null || grupo.getNome().length() <= 0){
                JOptionPane.showMessageDialog(null, "Campo Nome do Grupo do  é obrigatório.");
                return false;
            }
            
            if(grupo.getTurma() == null || grupo.getTurma().length() <= 0){
                JOptionPane.showMessageDialog(null, "Campo Turma é obrigatório.");
                return false;
            }
            
            if(grupo.getFoguete()== null || grupo.getFoguete().length() <= 0){
                JOptionPane.showMessageDialog(null, "Campo Foguete é obrigatório.");
                return false;
            }
            
            if(grupo.getPesoFoguete() <= 0){
                JOptionPane.showMessageDialog(null, "Campo Peso é obrigatório.");
                return false;
            }
            
            if(grupo.getNomeAcesso() == null || grupo.getNomeAcesso().length() <= 0){
                JOptionPane.showMessageDialog(null, "Campo Login é obrigatório.");
                return false;
            }
            
            if(grupo.getSenha() == null || grupo.getSenha().length() <= 0){
                JOptionPane.showMessageDialog(null, "Campo Senha é obrigatório.");
                return false;
            }
        
        return true;
    }

    @FXML
    private void btnCancelarAction(ActionEvent event) throws Exception {
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

    private void limparCampos() {
        txtNomeGrupo.setText("");
        txtNomeFoguete.setText("");
        txtPeso.setText("");
        txtLogin.setText("");
        txtSenha.setText("");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<String> listaTurma = null;

        GrupoDAO grupoDao = new GrupoDAO();
        listaTurma = grupoDao.getTurma();

        for (int i = 0; i < listaTurma.size(); i++) {
            cbbTurma.getItems().addAll(listaTurma.get(i));
        }
    }

    public void initWithData(Admin admin) {
        this.admin = admin;
    }
}
