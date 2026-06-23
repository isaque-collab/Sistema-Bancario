package POO.Projetos.SistemaBancario.Dominio;

import POO.Projetos.SistemaBancario.Exceptions.ContaNaoEncontradaException;

import java.util.ArrayList;

public class Banco {

   private ArrayList<Conta> contas = new ArrayList<>();


    public void adicionarConta(Conta conta){
        contas.add(conta);
    }

    public void listarContas(){
        for(Conta conta : contas){
            conta.exibirInformacoes();
        }
    }

    public Conta buscarConta(int numeroDaConta) throws ContaNaoEncontradaException {

        for(Conta conta : contas){

            if(conta.getNumeroDaConta() == numeroDaConta){
                return conta;
            }
        }
        throw new ContaNaoEncontradaException("Conta não encontrada");
    }
}
