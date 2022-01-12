
import java.io.IOException;

import application.sceneController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class telaEscreverAnotacaoDiario {
    @FXML
    public void initialize() {
        digitarAnotacao.setWrapText(true);
    }

    @FXML
    private TextArea digitarAnotacao;

    @FXML
    private ChoiceBox<?> humorDia;

    @FXML
    private TextField tituloAnotacao;

    @FXML
    private Button voltarBtn;

    @FXML
    private Button xBtn;

    @FXML
    void addTituloAnotacao(ActionEvent event) {

    }

    @FXML
    void fechaAba(ActionEvent event) {
        fecharStage();
    }

    @FXML
    void voltaTela(ActionEvent event) throws IOException {
        mostrarTelaDiario(event);
    }

    void fecharStage(){
        Stage stage=(Stage)this.xBtn.getScene().getWindow();
        stage.close();
    }
    void mostrarTelaDiario(ActionEvent event) throws IOException{
        fecharStage();
        sceneController sc = new sceneController();
        sc.trocarParaTelaDiario(event);
    }
}
