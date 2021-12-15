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


}
