# 🏦 Sistema Bancário

Sistema bancário orientado a objetos desenvolvido em Java, com foco em boas práticas de POO, tratamento de exceções, validações de domínio e persistência de dados.

---

## 📌 Sobre o Projeto

Este projeto foi desenvolvido como exercício prático de Programação Orientada a Objetos em Java. O objetivo é simular as operações básicas de um sistema bancário real, cobrindo desde a modelagem do domínio até a persistência de dados em arquivo.

---

## ✅ Funcionalidades Implementadas

### Contas
- Criação de **Conta Corrente** com limite de crédito
- Criação de **Conta Poupança** com taxa de rendimento
- Validação de saldo inicial, limite e taxa (não negativos)

### Operações
- **Depósito** com registro no extrato
- **Saque** com validação de saldo e limite (Conta Corrente)
- **Transferência** entre contas com registro nas duas partes
- **Extrato** completo com tipo de operação, valor, data/hora e saldo após cada lançamento

### Clientes
- Cadastro com nome, CPF, e-mail e telefone
- Validação de **CPF** com dígitos verificadores
- Validação de **e-mail** com regex
- Validação de **telefone** (10 ou 11 dígitos)
- Restrição de **CPF único** por cliente

### Banco
- Armazenamento de contas com **HashMap** para busca eficiente
- Validação de **número de conta único**
- Listagem e busca de contas

### Interface
- Menu interativo no terminal
- Formatação visual com bordas e alinhamento de colunas
- Mensagens de erro amigáveis sem encerrar o programa

---

## 🚧 Funcionalidades em Desenvolvimento

### Persistência em Arquivo
- Salvar e carregar contas automaticamente ao iniciar/encerrar o sistema
- Formato de arquivo incluindo tipo da conta (`CC` ou `CP`) para instanciar a subclasse correta na leitura
- Persistência do extrato de cada conta

---

## 🗂️ Estrutura do Projeto

```
SistemaBancario/
├── Dominio/
│   ├── Banco.java
│   ├── Conta.java              (abstrata)
│   ├── ContaCorrente.java
│   ├── ContaPoupanca.java
│   ├── Cliente.java
│   ├── Transacao.java
│   └── TipoDeTransacao.java    (enum)
├── Exceções/
│   ├── ClienteInvalidoException.java
│   ├── ContaDuplicadaException.java
│   ├── ContaNaoEncontradaException.java
│   ├── CPFDuplicadoException.java
│   ├── SaldoInsuficienteException.java
│   └── ValorInvalidoException.java
├── Utilitários/
│   ├── Formatador.java
│   ├── ValidadorCPF.java
│   └── ValidadorEmail.java
└── Principal/
    └── Main.java
```

---

## 🧱 Modelagem

```
Conta (abstrata)
├── ContaCorrente     → limite de crédito
└── ContaPoupanca     → taxa de rendimento

Cliente               → titular da conta
Transacao             → registro de cada operação
TipoDeTransacao       → enum: DEPOSITO, SAQUE, TRANSFERENCIA_ENVIADA, TRANSFERENCIA_RECEBIDA
Banco                 → HashMap<Integer, Conta>
```

---



## 🛠️ Conceitos Aplicados

| Conceito | Aplicação |
|---|---|
| Herança | `ContaCorrente` e `ContaPoupanca` estendem `Conta` |
| Abstração | `Conta` é classe abstrata |
| Polimorfismo | `sacar()` sobrescrito em `ContaCorrente` |
| Encapsulamento | Atributos privados com getters/setters |
| Exceções verificadas | Todas as exceções de negócio estendem `Exception` |
| Coleções | `HashMap` para contas, `ArrayList` para extrato |
| Enum | `TipoDeTransacao` |
| Classe utilitária | `ValidadorCPF`, `ValidadorEmail`, `Formatador` |

---

## 👨‍💻 Autor

**Isaque Costa Da Cunha**  
[github.com/isaque-collab](https://github.com/isaque-collab)