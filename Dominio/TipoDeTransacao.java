package POO.Projetos.SistemaBancario.Dominio;

import java.io.Serializable;

public enum TipoDeTransacao implements Serializable {
    DEPOSITO,
    SAQUE,
    TRANSFERENCIA_ENVIADA,
    TRANSFERENCIA_RECEBIDA
}
