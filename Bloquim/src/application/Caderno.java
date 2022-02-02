package application;

public class Caderno {
    private String nome;
    private int id;
    private int id_usuario;


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
    public int getId_usuario() {
        return id_usuario;
    }
    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Caderno(int id, String nome, int id_usuario){
        setId(id);
        setNome(nome);
        setId_usuario(id_usuario);
    }
}
