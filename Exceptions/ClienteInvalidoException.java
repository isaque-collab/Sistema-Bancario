package POO.Projetos.SistemaBancario.Exceptions;

public class ClienteInvalidoException extends Exception {
    public ClienteInvalidoException() {
        super("Dados do cliente inválidos");
    }
    public ClienteInvalidoException(String message) {
        super(message);
    }
}
