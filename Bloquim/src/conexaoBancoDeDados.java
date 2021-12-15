import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexaoBancoDeDados{

    public Connection getConnection() throws SQLException{
        Connection conexaoBancoDeDados = DriverManager.getConnection("jdbc:postgresql://db-bloquim.postgres.uhserver.com:5432/db_bloquim","adminbloquim","kyntra93791@");
        return conexaoBancoDeDados;
    }
}
/*String usuario = nomeTextBox.getText();
            String senha = senhaTextBox.getText();
            String email = emailTextBox.getText();

            Connection conexaoBD = new conexaoBancoDeDados().getConnection();
            String sql = "INSERT INTO login(usuario,senha,email) VALUES ('";
            String valores = usuario+"','"+senha+"','"+email+"'); ";
            String cadastroEnviado = sql + valores;

            PreparedStatement stnt= conexaoBD.prepareStatement(cadastroEnviado);
            stnt.execute();

            conexaoBD.close();*/

