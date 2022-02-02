package conexaobd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Query {

    public static void BuscaCadernos(Integer id_usuario) throws SQLException{
        Connection conexao = new conexaoBancoDeDados().getConnection();

        String sql = "SELECT id_caderno,nome FROM caderno as c JOIN login as l ON c.id_usuario=l.id_usuariofk";
        PreparedStatement stnt = conexao.prepareStatement(sql);
        stnt.execute();
    }

}
