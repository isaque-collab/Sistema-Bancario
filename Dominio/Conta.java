package POO.Projetos.SistemaBancario.Dominio;

import POO.Projetos.SistemaBancario.Exceptions.SaldoInsuficienteException;
import POO.Projetos.SistemaBancario.Exceptions.ValorInvalidoException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Conta {
    private int numeroDaConta;
    private Cliente titular;
    private double saldo;
    private List<Transacao> extrato = new ArrayList<>();
    {
        System.out.println("Nova Conta Criada");
    }
    public Conta(int numeroDaConta, Cliente titular, double saldo) throws ValorInvalidoException {
        if (saldo<0){
            throw new ValorInvalidoException("Saldo inicial não pode ser negativo");
        }
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
        extrato.add(new Transacao(TipoDeTransacao.DEPOSITO, valor, this.saldo));
    }


    public void sacar(double valor) throws SaldoInsuficienteException, ValorInvalidoException{
        if(valor<=0){
            throw new ValorInvalidoException("O valor do saque deve ser maior que zero");
        }
        if(saldo < valor){
           throw new SaldoInsuficienteException("Saldo insuficiente para realizar o saque desejado");
        }
        this.saldo -= valor;
        extrato.add(new Transacao(TipoDeTransacao.SAQUE, valor, this.saldo));
    }

    public void transferir(Conta destino, double valor) throws SaldoInsuficienteException, ValorInvalidoException{
        this.sacarInterno(valor);
        extrato.add(new Transacao(TipoDeTransacao.TRANSFERENCIA_ENVIADA, valor, this.saldo));
        destino.depositarInterno(valor);
        destino.extrato.add(new Transacao(TipoDeTransacao.TRANSFERENCIA_RECEBIDA, valor, destino.saldo));
    }

    public void exibirInformacoes(){
        System.out.println("Titular: " + this.titular.getNome());
        System.out.println("Número da Conta: " + this.numeroDaConta);
        System.out.println("Saldo: " + this.saldo);
    }

    public List<Transacao> getExtrato() {
        return Collections.unmodifiableList(extrato);
    }

    public void exibirExtrato(){
        System.out.println("\n=========EXTRATO==========");
        System.out.println("Titular: " + titular.getNome());
        System.out.println("Conta: " + numeroDaConta);
        System.out.println("---------------------------");
        if (extrato.isEmpty()){
            System.out.println("Nenhuma transação foi encontrada");
        }else {
            for (Transacao transacao : extrato){
                System.out.println(transacao);
            }
        }
        System.out.printf("---------------------\nSaldo atual: R$ %.2f%n", saldo);
        System.out.println("========================");
    }

    private void sacarInterno(double valor)throws SaldoInsuficienteException, ValorInvalidoException{
        if (valor<=0){
            throw new ValorInvalidoException("O valor do saque deve ser maior que 0");
        }
        if (saldo < valor){
            throw new SaldoInsuficienteException("Saldo insuficiente para realizar o saque");
        }
        this.saldo -= valor;
    }

    private void depositarInterno(double valor)throws ValorInvalidoException{
        if (valor<=0){
            throw new ValorInvalidoException("O valor do depósito deve ser maior que 0");
        }
        this.saldo += valor;
    }

    protected void registrarTransacao(Transacao transacao){
        extrato.add(transacao);
    }

}
