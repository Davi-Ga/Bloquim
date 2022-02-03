package FXMLsControllers.sistemalogin.cadernos;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class telaAddCaderno {

    protected int id;
    protected String nome;

    @FXML
    private Button cancelaBtn;

    @FXML
    private Button criarBtn;

    @FXML
    private TextField nomeCadernoText;

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
    void cancelaCriarCaderno(ActionEvent event) throws SQLException {
        fecharStage();

    }

    @FXML
    void criaCaderno(ActionEvent event) throws SQLException {
        String nome = nomeCadernoText.getText();
        conexaobd.Query.insereCadernos(nome, getId());
        fecharStage();
    }

    private void fecharStage(){
        Stage stage = (Stage) cancelaBtn.getScene().getWindow();
        stage.close();
    }

}
