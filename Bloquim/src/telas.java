import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class telas {
    
    public void mostraTelaLogin() throws Exception {
        //FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/telaAnotacao.fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/Login.fxml"));
        Stage login = new Stage();
        Parent root = fxmlLoader.load();
        Scene tela = new Scene(root);
        login.setScene(tela);
        login.initStyle(StageStyle.UNDECORATED);
        login.show();
    }
    
}
