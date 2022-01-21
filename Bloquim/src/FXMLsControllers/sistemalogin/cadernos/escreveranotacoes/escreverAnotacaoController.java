package FXMLsControllers.sistemalogin.cadernos.escreveranotacoes;

import java.io.IOException;

import application.sceneController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class escreverAnotacaoController {

    private String email;
    private String nome;
    
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
    private Button btnItalico;

    @FXML
    private Button btnNegrito;

    @FXML
    private ScrollBar scrollBar;

    @FXML
    private Spinner<?> tamanhoFonte;

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

    }

    @FXML
    void textoItalico(ActionEvent event) {

    }

    @FXML
    void textoNegrito(ActionEvent event) {

    }

    @FXML
    void voltaTela(ActionEvent event) throws IOException {
        Stage stage = (Stage) xBtn.getScene().getWindow();
        stage.close();
        sceneController sc = new sceneController();
        sc.trocarParaTelaDiario(event,getEmail(),getNome());
    }

}

