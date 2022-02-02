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
    
    private int paginaIndice =1;
    private int numPaginasIndice;
    


    public int getNumPaginasIndice() {
        return numPaginasIndice;
    }

    public void setNumPaginasIndice(int numPaginasIndice) {
        this.numPaginasIndice = numPaginasIndice;
    }

    public int getPaginaIndice() {
        return paginaIndice;
    }

    public void proximaPagina() throws SQLException{
        if(getPaginaIndice()<getNumPaginasIndice()){
            this.paginaIndice++;
        }
        loadCadernos();
    }




    protected String nome;

    public void initData(int id,String nome) throws SQLException{
        setId(id);
        setNome(nome);
        nomeLabelText.setText(getNome());

        loadCadernos();

        
        
    }

    private void loadCadernos() throws SQLException{
        List<Caderno> cadernos=  conexaobd.Query.BuscaCadernos(getId());
        
        setNumPaginasIndice(cadernos.size());
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
        System.out.println(cadernos.get(0).getNome());
        for(int i=((getPaginaIndice()-1)*8);i<((getPaginaIndice())*8);i++){
            int cadIndice=(getPaginaIndice()-1)*8+i;
            if(cadernos.size()>cadIndice){
                btnList[i].setText(cadernos.get(cadIndice).getNome());
            }
            else{
                btnList[i].setVisible(false);
            }
            
        }

        
        
    }

    @FXML
    public void initialize() throws IOException {
       
       //I want to add a button in this function
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


    

    @FXML
    private Text nomeLabelText;

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
    void adicionaCadernoNovo(ActionEvent event) {

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