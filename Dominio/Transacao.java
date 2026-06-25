package POO.Projetos.SistemaBancario.Dominio;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transacao implements Serializable {
    private static final long serialVersionUID = 5L;
    private final TipoDeTransacao tipo;
    private final double valor;
    private final LocalDateTime dataHora;
    private final double saldoDepois;

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public Transacao(TipoDeTransacao tipo, double valor, double saldoDepois) {
        this.tipo = tipo;
        this.valor = valor;
        this.dataHora = LocalDateTime.now();
        this.saldoDepois = saldoDepois;
    }

    public TipoDeTransacao getTipo() {
        return tipo;
    }

    public double getValor() {
        return valor;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public double getSaldoDepois() {
        return saldoDepois;
    }

    @Override
    public String toString() {
        return String.format("[%s] %-24s | Valor: R$ %10.2f | Saldo após: R$ %10.2f", dataHora.format(formatter), tipo, valor, saldoDepois);
    }
}
