package FXMLsControllers.sistemalogin;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Text;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFileChooser;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

import application.sceneController;
import conexaobd.conexaoBancoDeDados;
import conexaobd.enviarEmail;
import conexaobd.usuario;
import conexaobd.usuarioDAO;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import validadorDeTexto.validadorDeTexto;


public class cadastroController {
    String caminho = "C:/Users/davig/Desktop/Bloquim/Documentos/42cb90c7-291c-47f4-8a70-a3a07f92db32.jfif";
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
    void finalizaCadastro(ActionEvent event) throws SQLException, IOException, EmailException {
        String email = emailTextBox.getText();

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
                //enviandoEmail(email);
                mostrarTelaLogin(event);
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
        mostrarTelaLogin(event);
    }

    private void cadastroUsuario() throws EmailException{
        String nome = nomeTextBox.getText();
        String senha = senhaTextBox.getText();
        String email = emailTextBox.getText();
        usuario loginUsuario = new usuario(nome, senha, email);

        try{
        Connection conexao = new conexaoBancoDeDados().getConnection();
        usuarioDAO usuarioDAO = new usuarioDAO(conexao);
        usuarioDAO.inserir(loginUsuario);
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setHeaderText("Usuario cadastrado com sucesso!");
            alert.setContentText("Seja bem-vindo ao Bloquim, seu companheiro de anotações.");
            
            //enviarEmail.enviar(caminho,email);
            if(alert.showAndWait().get() == ButtonType.OK){
                return;
            }
            
        }catch(SQLException ex){
            Logger.getLogger(cadastroController.class.getName()).log(Level.SEVERE,null,ex);
        }
        
    }
    
    /*private void enviandoEmail(String useremail) throws EmailException{
             // Create the attachment
        EmailAttachment attachment = new EmailAttachment();
        attachment.setPath("C:/Users/davig/Desktop/Bloquim/Documentos/42cb90c7-291c-47f4-8a70-a3a07f92db32.jfif");
        attachment.setDisposition(EmailAttachment.ATTACHMENT);
        attachment.setName("Bloquim");

        // Create the email message
        MultiPartEmail email = new MultiPartEmail();
        email.setHostName("smtp.gmail.com");
        email.addTo(useremail);
        email.setFrom("bloquimcontact@gmail.com","kyntra93791@");
        email.setSubject("Bloqum");
        email.setMsg("Parabéns o seu cadastro foi um sucesso, seja bem vindo");

        // add the attachment
        email.attach(attachment);

        // send the email
        email.send();
    }*/
    private void mostrarTelaLogin(ActionEvent event) throws IOException{
        fecharStage();
        sceneController sc = new sceneController();
        sc.trocarParaTelaLogin(event);
    }

    private void fecharStage(){
        Stage stage = (Stage) xBtn.getScene().getWindow();
        stage.close();
    }
}
