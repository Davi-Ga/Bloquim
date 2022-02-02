package conexaobd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class Query {

    public static void BuscaCadernos(Integer id_usuario) throws SQLException{
        Connection conexao = new conexaoBancoDeDados().getConnection();
        String sql = "SELECT id_caderno,nome FROM caderno WHERE id_usuariofk = ?";
        PreparedStatement stnt = conexao.prepareStatement(sql);
        stnt.setInt(1, id_usuario);
        stnt.execute();
        ResultSet resultSet = stnt.getResultSet();
        resultSet.next();
    }

}
