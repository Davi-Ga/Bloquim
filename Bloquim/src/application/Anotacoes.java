package application;

public class Anotacoes {
    private String nome;
    private String conteudo;
    private int id;
    private int id_cadernofk;


    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getId_cadernofk() {
        return id_cadernofk;
    }
    public void setId_cadernofk(int id_cadernofk) {
        this.id_cadernofk = id_cadernofk;
    }
    public String getConteudo() {
        return conteudo;
    }
    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Anotacoes(int id, String nome, String conteudo, int id_cadernofk){
        setId(id);
        setNome(nome);
        setConteudo(conteudo);
        setId_cadernofk(id_cadernofk);
        
    }
}
