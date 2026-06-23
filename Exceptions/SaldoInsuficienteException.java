package POO.Projetos.SistemaBancario.Exceptions;

public class SaldoInsuficienteException extends Exception {

    public SaldoInsuficienteException() {
        super("Saldo insuficiente");
    }

    public SaldoInsuficienteException(String message) {
        super(message);
    }
}
