import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Text;
import javafx.stage.Stage;


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
    void verAnotação(ActionEvent event) {

    }

    @FXML
    void voltaTela(ActionEvent event) throws IOException {
        Stage stage = (Stage) xBtn.getScene().getWindow();
        stage.close();
    
    }

}
