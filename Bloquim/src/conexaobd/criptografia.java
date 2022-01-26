package conexaobd;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class criptografia {
    private static char[] codigoHexa(byte[] text){
        char[] hash = new char[text.length * 2];
        String Stringhexa;
        Integer i;

            for(i=0;i<text.length;i++){
                Stringhexa = "00" + Integer.toHexString(text[i]);
                Stringhexa.toUpperCase().getChars(Stringhexa.length()-2,Stringhexa.length(),hash,i*2);
            }
        return hash;
}

    public static String script(String pwd){
            if(md != null){
                return new String(codigoHexa(md.digest(md.digest(pwd.getBytes()))));
            }
        return null;
    }

    private static MessageDigest md = null;

        static{
            try{
                md = MessageDigest.getInstance("MD5");
            }catch(NoSuchAlgorithmException ex){
                ex.printStackTrace();
            }
        }

 }

