package FXMLsControllers;
import validadorDeTexto.validadorDeTexto;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import application.sceneController;
import conexaobd.conexaoBancoDeDados;
import conexaobd.usuario;
import conexaobd.usuarioDAO;
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
   
    
  

    @FXML
    private Button cadastreSeBtn;

    @FXML
    private Button esqueciSenhaBtn;

    @FXML
    private Button feitoBtn;

    @FXML
    private PasswordField senhaTextBox;

    @FXML
    private TextField emailTextBox;

    @FXML
    private Button xBtn;

    @FXML
    void entrarApp(ActionEvent event) throws IOException, SQLException  {
        
        autenticar(event);

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
    void emailUsuario(ActionEvent event) {

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

    public void autenticar(ActionEvent event) throws SQLException, IOException{

        String email = emailTextBox.getText();
        String senha = senhaTextBox.getText();
    

        usuario usuarioAutenticar = new usuario(email, senha);
        

        Connection conexao = new conexaoBancoDeDados().getConnection();
        usuarioDAO usuarioDAO = new usuarioDAO(conexao);
        

        boolean existe = usuarioDAO.usuarioExisteNoBanco(usuarioAutenticar);
        
            if(existe){
        
                sceneController sc = new sceneController();
                Stage stage=(Stage)xBtn.getScene().getWindow();
                stage.close();
                
                sc.trocarParaTelaCaderno(event,usuarioAutenticar.getemail(),name);    
                if(usuarioAutenticar.getnome().isEmpty() || usuarioAutenticar.getnome()==null){
                    System.out.println("A variável 'nome' está nula!");
                }
                

            }
            else{
                mostrarAlertaDeUsuarioInvalido();
            }
    }

    private void mostrarAlertaDeUsuarioInvalido() {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setHeaderText("Usuário inválido!");
        alert.setContentText("Verifique os valores digitados, e tente novamente.");
        alert.show();
    }
    
    
    
    
}
