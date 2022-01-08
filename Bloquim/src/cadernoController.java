import java.io.IOException;



import application.sceneController;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.scene.control.ButtonType;
import javafx.stage.StageStyle;

public class cadernoController {
    @FXML
    public void initialize() throws IOException {
       
        
       
    } 
    @FXML
    private Button addCadernoBtn;

    @FXML
    private Button cadernoBD;

    @FXML
    private Button diarioBtn;

    @FXML
    private Button voltarBtn;

    @FXML
    private Button xBtn;

    @FXML
    void irDiario(ActionEvent event) throws IOException {
        mostrarTelaDoDiario();
    }

    @FXML
    void adicionaCadernoNovo(ActionEvent event) {

    }

    @FXML
    void fechaAba(ActionEvent event) throws IOException {
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
    void vaiParaAnotacao(ActionEvent event) throws IOException {
        mostrarTelaDeAnotação();
    }

    @FXML
    void voltaTela(ActionEvent event) throws IOException {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setHeaderText("Quer mesmo voltar à tela de Login?");
        alert.setContentText("Voltar à tela de Login irá resultar em um processo de Logoff.");
        if(alert.showAndWait().get() != ButtonType.OK){
            return;
        }
        else{
            mostrarTelaDeLogin(event);
        }
    }


    private void mostrarTelaDeLogin(ActionEvent event) throws IOException{
        sceneController sc = new sceneController();
        sc.trocarParaTelaLogin(event);
        
    }

    private void mostrarTelaDoDiario() throws IOException{
        Object root = FXMLLoader.load(getClass().getResource("/FXML/telaCadernoDiario.fxml"));
        Stage diario = new Stage();
        diario.setScene(new Scene((Parent) root));
        diario.initStyle(StageStyle.UNDECORATED);
        diario.show();
    }
    private void mostrarTelaDeAnotação() throws IOException{
        Object root = FXMLLoader.load(getClass().getResource("/FXML/telaAnotacao.fxml"));
        Stage anotacao = new Stage();
        anotacao.setScene(new Scene((Parent) root));
        anotacao.initStyle(StageStyle.UNDECORATED);
        anotacao.showAndWait();
    }


}
    


