package FXMLsControllers.sistemalogin.cadernos;


import java.io.IOException;
import application.sceneController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class diarioController extends cadernoController {

    private String email;
    private String nome;
    
    @FXML
    public void initData(String email,String nome) {
        setEmail(email);
        setNome(nome);
        nomeLabelText.setText(getNome());
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

  
    @FXML
    private Button addAnotacaoDiarioBtn;

    @FXML
    private Button anotacaoDiario1;

    @FXML
    private Button anotacaoDiario2;

    @FXML
    private Button anotacaoDiario3;

    @FXML
    private Button anotacaoDiario4;

    @FXML
    private Button anotacaoDiario5;

    @FXML
    private Button anotacaoDiario6;

    @FXML
    private Button anotacaoDiario7;

    @FXML
    private Button anotacaoDiario8;

    @FXML
    private Button anotacaoDiario9;

    @FXML
    private Button anotacaoDiario10;

    @FXML
    private Button anotacaoDiario11;

    @FXML
    private Button anotacaoDiario12;

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
    void vaiParaAnotacaoDiario1(ActionEvent event) {
        
    }

    @FXML
    void vaiParaAnotacaoDiario2(ActionEvent event) {

    }

    @FXML
    void vaiParaAnotacaoDiario3(ActionEvent event) {

    }

    @FXML
    void vaiParaAnotacaoDiario4(ActionEvent event) {

    }

    @FXML
    void vaiParaAnotacaoDiario5(ActionEvent event) {

    }

    @FXML
    void vaiParaAnotacaoDiario6(ActionEvent event) {

    }

    @FXML
    void vaiParaAnotacaoDiario7(ActionEvent event) {

    }

    @FXML
    void vaiParaAnotacaoDiario8(ActionEvent event) {

    }

    @FXML
    void vaiParaAnotacaoDiario9(ActionEvent event) {

    }

    @FXML
    void vaiParaAnotacaoDiario10(ActionEvent event) {

    }

    @FXML
    void vaiParaAnotacaoDiario11(ActionEvent event) {

    }

    @FXML
    void vaiParaAnotacaoDiario12(ActionEvent event) {

    }

    @FXML
    void voltaTela(ActionEvent event) throws IOException {
        fecharStage();
        sceneController sc = new sceneController();
        sc.trocarParaTelaCaderno(event,getEmail(),getNome());
        System.out.println(nome);
    }
    public void fecharStage(){
        Stage stage = (Stage) xBtn.getScene().getWindow();
        stage.close();
    }

    void novaAnotacao(ActionEvent event) throws IOException{
        fecharStage();
        sceneController sc = new sceneController();
        sc.trocarParaTelaEscreverAnotacaoDiario(event,getEmail(),getNome());
        System.out.println(nome);
    }
}
