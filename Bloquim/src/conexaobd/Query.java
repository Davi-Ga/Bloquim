package conexaobd;

import application.Anotacoes;
import application.Caderno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
            conexao.close();
        }

        
        return cadList;

    }
    public static void insereCadernos(String nomeCaderno, Integer id_usuario) throws SQLException{
        Connection conexao = new conexaoBancoDeDados().getConnection();
        String sql = "INSERT INTO caderno(nome,id_usuariofk) VALUES (?,?)";
        PreparedStatement stnt = conexao.prepareStatement(sql);
        stnt.setString(1, nomeCaderno);
        stnt.setInt(2, id_usuario);
        // stnt.executeQuery();
        //executa
        stnt.execute();
        conexao.close();
    }

    public static void fecharConexão() throws SQLException{
        Connection conexao = new conexaoBancoDeDados().getConnection();
        conexao.close();
    }


    public static List<Anotacoes> BuscaAnotações(Integer id_caderno) throws SQLException{
        List<Anotacoes> anotList = new ArrayList<Anotacoes>();
        Connection conexao = new conexaoBancoDeDados().getConnection();
        String sql = "SELECT id_anotacoes,nome,conteudo,id_cadernofk FROM anotacoes WHERE id_cadernofk = ?";
        PreparedStatement stnt = conexao.prepareStatement(sql);
        stnt.setInt(1, id_caderno);
        // stnt.executeQuery();
        //executa
        ResultSet resultSet = stnt.executeQuery();
        
        while(resultSet.next()){

            //pegar os dados do registro (por coluna)
            int id_anotacoes = Integer.parseInt(resultSet.getObject(1).toString()) ;
            // System.out.println(id_caderno);
            String nomeAnotacoes = resultSet.getObject(2).toString();
            String conteudo = resultSet.getObject(3).toString();
            int id_cadernofk = Integer.parseInt(resultSet.getObject(4).toString());

            
            //cria objeto do tipo caderno
            Anotacoes anot = new Anotacoes(id_anotacoes, nomeAnotacoes,conteudo ,id_cadernofk);
            //adiciona objeto caderno à lista
            anotList.add(anot);
            conexao.close();

        }
        return anotList;
    }

    public static String pegaConteudoAnot(Integer idAnotacao) throws SQLException{
        Connection conexao = new conexaoBancoDeDados().getConnection();
        String sql = "SELECT conteudo FROM anotacoes WHERE id_anotacoes = ?";
        PreparedStatement stnt= conexao.prepareStatement(sql);
        stnt.setInt(1, idAnotacao);
        stnt.execute();
        ResultSet resultSet = stnt.getResultSet();
        resultSet.next();
        String conteudo = resultSet.getString("conteudo");

        return conteudo;
    }

    public static String pegaNomeAnot(Integer idAnotacao) throws SQLException{
        Connection conexao = new conexaoBancoDeDados().getConnection();
        String sql = "SELECT nome FROM anotacoes WHERE id_anotacoes = ?";
        PreparedStatement stnt= conexao.prepareStatement(sql);
        stnt.setInt(1, idAnotacao);
        stnt.execute();
        ResultSet resultSet = stnt.getResultSet();
        resultSet.next();
        String nome = resultSet.getString("nome");

        return nome;
    }

    public static void insereAnotacao(String nomeAnotacao,String conteudo, Integer id_caderno) throws SQLException{
        Connection conexao = new conexaoBancoDeDados().getConnection();
        String sql = "SELECT (nome,conteudo,id_cadernofk) FROM anotacoes WHERE nome = ? AND conteudo = ? AND id_cadernofk = ?";
        PreparedStatement stnt = conexao.prepareStatement(sql);
        stnt.setString(1, nomeAnotacao);
        stnt.setString(2, conteudo);
        stnt.setInt(3, id_caderno);
        // stnt.executeQuery();
        //executa
        stnt.execute();
        ResultSet resultSet = stnt.getResultSet();
        
        boolean testa = resultSet.next();
            if(testa == false || resultSet == null){
                String sqli = "INSERT INTO anotacoes(nome,conteudo,id_cadernofk) VALUES (?,?,?)";
                PreparedStatement stnti = conexao.prepareStatement(sqli);
                stnti.setString(1, nomeAnotacao);
                stnti.setString(2, conteudo);
                stnti.setInt(3, id_caderno);
                
                stnti.execute();
                conexao.close();


            }else{
                String sqlu = "UPDATE anotacoes SET conteudo = ? WHERE nome = ? AND id_cadernofk = ?";
                PreparedStatement stntu = conexao.prepareStatement(sqlu);
                stntu.setString(1, conteudo);
                stntu.setString(2, nomeAnotacao);
                stntu.setInt(3, id_caderno);

                stntu.execute();
                conexao.close();
                
               
            }
        
        
    }

    public static Integer pegaIDCaderno(Integer id_usuariofk) throws SQLException{
        Connection conexao = new conexaoBancoDeDados().getConnection();
        String sql = "SELECT id_caderno FROM caderno WHERE id_usuariofk = ?";
        PreparedStatement stnt= conexao.prepareStatement(sql);
        stnt.setInt(1, id_usuariofk);
        stnt.execute();
        ResultSet resultSet = stnt.getResultSet();
        resultSet.next();
        Integer idCaderno = resultSet.getInt("id_caderno");

        
        return idCaderno;
    }
    
}
