import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
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
        System.exit(0);
    }

    @FXML
    void finalizaCadastro(ActionEvent event) {

        if(!validadorDeTexto.verificaNomeUsuario(nomeTextBox.getText())){
            erroMensagemText.setVisible(true);
            System.out.println("O usuário digitado é inválido");
            erroMensagemText.setText("O usuário digitado é inválido");
            return;
        }
        if(!validadorDeTexto.validarEmail(emailTextBox.getText())){
            System.out.println("Email inválido");
            erroMensagemText.setVisible(true);
            erroMensagemText.setText("O email digitado é inválido");
            return;

        }
        if(!validadorDeTexto.validarSenha(senhaTextBox.getText())){
            System.out.println("Senha inválida");
            erroMensagemText.setVisible(true);
            erroMensagemText.setText("A senha digitada é inválida");
            return;
        }
        if(!senhaTextBox.getText().equals(confirmaSenhaTextBox.getText())){
            erroMensagemText.setVisible(true);
            erroMensagemText.setText("As senhas não confirmam");

            System.out.println("As senhas não confirmam");
        }
        else{
            erroMensagemText.setVisible(false);
            
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
        Parent root = FXMLLoader.load(getClass().getResource("/FXML/Login.fxml"));
        Stage loginStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene loginScene = new Scene(root);
        loginStage.setScene(loginScene);
        loginStage.show();
    }

}
