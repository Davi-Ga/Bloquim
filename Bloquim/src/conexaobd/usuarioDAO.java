package conexaobd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class usuarioDAO {

    private final Connection conexao;

    public usuarioDAO(Connection conexao){
        this.conexao = conexao;
    }

    public void inserir(usuario usuariol) throws SQLException{
    
        String sql = "INSERT INTO login(nome,senha,email) VALUES ('"+usuariol.getnome()+"','"+usuariol.getsenha()+"','"+usuariol.getemail()+"');";
        PreparedStatement stnt = conexao.prepareStatement(sql);
        stnt.execute();
        conexao.close(); //Corrigir, não se deve fechar aqui
    }
    

    public void editar (usuario usuarioe) throws SQLException{
        
        
    }
    


    public boolean usuarioExisteNoBanco(usuario usuarioAutenticar) throws SQLException{
        
        String sql = "SELECT * FROM login WHERE email ='"+usuarioAutenticar.getemail()+"' AND senha = '"+usuarioAutenticar.getsenha()+"'";
        PreparedStatement stnt= conexao.prepareStatement(sql);
        stnt.execute();
        
        ResultSet resultSet = stnt.getResultSet();
        //String nomeUser = resultSet.getString("nome"); teste fácil
        

        return resultSet.next();
    }

    public String pegaNome(usuario usuarioPegaNome) throws SQLException{
        String sql = "SELECT nome FROM login WHERE email ='"+usuarioPegaNome.getemail()+"' AND senha = '"+usuarioPegaNome.getsenha()+"'";
        PreparedStatement stnt= conexao.prepareStatement(sql);
        stnt.execute();
        ResultSet resultSet = stnt.getResultSet();
        resultSet.next();
        String nomeUser = resultSet.getString("nome");
        
        return nomeUser;
    }

    


}