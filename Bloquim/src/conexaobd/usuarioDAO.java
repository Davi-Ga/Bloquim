package conexaobd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;

public class usuarioDAO {

    private final Connection conexao;

    public usuarioDAO(Connection conexao){
        this.conexao = conexao;
    }

    public void inserir(usuario usuariol) throws SQLException{
    
            
        String sql = "INSERT INTO login(nome,senha,email) VALUES ('"+usuariol.getnome()+"','"+usuariol.getsenha()+"','"+usuariol.getemail()+"');";
        PreparedStatement stnt= conexao.prepareStatement(sql);
        stnt.execute();
        conexao.close(); //Corrigir, não se deve fechar aqui

    }
    

    public void editar (usuario usuarioe) throws SQLException{
        
        
    }


    public boolean usuarioExisteNoBanco(usuario usuarioAutenticar) throws SQLException {
        
        String sql = "SELECT * FROM login WHERE email ='"+usuarioAutenticar.getemail()+"' AND senha = '"+usuarioAutenticar.getsenha()+"'";
        PreparedStatement stnt= conexao.prepareStatement(sql);
        stnt.execute();
        
        ResultSet resultSet = stnt.getResultSet();

         
        return resultSet.next();

    }

}