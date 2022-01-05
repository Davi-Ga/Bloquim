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

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/telaCaderno.fxml"));
        Parent root = fxmlLoader.load();
        Scene tela = new Scene(root);
        primaryStage.setScene(tela);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();
<<<<<<< HEAD
    
        
=======

>>>>>>> fa9b3541668fe8a2c2a763913440fe81a8541ad8
    }

}



