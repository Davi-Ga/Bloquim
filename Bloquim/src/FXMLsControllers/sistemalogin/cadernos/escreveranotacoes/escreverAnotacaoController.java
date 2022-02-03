package FXMLsControllers.sistemalogin.cadernos.escreveranotacoes;

import java.io.IOException;
import java.sql.SQLException;

import application.sceneController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class escreverAnotacaoController {

    private int id;
    
    private String nome;
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
   

    @FXML
    public void initData(int id, String nome){
        setId(id);
        setNome(nome);
    }
    @FXML
    private Button salvaAnotacaoBtn;

    @FXML
    private ScrollBar scrollBar;

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
    void salvaAnotacao(ActionEvent event) {

    }

    @FXML
    void voltaTela(ActionEvent event) throws IOException, SQLException {
        Stage stage = (Stage) xBtn.getScene().getWindow();
        stage.close();
        sceneController sc = new sceneController();
        sc.trocarParaTelaAnotacoes(event,getId(),getNome());
    }

}

