package POO.Projetos.SistemaBancario.Exceptions;

public class ValorInvalidoException extends Exception {

    public ValorInvalidoException() {
        super("Valor digitado invalido");
    }

    public ValorInvalidoException(String message) {
        super(message);
    }
}
