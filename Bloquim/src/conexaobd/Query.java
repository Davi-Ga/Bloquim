package conexaobd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Query {
    static Connection conexao;

    public static void BuscaCaderno(String id_usuario) throws SQLException{
       // conexao = conexaoBancoDeDados.getConnection();

        String sql = "SELECT id_caderno,nome,anotacoes FROM caderno WHERE ";
        PreparedStatement stnt = conexao.prepareStatement(sql);
        stnt.execute();
    }

}
