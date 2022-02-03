package FXMLsControllers.sistemalogin.cadernos;


import java.io.IOException;
import java.lang.reflect.Array;
import java.sql.SQLException;
import java.util.List;

import application.Caderno;
import application.sceneController;
import conexaobd.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.ButtonType;




public class cadernoController {

    protected int id;
    protected String nome;
    
    private int paginaIndice =1;
    private int numPaginasIndice;

    List<Caderno> cadernos; 
    
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
    

    public int getNumPaginasIndice() {
        return numPaginasIndice;
    }

    public void setNumPaginasIndice(int numPaginasIndice) {
        this.numPaginasIndice = numPaginasIndice;
    }

    public int getPaginaIndice() {
        return paginaIndice;
    }

    




    public void initData(int id,String nome) throws SQLException{
        setId(id);
        setNome(nome);
        nomeLabelText.setText(getNome());
        cadernos = conexaobd.Query.BuscaCadernos(getId());
        setNumPaginasIndice((cadernos.size()/8)+1);
        loadCadernos();

        
        
    }

    private void loadCadernos() throws SQLException{
        
        System.out.println("página atual: "+getPaginaIndice());
        System.out.println("Número de páginas: "+getNumPaginasIndice());
        System.out.println("Número de cadernos: "+cadernos.size());
        // setNumPaginasIndice(cadernos.size());
        Button[] btnList ={
            caderno001,
            caderno002,
            caderno003,
            caderno004,
            caderno005,
            caderno006,
            caderno007,
            caderno008
        };
        
        for(int i=0;i<8;i++){
            
            int cadIndice=(getPaginaIndice()-1)*8+i;
            if(cadernos.size()>cadIndice){
                System.out.println("aaaaa");
                btnList[i].setVisible(true);
                btnList[i].setText(cadernos.get(cadIndice).getNome());
            }
            else{
                System.out.println("bbbbb");
                // int btnIndice=i-((getPaginaIndice()-1)*8);
                btnList[i].setVisible(false);
            }
            
        }

        if(getNumPaginasIndice()==getPaginaIndice()){
            proxPaginaBtn.setVisible(false);
        }
        else{
            proxPaginaBtn.setVisible(true);
        }


        if(getPaginaIndice()==1){
            paginaAnteBtn.setVisible(false);
        }
        else{
            paginaAnteBtn.setVisible(true);
        }
        
        
    }

    @FXML
    public void initialize() throws IOException {
       
       //I want to add a button in this function
    } 

    


    

    @FXML
    private Text nomeLabelText;

    @FXML
    private Button paginaAnteBtn;

    @FXML
    private Button proxPaginaBtn;

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

    /*@FXML
    void abreDiario(ActionEvent event) throws IOException {
        mostrarTelaDoDiario(event);
        
    }*/

    @FXML
    void adicionaCadernoNovo(ActionEvent event) throws IOException {
        sceneController sc = new sceneController();
        sc.abreTelaAddCaderno(event);
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
    void proxPagina(ActionEvent event) throws SQLException {
        if((getPaginaIndice())<getNumPaginasIndice()){
            this.paginaIndice++;
        }
        loadCadernos();
    }
    @FXML
    void paginaAnterior(ActionEvent event) throws SQLException {
        if(getPaginaIndice()>1){
            this.paginaIndice--;
        }
        loadCadernos();
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

    /*private void mostrarTelaDoDiario(ActionEvent event) throws IOException{
        fecharStage();
        sceneController sc = new sceneController();
        sc.trocarParaTelaDiario(event,getId(),getNome());
    }*/
    
    private void mostrarTelaDeAnotação(ActionEvent event) throws IOException{
        fecharStage();
        sceneController sc = new sceneController();
        sc.trocarParaTelaAnotacoes(event,getId(),getNome());
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