package POO.Projetos.SistemaBancario.Dominio;

import POO.Projetos.SistemaBancario.Exceptions.SaldoInsuficienteException;
import POO.Projetos.SistemaBancario.Exceptions.ValorInvalidoException;

public abstract class Conta {
    private int numeroDaConta;
    private Cliente titular;
    private double saldo;
    {
        System.out.println("Nova Conta Criada");
    }
    public Conta(int numeroDaConta, Cliente titular, double saldo) {
        this.numeroDaConta = numeroDaConta;
        this.titular = titular;
        this.saldo = saldo;
    }

    public int getNumeroDaConta() {
        return numeroDaConta;
    }

    public void setNumeroDaConta(int numeroDaConta) {
        this.numeroDaConta = numeroDaConta;
    }

    public Cliente getTitular() {
        return titular;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }


    public void depositar(double valor) throws ValorInvalidoException {
        if(valor<=0){
           throw new ValorInvalidoException("O valor do depósito deve ser maior que zero");
        }
        this.saldo += valor;
    }


    public void sacar(double valor) throws SaldoInsuficienteException, ValorInvalidoException{
        if(valor<=0){
            throw new ValorInvalidoException("O valor do saque deve ser maior que zero");
        }
        if(saldo < valor){
           throw new SaldoInsuficienteException("Saldo insuficiente para realizar o saque desejado");
        }
        this.saldo -= valor;
    }

    public void transferir(Conta destino, double valor) throws SaldoInsuficienteException, ValorInvalidoException{
        this.sacar(valor);
        destino.depositar(valor);
    }

    public void exibirInformacoes(){
        System.out.println("Titular: " + this.titular);
        System.out.println("Número da Conta: " + this.numeroDaConta);
        System.out.println("Saldo: " + this.saldo);
    }

}
