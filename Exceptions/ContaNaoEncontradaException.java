package POO.Projetos.SistemaBancario.Exceptions;

public class ContaNaoEncontradaException extends RuntimeException {

    public ContaNaoEncontradaException() {
        super("Conta não encontrda");
    }

    public ContaNaoEncontradaException(String message) {
        super(message);
    }
}
