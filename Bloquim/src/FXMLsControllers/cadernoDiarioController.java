package FXMLsControllers;


import java.io.IOException;

import application.sceneController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class cadernoDiarioController extends cadernoController {

    private String email;
    private String nome;
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
    public void initData(String email,String nome) {
        setEmail(email);
        setNome(nome);
    }

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
        sc.trocarParaTelaCaderno(event,null,null);
    }
    public void fecharStage(){
        Stage stage = (Stage) xBtn.getScene().getWindow();
        stage.close();
    }

    void novaAnotacao(ActionEvent event) throws IOException{
        fecharStage();
        sceneController sc = new sceneController();
        sc.trocarParaTelaDiarioAnotacao(event,getEmail(),getNome());
    }
}
