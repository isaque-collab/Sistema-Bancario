package POO.Projetos.SistemaBancario.Utils;

public class ValidadorEmail {
    public static boolean isEmail(String email){
        if (email == null || email.isBlank()) return false;
        return email.matches("^[\\w._%+\\-]+@[\\w.\\-]+\\.[a-zA-Z]{2,}$");
    }
}
