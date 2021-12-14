import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.spi.DirStateFactory.Result;

public class factoryBancoDeDados{
    private static final String nomedb = "db_bloquim";
    private static final String usuariodb = "adminbloquim";
    private static final String senhadb = "kyntra93791@";
    private static final String url = "db-bloquim.postgres.uhserver.com" + nomedb;
    private static final String driver = "com.mysql.cj.jdbc.Driver";

    public Connection bdLink;       
    public static Connection getConnection(){

        try{
            Class.forName(driver);
            return DriverManager.getConnection(url, usuariodb, senhadb);

            }catch(ClassNotFoundException | SQLException ex){
                throw new RuntimeException("Erro ao conectar-se ao Banco de Dados");
            }
}

public static void closeConnection(Connection con, PreparedStatement stnt,ResultSet rs){

    closeConnection(con,stnt,rs);
    
        try{
            if(stnt!=null){
                rs.close();
            }

                }catch(SQLException ex){
                    Logger.getLogger(factoryBancoDeDados.class.getName()).log(Level.SEVERE,null,ex);
                }
    }
}