package FXMLsControllers.sistemalogin.cadernos.escreveranotacoes;

import java.io.IOException;

import application.sceneController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class escreverAnotacaoDiarioController {

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
    public void initialize() {
        digitarAnotacao.setWrapText(true);
        setEmail(email);
        setNome(nome);
        
    }
    @FXML
    private Button btnItalico;

    @FXML
    private Button btnNegrito;

    @FXML
    private TextArea digitarAnotacao;

    @FXML
    private ChoiceBox<?> humorDia;

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
    void AbrirChoiceBOX(MouseEvent event) {

    }

    @FXML
    void addTituloAnotacao(ActionEvent event) {

    }

    @FXML
    void fechaAba(ActionEvent event) {
        fecharStage();
    }

    @FXML
    void textoItalico(ActionEvent event) {

    }

    @FXML
    void textoNegrito(ActionEvent event) {

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
        sc.trocarParaTelaDiario(event,getEmail(),getNome());
    }

    public void initData(String email2, String nome2) {
    }
}