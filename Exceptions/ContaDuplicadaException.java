package POO.Projetos.SistemaBancario.Exceptions;

public class ContaDuplicadaException extends Exception {
    public ContaDuplicadaException(){
        super("Numero de conta ja cadastrado no sistema");
    }
    public ContaDuplicadaException(String message) {
        super(message);
    }
}
