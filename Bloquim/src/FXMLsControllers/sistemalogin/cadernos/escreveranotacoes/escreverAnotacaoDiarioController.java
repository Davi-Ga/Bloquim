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

    private int id;
    private String nome;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

  

    

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @FXML
    public void initialize() {
        
        digitarAnotacao.setWrapText(true);
     
    }

    @FXML
    private TextArea digitarAnotacao;

    @FXML
    private ChoiceBox<?> humorDia;

    @FXML
    private ScrollBar scrollBar;

    @FXML
    private Button salvaAnotacaoBtn;

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
    void salvaAnotacao(ActionEvent event) {

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
        sc.trocarParaTelaDiario(event,getId(),getNome());
    }

    public void initData(int id, String nome) {
        
        setNome(nome);
    }
}