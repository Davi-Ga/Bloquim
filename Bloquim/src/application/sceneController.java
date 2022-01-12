package application;
import FXMLsControllers.*;
import conexaobd.usuario;

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

    
    public void trocarParaTelaLogin(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/Login.fxml"));
        root = fxmlLoader.load();
        stage = ((Stage)((Node) event.getSource()).getScene().getWindow());
        scene = new Scene(root);
        stage.setScene(scene);
        
        stage.show();
    }
    public void trocarParaTelaCaderno(ActionEvent event,String email) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/telaCaderno.fxml"));
        root = fxmlLoader.load();
        stage = ((Stage)((Node) event.getSource()).getScene().getWindow());
        scene = new Scene(root);
        stage.setScene(scene);
        cadernoController cad = fxmlLoader.<cadernoController>getController();
        cad.initData(email);
        stage.show();
    }

    public void trocarParaTelaAnotacoes(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/telaAnotacoes.fxml"));
        root = fxmlLoader.load();
        stage = ((Stage)((Node) event.getSource()).getScene().getWindow());
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    public void trocarParaTelaDiario(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/telaCadernoDiario.fxml"));
        root = fxmlLoader.load();
        stage = ((Stage)((Node) event.getSource()).getScene().getWindow());
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void trocarParaTelaDiarioAnotacao(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/telaEscreverAnotacaoDiario.fxml"));
        root = fxmlLoader.load();
        stage = ((Stage)((Node) event.getSource()).getScene().getWindow());
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
