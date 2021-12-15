import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class anotacaoController {
<<<<<<< HEAD
    @FXML
    public void initialize() throws IOException {
        
        mostrarTelaDeLogin();
    
    }
=======
    
>>>>>>> 32e105802125e16cd0dd6d4be091f3d3e553686c

    @FXML
    private Button Anotação;

    @FXML
    private Button addAnotacao;

    @FXML
    private Text nomeCaderno;

    @FXML
    private Button voltarBtn;

    @FXML
    private Button xBtn;

    @FXML
    void AdicionaAnotacao(ActionEvent event) {


    }


    @FXML
    void fechaAba(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void verAnotação(ActionEvent event) {

    }

    @FXML
    void voltaTela(ActionEvent event) throws IOException {
        
        
    }


<<<<<<< HEAD
    private String mostrarTelaDeLogin() throws IOException{
        Object root = FXMLLoader.load(getClass().getResource("/FXML/Login.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene((Parent) root));
        stage.initStyle(StageStyle.UNDECORATED);
        stage.showAndWait();
        // Hide this current window (if this is what you want)
        //((Node)(event.getSource())).getScene().getWindow().hide();
        String retorno = stage.getScene().getClass().getMethod(, parameterTypes)
        return root.getClass().getResource("loginController");
    }

=======
>>>>>>> 32e105802125e16cd0dd6d4be091f3d3e553686c
}
