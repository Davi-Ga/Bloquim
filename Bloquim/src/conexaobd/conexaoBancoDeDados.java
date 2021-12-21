package conexaobd;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexaoBancoDeDados{

    public Connection getConnection() throws SQLException{
        Connection conexaoBancoDeDados = DriverManager.getConnection("jdbc:postgresql://db-bloquim.postgres.uhserver.com:5432/db_bloquim","adminbloquim","kyntra93791@");
        return conexaoBancoDeDados;
    }
}
