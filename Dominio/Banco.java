package POO.Projetos.SistemaBancario.Dominio;

import POO.Projetos.SistemaBancario.Exceptions.CPFDuplicadoException;
import POO.Projetos.SistemaBancario.Exceptions.ContaDuplicadaException;
import POO.Projetos.SistemaBancario.Exceptions.ContaNaoEncontradaException;
import POO.Projetos.SistemaBancario.Utils.Formatador;

import java.io.Serializable;
import java.util.HashMap;

public class Banco implements Serializable {
    private static final long serialVersionUID = 6L;
    private HashMap<Integer, Conta> contas = new HashMap<>();


    public void adicionarConta(Conta conta) throws ContaDuplicadaException, CPFDuplicadoException {
        if (contas.containsKey(conta.getNumeroDaConta())){
            throw new ContaDuplicadaException();
        }
        for (Conta c : contas.values()){
            if (c.getTitular().getCpf().equals(conta.getTitular().getCpf())){
                throw new CPFDuplicadoException();
            }
        }
        contas.put(conta.getNumeroDaConta(), conta);
    }

    public void listarContas(){
        if (contas.isEmpty()){
            System.out.println("Nenhuma conta cadastrada");
            return;
        }

        for (Conta c : contas.values()){
            Formatador.exibirConta(c);
        }
    }

    public Conta buscarConta(int numeroDaConta) throws ContaNaoEncontradaException {
        Conta conta = contas.get(numeroDaConta);
        if (conta == null){
            throw new ContaNaoEncontradaException();
        }
        return conta;
    }
}
