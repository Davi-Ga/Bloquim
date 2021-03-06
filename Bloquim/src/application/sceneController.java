package application;
import FXMLsControllers.sistemalogin.cadernos.anotacaoController;
import FXMLsControllers.sistemalogin.cadernos.cadernoController;
import FXMLsControllers.sistemalogin.cadernos.escreveranotacoes.escreverAnotacaoController;
import java.io.IOException;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public  class sceneController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void trocarTelaCadastro(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/telacadastro.fxml"));
        root = fxmlLoader.load();
        stage = ((Stage)((Node) event.getSource()).getScene().getWindow());
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // public void abreTelaAddCaderno(ActionEvent event) throws IOException{
    //     FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/telaAddCaderno.fxml"));
    //     root = fxmlLoader.load();
    //     stage = ((Stage)((Node) event.getSource()).getScene().getWindow());
    //     scene = new Scene(root);
    //     stage.setScene(scene);
    //     stage.show();
    // }
    
    public void trocarParaTelaLogin(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/Login.fxml"));
        root = fxmlLoader.load();
        stage = ((Stage)((Node) event.getSource()).getScene().getWindow());
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void trocarParaTelaCaderno(ActionEvent event,int id,String nome) throws IOException, SQLException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/telaCaderno.fxml"));
        root = fxmlLoader.load();
    
        stage = ((Stage)((Node) event.getSource()).getScene().getWindow());
        scene = new Scene(root);
        stage.setScene(scene);
        cadernoController cad = fxmlLoader.<cadernoController>getController();
        cad.initData(id,nome);
        stage.show();
    }

    public void trocarParaTelaAnotacoes(ActionEvent event,int id,int id_usuario,String nome) throws IOException, SQLException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/telaAnotacoes.fxml"));
        root = fxmlLoader.load();
        stage = ((Stage)((Node) event.getSource()).getScene().getWindow());
        scene = new Scene(root);
        stage.setScene(scene);
        anotacaoController anot = fxmlLoader.<anotacaoController>getController();
        anot.initData(id,id_usuario,nome);
        stage.show();
    }
    
    /*public void trocarParaTelaDiario(ActionEvent event,int id,String nome) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/telaCadernoDiario.fxml"));
        root = fxmlLoader.load();
        stage = ((Stage)((Node) event.getSource()).getScene().getWindow());
        scene = new Scene(root);
        stage.setScene(scene);
        diarioController cadDiCont = fxmlLoader.<diarioController>getController();
        cadDiCont.initData(id, nome);
        stage.show();
    }*/

    /*public void trocarParaTelaEscreverAnotacaoDiario(ActionEvent event,int id,String nome) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/telaEscreverAnotacaoDiario.fxml"));
        root = fxmlLoader.load();
        stage = ((Stage)((Node) event.getSource()).getScene().getWindow());
        scene = new Scene(root);
        stage.setScene(scene);
        escreverAnotacaoDiarioController cad = fxmlLoader.<escreverAnotacaoDiarioController>getController();
        cad.initData(id,nome);
        stage.show();
    }*/

    public void trocarParaTelaEscreverAnotacao(ActionEvent event,int id,int id_usuario,String nome,String conteudo) throws IOException, SQLException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/telaEscreverAnotacao.fxml"));
        root = fxmlLoader.load();
        stage = ((Stage)((Node) event.getSource()).getScene().getWindow());
        scene = new Scene(root);
        stage.setScene(scene);
        escreverAnotacaoController cad = fxmlLoader.<escreverAnotacaoController>getController();
        cad.initData(id,id_usuario,nome,conteudo);
        stage.show();
    }
    
}
