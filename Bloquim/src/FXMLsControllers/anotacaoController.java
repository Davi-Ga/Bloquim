package FXMLsControllers;

import java.io.IOException;

import application.sceneController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class anotacaoController {
    private String nome;
    private String email;




    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    




    
    @FXML
    public void initData(String email, String nome){
        setEmail(email);
        setNome(nome);
    }

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
    void voltaTela(ActionEvent event) throws IOException {
        Stage stage = (Stage) xBtn.getScene().getWindow();
        stage.close();
        sceneController sc = new sceneController();
        sc.trocarParaTelaCaderno(event, this.email, this.nome);
    }

}
