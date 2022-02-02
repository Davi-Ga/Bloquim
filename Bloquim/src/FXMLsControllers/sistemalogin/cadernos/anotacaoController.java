package FXMLsControllers.sistemalogin.cadernos;

import java.io.IOException;
import java.sql.SQLException;

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
    private int id;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    


    @FXML
    public void initData(int id, String nome){
        setId(id);
        setNome(nome);
    }

    @FXML
    private Button addCadernoBtn;

    @FXML
    private Button anotacao1;

    @FXML
    private Button anotacao2;

    @FXML
    private Button anotacao3;

    @FXML
    private Button anotacao4;

    @FXML
    private Button anotacao5;

    @FXML
    private Button anotacao6;

    @FXML
    private Button anotacao7;

    @FXML
    private Button anotacao8;


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
    void verAnotacao1(ActionEvent event) {

    }
    @FXML
    void verAnotacao2(ActionEvent event) {

    }

    @FXML
    void verAnotacao3(ActionEvent event) {

    }

    @FXML
    void verAnotacao4(ActionEvent event) {

    }

    @FXML
    void verAnotacao5(ActionEvent event) {

    }

    @FXML
    void verAnotacao6(ActionEvent event) {

    }

    @FXML
    void verAnotacao7(ActionEvent event) {

    }

    @FXML
    void verAnotacao8(ActionEvent event) {

    }


    @FXML
    void voltaTela(ActionEvent event) throws IOException, SQLException {
        mostrarTelaCaderno(event);
    }

    private void mostrarTelaCaderno(ActionEvent event) throws IOException, SQLException{
        fecharStage();
        sceneController sc = new sceneController();
        sc.trocarParaTelaCaderno(event,getId(),getNome()); 
    }


    private void fecharStage(){
        Stage stage = (Stage) xBtn.getScene().getWindow();
        stage.close();
    }

    
    void novaAnotacao(ActionEvent event) throws IOException{
        fecharStage();
        sceneController sc = new sceneController();
        sc.trocarParaTelaEscreverAnotacao(event,getId(),getNome());
        System.out.println(nome);
    }

}
