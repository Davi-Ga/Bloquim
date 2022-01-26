package conexaobd;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
        String senha = criptografia.script(usuariol.getsenha());
        String sql = "INSERT INTO login(nome,senha,email) VALUES (?,?,?);";
        PreparedStatement stnt = conexao.prepareStatement(sql);
        stnt.setString(1, usuariol.getnome());
        stnt.setString(2, senha);
        stnt.setString(3, usuariol.getemail());
        stnt.execute();
        conexao.close(); //Corrigir, não se deve fechar aqui
    }
    

    public void editar (usuario usuarioe) throws SQLException{
        
        
    }
    


    public boolean usuarioExisteNoBanco(usuario usuarioAutenticar) throws SQLException{
        String senha = criptografia.script(usuarioAutenticar.getsenha());
        String sql = "SELECT * FROM login WHERE email = ? and senha = ?";

        PreparedStatement stnt= conexao.prepareStatement(sql);
        stnt.setString(1, usuarioAutenticar.getemail());
        stnt.setString(2, senha);
        stnt.execute();
        
        ResultSet resultSet = stnt.getResultSet();

        return resultSet.next();
    }

    public String pegaNome(usuario usuarioPegaNome) throws SQLException{
        String senha = criptografia.script(usuarioPegaNome.getsenha());
        String sql = "SELECT nome FROM login WHERE email = ? AND senha = ?";
        PreparedStatement stnt= conexao.prepareStatement(sql);
        stnt.setString(1, usuarioPegaNome.getemail());
        stnt.setString(2, senha);
        stnt.execute();
        ResultSet resultSet = stnt.getResultSet();
        resultSet.next();
        String nomeUser = resultSet.getString("nome");
        
        return nomeUser;
    }

    

}

