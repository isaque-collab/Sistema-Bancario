package POO.Projetos.SistemaBancario.Exceptions;

public class ContaNaoEncontradaException extends Exception {

    public ContaNaoEncontradaException() {
        super("Conta não encontrada");
    }

    public ContaNaoEncontradaException(String message) {
        super(message);
    }
}
