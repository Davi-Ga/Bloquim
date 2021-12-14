package validadorDeTexto;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class validadorDeTexto {

    public static boolean verificaNomeUsuario(String nomeUsuario){
        if(!nomeUsuario.isEmpty()){
            return true;
        }
        return false;
    }

    public static boolean validarEmail(String emailText) {
        Boolean resposta = false;
        if(emailText.length()>0 && emailText!=null){
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(emailText);
            if (matcher.matches()) {
                resposta = true;
            }
        }
        return resposta;
    }

    public static boolean validarSenha(String senhaText) {
        boolean resposta = false;
        if(senhaText.length()>8 && senhaText!=null){
            resposta=true;
        }
        return resposta;
    }

    
}

