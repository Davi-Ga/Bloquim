import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Text;
import java.io.IOException;

import java.sql.Connection;

import java.sql.SQLException;
import conexaobd.conexaoBancoDeDados;
import conexaobd.usuario;
import conexaobd.usuarioDAO;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import validadorDeTexto.validadorDeTexto;


public class cadastroController {

    @FXML
    private PasswordField confirmaSenhaTextBox;

    @FXML
    private TextField emailTextBox;

    @FXML
    private Button feitoBtn;

    @FXML
    private Text erroMensagemText;
    
    @FXML
    private TextField nomeTextBox;

    @FXML
    private PasswordField senhaTextBox;

    @FXML
    private Button voltarBtn;

    @FXML
    private Button xBtn;

    @FXML
    void confirmaSenhaUsuario(ActionEvent event) {

    }

    @FXML
    void emailUsuario(ActionEvent event) {
         
}
    @FXML
    void fechaAba(ActionEvent event) {
        Alert alertaFecharApp = new Alert(AlertType.CONFIRMATION);
        alertaFecharApp.setHeaderText("Quer mesmo fechar o aplicativo?");
        alertaFecharApp.setContentText("Bloquim sentirá a sua falta.");
        if(alertaFecharApp.showAndWait().get() != ButtonType.OK){
            return;
        }
        else{
            System.exit(0);
        }
    }

    @FXML
    void finalizaCadastro(ActionEvent event) throws SQLException, IOException {
            

        if(!validadorDeTexto.verificaNomeUsuario(nomeTextBox.getText()) ){
            erroMensagemText.setVisible(true);
            System.out.println("O usuário digitado é inválido");
            erroMensagemText.setText("O usuário digitado é inválido");
            return;
        }
    
        if(!validadorDeTexto.validarEmail(emailTextBox.getText())){
            erroMensagemText.setVisible(true);
            System.out.println("Email inválido");
            erroMensagemText.setText("O email digitado é inválido");
            return;

        }
        if(!validadorDeTexto.validarSenha(senhaTextBox.getText())){
            erroMensagemText.setVisible(true);
            System.out.println("Senha inválida");
            erroMensagemText.setText("A senha digitada é inválida");
            return;
        }
        if(!senhaTextBox.getText().equals(confirmaSenhaTextBox.getText())){
            erroMensagemText.setVisible(true);
            erroMensagemText.setText("As senhas não confirmam");
            System.out.println("As senhas não confirmam");
            return;
        }
        else{
            erroMensagemText.setVisible(false);
            cadastroUsuario();
            voltaTelaLogin();
        }
    }

    @FXML
    void nomeUsuario(ActionEvent event) {

    }

    @FXML
    void senhaUsuario(ActionEvent event) {

    }

    @FXML
    void voltaTela(ActionEvent event) throws IOException {
        voltaTelaLogin();
    }

    private void cadastroUsuario() throws SQLException{
        String nome = nomeTextBox.getText();
        String senha = senhaTextBox.getText();
        String email = emailTextBox.getText();
        usuario loginUsuario = new usuario(nome, senha, email);

        
        Connection conexao = new conexaoBancoDeDados().getConnection();
        usuarioDAO usuarioDAO = new usuarioDAO(conexao);
        usuarioDAO.inserir(loginUsuario);

        conexao.close();
    }
    
    private void voltaTelaLogin() throws IOException{
        Object root = FXMLLoader.load(getClass().getResource("/FXML/Login.fxml"));
        Stage voltaTelaLogin = new Stage();
        voltaTelaLogin.setScene(new Scene((Parent) root));
        voltaTelaLogin.initStyle(StageStyle.UNDECORATED);
        voltaTelaLogin.showAndWait();
    }

    
      
}
