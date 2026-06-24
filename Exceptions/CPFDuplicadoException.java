package POO.Projetos.SistemaBancario.Exceptions;

public class CPFDuplicadoException extends Exception {
    public CPFDuplicadoException(){
        super("CPF já cadastrado no sistema");
    }
    public CPFDuplicadoException(String message) {
        super(message);
    }
}
