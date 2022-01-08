
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class cadernoDiarioController extends cadernoController {

    @FXML
    private Button addAnotacaoDiarioBtn;

    @FXML
    private Button anotacaoDiario;

    @FXML
    private Text nomePessoa;

    @FXML
    private Button voltarBtn;

    @FXML
    private Button xBtn;

    @FXML
    void adicionaAnotacaoDiario(ActionEvent event) {
        
    }

    @FXML
    void fechaAba(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void vaiParaAnotacaoDiario(ActionEvent event) {
        
    }

    @FXML
    void voltaTela(ActionEvent event) {
        Stage stage = (Stage) xBtn.getScene().getWindow();
        stage.close();
    }

}
