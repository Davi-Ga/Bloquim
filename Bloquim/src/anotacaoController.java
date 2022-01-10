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
    private Button addCadernoBtn;

    @FXML
    private Button anotacao;

    @FXML
    private Text nomeCadernoAnotacao;

    @FXML
    private Button voltarBtn;

    @FXML
    private Button xBtn;

    @FXML
    void adicionaAnotacao(ActionEvent event) {

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
    void verAnotacao(ActionEvent event) {

    }

    @FXML
    void voltaTela(ActionEvent event) {
        Stage stage = (Stage) xBtn.getScene().getWindow();
        stage.close();
    }

}
