import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class App extends Application{
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/Login.fxml"));
        Parent root = fxmlLoader.load();
        Scene tela = new Scene(root);
        primaryStage.setScene(tela);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();
    
    }

}
