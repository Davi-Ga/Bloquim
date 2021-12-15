import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
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
            
        }
        else if(!senhaTextBox.getText().equals(senhaUsuarioStringDeComparacao)){
            System.out.println("A senha digitada é inválida");
        }
        else{


            Parent root;
            try {
                root = FXMLLoader.load(getClass().getResource("/FXML/telaAnotacao.fxml"));
                Stage stage = new Stage();
                stage.setTitle("My New Stage Title");
                stage.setScene(new Scene(root));
                stage.initStyle(StageStyle.UNDECORATED);
                stage.show();
                // Hide this current window (if this is what you want)
                //((Node)(event.getSource())).getScene().getWindow().hide();
            }
            catch (IOException e) {
                e.printStackTrace();
            }


            // //FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/telaAnotacao.fxml"));
            // Parent telaNova = FXMLLoader.load(getClass().getResource("/FXML/telaAnotacoes.fxml"));
            // // Stage anotacoeStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            // Scene anotacoesScene = new Scene(telaNova);
            
            
            // // anotacoeStage.setScene((anotacoesScene));
            // // anotacoeStage.show();
            
        }
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
    void vaiTelaCadastro(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/FXML/telacadastro.fxml"));
        Stage cadastroStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene cadastroscene = new Scene(root);
        cadastroStage.setScene(cadastroscene);
        cadastroStage.show();
    }
    

}
