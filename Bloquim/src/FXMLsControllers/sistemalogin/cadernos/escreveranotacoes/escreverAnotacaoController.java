package FXMLsControllers.sistemalogin.cadernos.escreveranotacoes;

import java.io.IOException;
import java.sql.SQLException;

import application.sceneController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class escreverAnotacaoController {

    private int id;
    private int id_usuario;
    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
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
    public void initData(int id,int id_usuario, String nome){
        setId(id);
        setNome(nome);
        setId_usuario(id_usuario);
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

        
        System.exit(0);
    }

    @FXML
    void salvaAnotacao(ActionEvent event) {

    }

    @FXML
    void voltaTela(ActionEvent event) throws IOException, SQLException {
        Stage stage = (Stage) xBtn.getScene().getWindow();
        stage.close();
        sceneController sc = new sceneController();
        sc.trocarParaTelaAnotacoes(event,getId(),getId_usuario(),getNome());
    }

}

