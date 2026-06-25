package POO.Projetos.SistemaBancario.Utils;

import POO.Projetos.SistemaBancario.Dominio.Conta;
import POO.Projetos.SistemaBancario.Dominio.ContaCorrente;
import POO.Projetos.SistemaBancario.Dominio.ContaPoupanca;
import POO.Projetos.SistemaBancario.Dominio.Transacao;

import java.util.List;

public class Formatador {

    private static final int LARGURA = 118;
    private static final String LINHA_TOPO    = "╔" + "═".repeat(LARGURA) + "╗";
    private static final String LINHA_MEIO    = "╠" + "═".repeat(LARGURA) + "╣";
    private static final String LINHA_FUNDO   = "╚" + "═".repeat(LARGURA) + "╝";
    private static final String LINHA_SIMPLES = "║" + " ".repeat(LARGURA) + "║";

    // ─── Menu ────────────────────────────────────────────────────────────────

    public static void exibirMenu() {
        System.out.println(LINHA_TOPO);
        System.out.println(centralizar("SISTEMA BANCÁRIO"));
        System.out.println(LINHA_FUNDO);
        System.out.println();
        System.out.println("  1 - Criar Conta Corrente");
        System.out.println("  2 - Criar Conta Poupança");
        System.out.println("  3 - Depositar");
        System.out.println("  4 - Sacar");
        System.out.println("  5 - Transferir");
        System.out.println("  6 - Ver Extrato");
        System.out.println("  7 - Listar Contas");
        System.out.println("  8 - Buscar Conta");
        System.out.println("  0 - Sair");
        System.out.println();
    }

    // ─── Conta ───────────────────────────────────────────────────────────────

    public static void exibirConta(Conta conta) {
        String tipo;
        String extra;

        if (conta instanceof ContaCorrente cc) {
            tipo  = "[CC] Conta Corrente";
            extra = String.format("Limite: R$ %,.2f", cc.getLimite());
        } else if (conta instanceof ContaPoupanca cp) {
            tipo  = "[CP] Conta Poupança";
            extra = String.format("Taxa: %.2f%%", cp.getTaxaDeRendimento());
        } else {
            tipo  = "Conta";
            extra = "";
        }

        String linha = String.format("  %-20s │  Conta: %-6d │  Titular: %-30s │  Saldo: R$ %,12.2f  │  %s",
                tipo,
                conta.getNumeroDaConta(),
                conta.getTitular().getNome(),
                conta.getSaldo(),
                extra);

        System.out.println(LINHA_TOPO);
        System.out.printf("║ %-" + LARGURA + "s║%n", linha);
        System.out.println(LINHA_FUNDO);
    }

    // ─── Extrato ─────────────────────────────────────────────────────────────

    public static void exibirExtrato(Conta conta) {
        List<Transacao> transacoes = conta.getExtrato();

        System.out.println(LINHA_TOPO);
        System.out.println(centralizar("EXTRATO — Conta " + conta.getNumeroDaConta()
                + " │ " + conta.getTitular().getNome()));
        System.out.println(LINHA_MEIO);

        if (transacoes.isEmpty()) {
            System.out.println(centralizar("Nenhum lançamento encontrado."));
        } else {
            for (Transacao t : transacoes) {
                String linha = String.format("  %s  │  %-24s │  Valor: R$ %,12.2f  │  Saldo após: R$ %,12.2f",
                        t.getDataHora().format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")),
                        traduzirTipo(t.getTipo().toString()),
                        t.getValor(),
                        t.getSaldoDepois());
                System.out.printf("║ %-" + LARGURA + "s║%n", linha);
            }
        }

        System.out.println(LINHA_MEIO);
        System.out.println(centralizar(String.format("Saldo atual: R$ %,.2f", conta.getSaldo())));
        System.out.println(LINHA_FUNDO);
    }

    // ─── Helpers ─────────────────────────────────────────────────────────────

    private static String centralizar(String texto) {
        int padding = (LARGURA - texto.length()) / 2;
        String padded = " ".repeat(Math.max(padding, 0)) + texto;
        return String.format("║%-" + LARGURA + "s║", padded);
    }

    private static String traduzirTipo(String tipo) {
        return switch (tipo) {
            case "DEPOSITO"               -> "DEPÓSITO";
            case "SAQUE"                  -> "SAQUE";
            case "TRANSFERENCIA_ENVIADA"  -> "TRANSFERÊNCIA ENVIADA";
            case "TRANSFERENCIA_RECEBIDA" -> "TRANSFERÊNCIA RECEBIDA";
            default                       -> tipo;
        };
    }
}