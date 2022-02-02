package FXMLsControllers.sistemalogin.cadernos;


import java.io.IOException;
import application.sceneController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class anotacaoDiarioController extends cadernoController {

    

  
    @FXML
    private Button addAnotacaoDiarioBtn;

    @FXML
    private Button anotacaoDiario;

    @FXML
    private Text nomeLabelText;

    @FXML
    private Button voltarBtn;

    @FXML
    private Button xBtn;

    @FXML
    void adicionaAnotacaoDiario(ActionEvent event) throws IOException {
        novaAnotacao(event);
    }

    @FXML
    void fechaAba(ActionEvent event) {
        fecharStage();
    }

    @FXML
    void vaiParaAnotacaoDiario(ActionEvent event) {
        
    }

    @FXML
    void voltaTela(ActionEvent event) throws IOException {
        fecharStage();
        sceneController sc = new sceneController();
        sc.trocarParaTelaCaderno(event,getId(),getNome());
        System.out.println(nome);
    }
    public void fecharStage(){
        Stage stage = (Stage) xBtn.getScene().getWindow();
        stage.close();
    }

    void novaAnotacao(ActionEvent event) throws IOException{
        fecharStage();
        sceneController sc = new sceneController();
        sc.trocarParaTelaDiarioAnotacao(event,getId(),getNome());
        System.out.println(getNome());
    }
}
