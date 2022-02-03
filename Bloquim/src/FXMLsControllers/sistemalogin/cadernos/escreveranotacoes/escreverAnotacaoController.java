package FXMLsControllers.sistemalogin.cadernos.escreveranotacoes;

import java.io.IOException;
import java.sql.SQLException;
import javafx.scene.control.TextArea;
import application.sceneController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class escreverAnotacaoController {

    private int id;
    private int id_usuario;
    private String nome;
    private String conteudo;

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    
    
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

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
   

    @FXML
    public void initData(int id,int id_usuario, String nome, String conteudo) throws SQLException{
        setId(id);
        setNome(nome);
        setId_usuario(id_usuario);
        setConteudo(conteudo);
    }
    @FXML
    private Button salvaAnotacaoBtn;

    @FXML
    private ScrollBar scrollBar;

    @FXML
    private TextField tituloAnotacao;

    @FXML
    private TextArea conteudoText;

    @FXML
    private Button voltarBtn;

    @FXML
    private Button xBtn;

    @FXML
    void addTituloAnotacao(ActionEvent event) {

    }

    @FXML
    void fechaAba(ActionEvent event) throws IOException, SQLException {
        Alert alertaFecharApp = new Alert(AlertType.CONFIRMATION);
        alertaFecharApp.setHeaderText("Quer mesmo fechar o aplicativo?");
        alertaFecharApp.setContentText("Bloquim sentirá a sua falta.");
        if(alertaFecharApp.showAndWait().get() != ButtonType.OK){
            return;
        }
        else{
            System.exit(0);
            fecharStage();
            sceneController sc = new sceneController();
            sc.trocarParaTelaEscreverAnotacao(event,getId(),getId_usuario(),getNome(),getConteudo());
        }
    }

    @FXML
    void salvaAnotacao(ActionEvent event) throws SQLException, IOException {
        String titulo = tituloAnotacao.getText();
        String conteudo = conteudoText.getText();
        conexaobd.Query.insereAnotacao(titulo, conteudo,getId());
        fecharStage();
        sceneController sc = new sceneController();
        sc.trocarParaTelaAnotacoes(event,getId(),getId_usuario(),getNome());
    }

    @FXML
    void voltaTela(ActionEvent event) throws IOException, SQLException {
        fecharStage();
        sceneController sc = new sceneController();
        sc.trocarParaTelaAnotacoes(event,getId(),getId_usuario(),getNome());
    }

    private void fecharStage(){
        Stage stage = (Stage) xBtn.getScene().getWindow();
        stage.close();
    }

}