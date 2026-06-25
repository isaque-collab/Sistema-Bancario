package POO.Projetos.SistemaBancario.Dominio;

import POO.Projetos.SistemaBancario.Exceptions.SaldoInsuficienteException;
import POO.Projetos.SistemaBancario.Exceptions.ValorInvalidoException;

import java.io.Serializable;

public class ContaCorrente extends Conta implements Serializable {
    private static final long serialVersionUID = 2L;
    private double limite;

    public ContaCorrente(int numeroDaConta, Cliente titular, double saldo, double limite) throws ValorInvalidoException {

        super(numeroDaConta, titular, saldo);
        if (limite<0){
            throw new ValorInvalidoException("Limite não pode ser negativo");
        }
        this.limite = limite;

    }

    public double getLimite() {
        return limite;
    }
    public void setLimite(double limite) {
        this.limite = limite;
    }


    @Override
    public void sacar(double valor) throws SaldoInsuficienteException, ValorInvalidoException {
        if (valor <= 0) {
            throw new ValorInvalidoException("O valor do saque deve ser maior que zero");
        }



        double maximoPermitido = getSaldo() + limite;

        if (valor > maximoPermitido) {
            throw new SaldoInsuficienteException("Limite para saque excedido");
        }

        setSaldo(getSaldo() - valor);

        registrarTransacao(new Transacao(TipoDeTransacao.SAQUE, valor, getSaldo()));

    }

    public void exibirInformacoes(){
        super.exibirInformacoes();
        System.out.println("Limite da conta: " + limite);
    }

}
