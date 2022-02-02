package application;
import conexaobd.usuario;
import FXMLsControllers.*;
import FXMLsControllers.sistemalogin.cadernos.anotacaoController;
import FXMLsControllers.sistemalogin.cadernos.anotacaoDiarioController;
import FXMLsControllers.sistemalogin.cadernos.cadernoController;
import FXMLsControllers.sistemalogin.cadernos.escreveranotacoes.escreverAnotacaoDiarioController;

import java.io.IOException;
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
    
    public void trocarParaTelaLogin(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/Login.fxml"));
        root = fxmlLoader.load();
        stage = ((Stage)((Node) event.getSource()).getScene().getWindow());
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void trocarParaTelaCaderno(ActionEvent event,String email,String nome) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/telaCaderno.fxml"));
        root = fxmlLoader.load();
        stage = ((Stage)((Node) event.getSource()).getScene().getWindow());
        scene = new Scene(root);
        stage.setScene(scene);
        cadernoController cad = fxmlLoader.<cadernoController>getController();
        cad.initData(email,nome);
        stage.show();
    }

    public void trocarParaTelaAnotacoes(ActionEvent event,String email,String nome) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/telaAnotacoes.fxml"));
        root = fxmlLoader.load();
        stage = ((Stage)((Node) event.getSource()).getScene().getWindow());
        scene = new Scene(root);
        stage.setScene(scene);
        anotacaoController anot = fxmlLoader.<anotacaoController>getController();
        anot.initData(email,nome);
        stage.show();
    }
    
    public void trocarParaTelaDiario(ActionEvent event,String email,String nome) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/telaCadernoDiario.fxml"));
        root = fxmlLoader.load();
        stage = ((Stage)((Node) event.getSource()).getScene().getWindow());
        scene = new Scene(root);
        stage.setScene(scene);
        anotacaoDiarioController cadDiCont = fxmlLoader.<anotacaoDiarioController>getController();
        cadDiCont.initData(email, nome);
        stage.show();
    }

    public void trocarParaTelaEscreverAnotacaoDiario(ActionEvent event,String email,String nome) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/telaEscreverAnotacaoDiario.fxml"));
        root = fxmlLoader.load();
        stage = ((Stage)((Node) event.getSource()).getScene().getWindow());
        scene = new Scene(root);
        stage.setScene(scene);
        escreverAnotacaoDiarioController cad = fxmlLoader.<escreverAnotacaoDiarioController>getController();
        cad.initData(email,nome);
        stage.show();
    }

    public void trocarParaTelaEscreverAnotacao(ActionEvent event,String email,String nome) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/telaEscreverAnotacao.fxml"));
        root = fxmlLoader.load();
        stage = ((Stage)((Node) event.getSource()).getScene().getWindow());
        scene = new Scene(root);
        stage.setScene(scene);
        escreverAnotacaoDiarioController cad = fxmlLoader.<escreverAnotacaoDiarioController>getController();
        cad.initData(email,nome);
        stage.show();
    }
}
