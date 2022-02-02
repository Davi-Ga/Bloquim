package FXMLsControllers.sistemalogin.cadernos;

import java.io.IOException;
import application.sceneController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.ButtonType;


public class cadernoController {

    private String email;
    private String nome;

    public void initData(String email,String nome){
        setEmail(email);
        setNome(nome);
        nomeLabelText.setText(getNome());
        
    }

    @FXML
    public void initialize() throws IOException {
     
       
    } 

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
    private Text nomeLabelText;

    @FXML
    private Button addCadernoBtn;

    @FXML
    private Button caderno001;

    @FXML
    private Button caderno002;

    @FXML
    private Button caderno003;

    @FXML
    private Button caderno004;

    @FXML
    private Button caderno005;

    @FXML
    private Button caderno006;

    @FXML
    private Button caderno007;

    @FXML
    private Button caderno008;

    @FXML
    private Button irDiarioBtn;

    @FXML
    private Button voltarBtn;

    @FXML
    private Button xBtn;

    @FXML
    void abreDiario(ActionEvent event) throws IOException {
        mostrarTelaDoDiario(event);
        
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
            fecharStage();
            mostrarTelaLogin(event);
        }
    }
    

    @FXML
    void entraCaderno1(ActionEvent event) throws IOException {
        mostrarTelaDeAnotação(event);
    }
    @FXML
    void entraCaderno2(ActionEvent event) {

    }

    @FXML
    void entraCaderno3(ActionEvent event) {

    }

    @FXML
    void entraCaderno4(ActionEvent event) {

    }

    @FXML
    void entraCaderno5(ActionEvent event) {

    }

    @FXML
    void entraCaderno6(ActionEvent event) {

    }

    @FXML
    void entraCaderno7(ActionEvent event) {

    }

    @FXML
    void entraCaderno8(ActionEvent event) {

    }

    @FXML
    void voltaTela(ActionEvent event) throws IOException {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setHeaderText("Quer mesmo voltar à tela de Login?");
        alert.setContentText("Voltar à tela de Login irá resultar em um processo de Logoff.");
        if(alert.showAndWait().get() != ButtonType.OK){
            return;
        }
        
    }

    private void mostrarTelaDoDiario(ActionEvent event) throws IOException{
        fecharStage();
        sceneController sc = new sceneController();
        sc.trocarParaTelaDiario(event,getEmail(),getNome());
    }
    
    private void mostrarTelaDeAnotação(ActionEvent event) throws IOException{
        fecharStage();
        sceneController sc = new sceneController();
        sc.trocarParaTelaAnotacoes(event,getEmail(),getNome());
    }

    private void mostrarTelaLogin(ActionEvent event) throws IOException{
        fecharStage();
        sceneController sc = new sceneController();
        sc.trocarParaTelaLogin(event);
    }


    private void fecharStage(){
        Stage stage = (Stage) xBtn.getScene().getWindow();
        stage.close();
    }


}