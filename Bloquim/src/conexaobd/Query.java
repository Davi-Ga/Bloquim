package conexaobd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Query {
    private final static Connection conexao;

    public Query(Connection conexao){
        this.conexao = conexao;
    }
    
    public static void BuscaCaderno(String id_usuario){
        PreparedStatement stnt = conexao.prepareStatement(sql)
        stnt.execute();
    }

}
