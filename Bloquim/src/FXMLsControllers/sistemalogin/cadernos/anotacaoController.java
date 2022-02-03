package FXMLsControllers.sistemalogin.cadernos;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import application.Anotacoes;
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
    private int id_usuario;
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


    private int paginaIndice =1;
    private int numPaginasIndice;
    
    




    List<Anotacoes> anotacoes; 

    public int getNumPaginasIndice() {
        return numPaginasIndice;
    }

    public void setNumPaginasIndice(int numPaginasIndice) {
        this.numPaginasIndice = numPaginasIndice;
    }

    public int getPaginaIndice() {
        return paginaIndice;
    }
    


    @FXML
    public void initData(int id, int id_usuario, String nome) throws SQLException{
        setId(id);
        setNome(nome);
        setId_usuario(id_usuario);
        nomeCadernoAnotacao.setText(getNome());
        anotacoes = conexaobd.Query.BuscaAnotações(getId());
        //setNumPaginasIndice((anotacoes.size()/8)+1);
        System.out.println("id_caderno = "+getId());
        loadAnotacoes();
    }
    private void loadAnotacoes() throws SQLException{
        
        System.out.println("página atual: "+getPaginaIndice());
        System.out.println("Número de páginas: "+getNumPaginasIndice());
        System.out.println("Número de cadernos: "+anotacoes.size());
        setNumPaginasIndice(anotacoes.size());
        Button[] btnList ={
            anotacao1,
            anotacao2,
            anotacao3,
            anotacao4,
            anotacao5,
            anotacao6,
            anotacao7,
            anotacao8
        };
            for(int i=0;i<8;i++){
                
                int anotIndice=(getPaginaIndice()-1)*8+i;
                if(anotacoes.size()>anotIndice){
                    btnList[i].setVisible(true);
                    btnList[i].setText(anotacoes.get(anotIndice).getNome());
                }
                else{
                    
                    btnList[i].setVisible(false);
                }
            }
        if(getNumPaginasIndice()==getPaginaIndice()){
            paginaProxBtn.setVisible(false);
        }
        else{
            paginaProxBtn.setVisible(true);
        }

        if(getPaginaIndice()==1){
            antePagBtn.setVisible(false);
        }
        else{
            antePagBtn.setVisible(true);
        }
                
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
    private Button antePagBtn;

    @FXML
    private Button paginaProxBtn;

    @FXML
    private Text nomeCadernoAnotacao;

    @FXML
    private Button voltarBtn;

    @FXML
    private Button xBtn;

    @FXML
    void adicionaAnotacao(ActionEvent event) throws IOException, SQLException {
        novaAnotacao(event);
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
    void verAnotacao1(ActionEvent event) throws IOException, SQLException {
        mostrarTelaDeAnotação(event,1);
        

    }
    @FXML
    void verAnotacao2(ActionEvent event) throws IOException, SQLException {
        mostrarTelaDeAnotação(event,2);
    }

    @FXML
    void verAnotacao3(ActionEvent event) throws IOException, SQLException {
        mostrarTelaDeAnotação(event,3);
    }

    @FXML
    void verAnotacao4(ActionEvent event) throws IOException, SQLException {
        mostrarTelaDeAnotação(event,4);
    }

    @FXML
    void verAnotacao5(ActionEvent event) throws IOException, SQLException {
        mostrarTelaDeAnotação(event,5);
    }

    @FXML
    void verAnotacao6(ActionEvent event) throws IOException, SQLException {
        mostrarTelaDeAnotação(event,6);
    }

    @FXML
    void verAnotacao7(ActionEvent event) throws IOException, SQLException {
        mostrarTelaDeAnotação(event,7);
    }

    @FXML
    void verAnotacao8(ActionEvent event) throws IOException, SQLException {
        mostrarTelaDeAnotação(event,8);
    }

    @FXML
    void anteriorPag(ActionEvent event) throws SQLException {
        if(getPaginaIndice()>1){
            this.paginaIndice--;
        }
        loadAnotacoes();
    }
    
    @FXML
    void proximaPag(ActionEvent event) throws SQLException {
        if((getPaginaIndice())<getNumPaginasIndice()){
            this.paginaIndice++;
        }
        loadAnotacoes();
    }

    @FXML
    void voltaTela(ActionEvent event) throws IOException, SQLException {
        mostrarTelaCaderno(event);
    }

    private void mostrarTelaCaderno(ActionEvent event) throws IOException, SQLException{
        fecharStage();
        sceneController sc = new sceneController();
        sc.trocarParaTelaCaderno(event,getId_usuario(),getNome()); 
    }


    private void fecharStage(){
        Stage stage = (Stage) xBtn.getScene().getWindow();
        stage.close();
    }
 
    void novaAnotacao(ActionEvent event) throws IOException, SQLException{
        fecharStage();
        sceneController sc = new sceneController();
        sc.trocarParaTelaEscreverAnotacao(event,getId(),getId_usuario(),getNome(),getConteudo());
        System.out.println(nome);
    }

    private void mostrarTelaDeAnotação(ActionEvent event,int numBtn) throws IOException, SQLException{
        fecharStage();
        int cadId = ((getPaginaIndice()-1)*8)+numBtn;
        sceneController sc = new sceneController();
        sc.trocarParaTelaEscreverAnotacao(event,cadId,getId(),getNome(),getConteudo());
    }
}
