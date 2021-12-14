import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Scene;


public class loginController {

    @FXML
    private Button cadastreSeBtn;

    @FXML
    private Button esqueciSenhaBtn;

    @FXML
    private Button feitoBtn;

    @FXML
    private PasswordField senhaTextBox;

    @FXML
    private TextField usuarioTextBox;

    @FXML
    private Button xBtn;

    @FXML
    void entrarApp(ActionEvent event) {

    }

    @FXML
    void fechaAba(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void nomeUsuario(ActionEvent event) {

    }

    @FXML
    void redefineSenha(ActionEvent event) {

    }

    @FXML
    void senhaUsuario(ActionEvent event) {

    }

    @FXML
    void vaiTelaCadastro(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/FXML/telacadastro.fxml"));
        Stage cadastroStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene cadastroscene = new Scene(root);
        cadastroStage.setScene(cadastroscene);
        cadastroStage.show();
    }

}
