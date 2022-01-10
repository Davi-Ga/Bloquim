import java.io.IOException;
import application.sceneController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Scene;


public class loginController {

    private String nomeUsuarioStringDeComparacao = "batata";
    private String senhaUsuarioStringDeComparacao = "batata123";
  

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
    void entrarApp(ActionEvent event) throws IOException  {
        if(!usuarioTextBox.getText().equals(nomeUsuarioStringDeComparacao)){
            System.out.println("O nome de usuário digitado é inválido");
            return;
        }
        else if(!senhaTextBox.getText().equals(senhaUsuarioStringDeComparacao)){
            System.out.println("A senha digitada é inválida");
            return;
        }
        else{
            
            sceneController sc = new sceneController();
            Stage stage=(Stage)xBtn.getScene().getWindow();
            stage.close();
            sc.trocarParaTelaCaderno(event);
        }
            
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
    void nomeUsuario(ActionEvent event) {

    }

    @FXML
    void redefineSenha(ActionEvent event) {

    }

    @FXML
    void senhaUsuario(ActionEvent event) {

    }

    @FXML
    void vaiTelaCadastro(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/FXML/telaCadastro.fxml"));
        Stage cadastroStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene cadastroscene = new Scene(root);
        cadastroStage.setScene(cadastroscene);
        cadastroStage.show();
    }
    

}
