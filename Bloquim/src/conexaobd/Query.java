package conexaobd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Query {
    private final Connection conexao;

    public Query(String queryText) throws SQLException{
        this.conexao = conexaoBancoDeDados.getConnection();
        try{
            
            PreparedStatement stnt = this.conexao.prepareStatement(queryText);
            stnt.execute();
            this.conexao.close();
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
        

    }

}
