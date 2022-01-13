package application;
<<<<<<< HEAD
import conexaobd.usuario;
=======
import FXMLsControllers.*;

>>>>>>> eb41c93de0c3ada36409c6cf789f7981a899df3f

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
        cadernoDiarioController cadDiCont = fxmlLoader.<cadernoDiarioController>getController();
        cadDiCont.initData(email, nome);
        stage.show();
    }

    public void trocarParaTelaDiarioAnotacao(ActionEvent event,String email,String nome) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/telaEscreverAnotacaoDiario.fxml"));
        root = fxmlLoader.load();
        stage = ((Stage)((Node) event.getSource()).getScene().getWindow());
        scene = new Scene(root);
        stage.setScene(scene);
        telaEscreverAnotacaoDiario cad = fxmlLoader.<telaEscreverAnotacaoDiario>getController();
        cad.initData(email,nome);
        stage.show();
    }
}
