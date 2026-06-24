package POO.Projetos.SistemaBancario.Main;

import POO.Projetos.SistemaBancario.Dominio.*;
import POO.Projetos.SistemaBancario.Exceptions.*;

import  java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Banco banco = new Banco();
        int opcao;

        do{
            System.out.println("\n------------------BANCO-------------------------- ");
            System.out.println("1 - Criar Conta Corrente");
            System.out.println("2 - Criar Conta Poupança");
            System.out.println("3 - Depositar");
            System.out.println("4 - Sacar");
            System.out.println("5 - Transferir");
            System.out.println("6 - Ver Extrato");
            System.out.println("0 - Sair");


            System.out.print("Escolha uma opcao: ");
            opcao = lerInteiro(input);

            switch(opcao){
                case 1:
                    try {
                        System.out.print("Digite o nome do titular: ");
                        String titularCC = input.nextLine();
                        System.out.print("Digite o CPF  do titular: ");
                        String titularCPF = input.nextLine();
                        System.out.print("Digite o e-mail do cliente: ");
                        String emailCC = input.nextLine();
                        System.out.print("Digite o número de telefone do titular: ");
                        String telefoneCC = input.nextLine();

                        Cliente clienteCC = new Cliente(titularCC, titularCPF, emailCC, telefoneCC);

                        System.out.print("Digite o número da conta: ");
                        int numeroCC = lerInteiro(input);
                        System.out.print("Digite o saldo inicial da conta: ");
                        double saldoCC = lerDouble(input);
                        System.out.print("Limite da conta: ");
                        double limiteCC = lerDouble(input);

                        ContaCorrente contaCorrente = new ContaCorrente(numeroCC,clienteCC, saldoCC, limiteCC);
                        banco.adicionarConta(contaCorrente);
                        System.out.println("Conta adicionado com sucesso!");
                    }catch (ClienteInvalidoException | ValorInvalidoException | ContaDuplicadaException | CPFDuplicadoException e){
                        System.out.println("Erro ao criar a conta" + e.getMessage());
                    }
                    break;

                case 2:
                    try {
                        System.out.print("Digite o nome do titular: ");
                        String titularCP = input.nextLine();
                        System.out.print("Digite o CPF do titular: ");
                        String titularCPF2 = input.nextLine();
                        System.out.print("Digite o e-mail do titular: ");
                        String emailCP = input.nextLine();
                        System.out.print("Digite o número de telefone do titular: ");
                        String telefoneCP = input.nextLine();

                        Cliente clienteCP = new Cliente(titularCP, titularCPF2, emailCP, telefoneCP);

                        System.out.print("Digite o número da conta: ");
                        int numeroCP = lerInteiro(input);
                        System.out.print("Digite o saldo inicial da conta: ");
                        double saldoCP = lerDouble(input);
                        System.out.print("Taxa de Rendimento: ");
                        double taxaCP = lerDouble(input);

                        ContaPoupanca contaPoupanca = new ContaPoupanca(numeroCP,clienteCP, saldoCP, taxaCP);
                        banco.adicionarConta(contaPoupanca);
                        System.out.println("Conta adicionado com sucesso!");
                    }catch (ClienteInvalidoException | ContaDuplicadaException | CPFDuplicadoException | ValorInvalidoException e){
                        System.out.println("Erro ao criar a conta" + e.getMessage());
                    }
                    break;

                case 3:
                    System.out.print("Digite o número da conta: ");
                    int numeroDeposito  = lerInteiro(input);
                    System.out.print("Quanto deseja depositar: ");
                    double valorDeposito = lerDouble(input);

                    try{
                        Conta contaDeposito = banco.buscarConta(numeroDeposito);
                        contaDeposito.depositar(valorDeposito);
                        System.out.println("Depósito realizado com sucesso!");

                    } catch (ValorInvalidoException | ContaNaoEncontradaException e) {
                        System.out.println(e.getMessage());
                    } catch (Exception e) {
                        System.out.println("Ocorreu um erro ao depositar, tente novamente mais tarde.");
                    }

                    break;
                case 4:
                    System.out.print("Digite o número da conta: ");
                    int numeroSaque = lerInteiro(input);
                    System.out.print("Quanto deseja sacar: ");
                    double valorSaque = lerDouble(input);

                    try{
                        Conta contaSaque = banco.buscarConta(numeroSaque);
                        contaSaque.sacar(valorSaque);
                        System.out.println("Saque realizado com sucesso!");

                    } catch (SaldoInsuficienteException | ValorInvalidoException | ContaNaoEncontradaException e) {
                        System.out.println(e.getMessage());
                    }catch (Exception e) {
                        System.out.println("Ocorreu um erro ao sacar, tente novamente mais tarde");
                    }

                    break;

                case 5:
                    System.out.print("Digite o numero da conta de origem: ");
                    int numeroOrigem = lerInteiro(input);
                   System.out.print("Digite o numero da conta para a qual deseja transferir: ");
                   int numeroDestino = lerInteiro(input);
                   System.out.print("Digite o valor que deseja transferir: ");
                   double valorTransferir = lerDouble(input);
                   if (numeroOrigem == numeroDestino){
                       System.out.println("Não é possivel transferir valores para a mesma conta de origem!");
                       continue;
                   }
                   try{
                       Conta contaOrigem = banco.buscarConta(numeroOrigem);
                       Conta contaDestino = banco.buscarConta(numeroDestino);

                       contaOrigem.transferir(contaDestino, valorTransferir);
                       System.out.println("Transferência realizada com sucesso");
                   } catch (SaldoInsuficienteException | ContaNaoEncontradaException | ValorInvalidoException e) {
                       System.out.println(e.getMessage());
                   } catch (Exception e) {
                       System.out.println("Não foi possível realizar a sua transferência no momento, tente novamente mais tarde!");
                   }

                   break;

                case 6:
                    System.out.print("Digite o número da conta: ");
                    int numeroConta = lerInteiro(input);
                    try{
                        Conta contaExtrato = banco.buscarConta(numeroConta);
                        contaExtrato.exibirExtrato();
                    }catch (ContaNaoEncontradaException e) {
                        System.out.println(e.getMessage());
                    }
                    break;


                case 0:
                    System.out.println("Sistema encerrado!");

                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }while (opcao != 0 );

        input.close();
    }

    private static int lerInteiro(Scanner input){
        while(true){
            try{
                return Integer.parseInt(input.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Digite um número inteiro válido!");
            }
        }
    }

    private static  double lerDouble(Scanner input){
        while(true){
            try{
                return Double.parseDouble(input.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Digite um valor numérico válido");
            }
        }
    }
}
