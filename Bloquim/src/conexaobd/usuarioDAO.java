package conexaobd;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class usuarioDAO {

    private final Connection conexao;

    public usuarioDAO(Connection conexao){
        this.conexao = conexao;
    }

    public void inserir(usuario usuariol){
    
            
        String sql = "INSERT INTO login(usuario,senha,email) VALUES ('"+usuariol.getnome()+"','"+usuariol.getsenha()+"','"+usuariol.getemail()+"');";
        PreparedStatement stnt= conexao.prepareStatement(sql);
        stnt.execute();
        conexao.close();
    }
}
,