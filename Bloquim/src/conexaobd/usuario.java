package conexaobd;

public class usuario {
    private String nome;
    private String senha;
    private String email;

        public usuario(String nome, String senha, String email){
            this.nome = nome;
            this.senha = senha;
            this.email = email;
           
        }
        public usuario(String email, String senha){
            this.senha = senha;
            this.email = email;
        } 

        public usuario(String nome){
            this.nome = nome;
        } 
        public String getnome(){
            return nome;
        }
        public void setnome (String nome){
            this.nome = nome;
        }


        public String getsenha(){
            return senha;
        }
        public void setsenha(String senha){
            this.senha = senha;
        }


        public String getemail(){
            return email;
        }
        public void setemail(String email){
            this.email = email;
        }



}      