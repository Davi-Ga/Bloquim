package conexaobd;

import application.Caderno;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Query {

    public static List<Caderno> BuscaCadernos(Integer id_usuario) throws SQLException{
        //Criar lista vazia de cadernos
        List<Caderno> cadList = new ArrayList<Caderno>();
        Connection conexao = new conexaoBancoDeDados().getConnection();
        String sql = "SELECT id_caderno,nome,id_usuariofk FROM caderno WHERE id_usuariofk = ?";
        PreparedStatement stnt = conexao.prepareStatement(sql);
        stnt.setInt(1, id_usuario);
        // stnt.executeQuery();
        //executa
        ResultSet resultSet = stnt.executeQuery();
        
        //enquanto estiver encontrando próximas linhas
        while(resultSet.next()){

            //pegar os dados do registro (por coluna)
            int id_caderno = Integer.parseInt(resultSet.getObject(1).toString()) ;
            // System.out.println(id_caderno);
            String nomeCaderno = resultSet.getObject(2).toString();
            int id_usuariofk = Integer.parseInt(resultSet.getObject(3).toString());

            
            //cria objeto do tipo caderno
            Caderno cad = new Caderno(id_caderno, nomeCaderno, id_usuariofk);
            //adiciona objeto caderno à lista
            cadList.add(cad);
            
        }

        
        return cadList;

    }
    public static void insereCadernos(String nomeCaderno, Integer id_usuario) throws SQLException{
        Connection conexao = new conexaoBancoDeDados().getConnection();
        String sql = "INSERT INTO cadernos(nome,id_usuariofk) VALUES = (?,?)";
        PreparedStatement stnt = conexao.prepareStatement(sql);
        stnt.setString(1, nomeCaderno);
        stnt.setInt(2, id_usuario);
        // stnt.executeQuery();
        //executa
        stnt.execute();
    }


    public static String BuscaAnotações(Integer id_caderno) throws SQLException{
        Connection conexao = new conexaoBancoDeDados().getConnection();
        String sql = "SELECT id_anotacoes,nome,conteúdo,id_cadernofk FROM anotacoes WHERE id_cadernofk = ?";
        PreparedStatement stnt = conexao.prepareStatement(sql);
        stnt.setInt(1, id_caderno);
        // stnt.executeQuery();
        //executa
        ResultSet resultSet = stnt.executeQuery();
        
        while(resultSet.next()){






        }
        return sql;
    }
}
