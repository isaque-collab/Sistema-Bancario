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

### Persistência
- Dados salvos automaticamente em arquivo binário (`banco.dat`) após cada operação
- Carregamento automático ao iniciar o sistema — contas e extratos são restaurados integralmente
- Implementada via **serialização Java nativa** (`Serializable`), sem dependências externas

### Interface
- Menu interativo no terminal
- Formatação visual com bordas e alinhamento de colunas
- Mensagens de erro amigáveis sem encerrar o programa

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
├── Exceptions/
│   ├── ClienteInvalidoException.java
│   ├── ContaDuplicadaException.java
│   ├── ContaNaoEncontradaException.java
│   ├── CPFDuplicadoException.java
│   ├── SaldoInsuficienteException.java
│   └── ValorInvalidoException.java
├── Utils/
│   ├── Formatador.java
│   ├── PersistenciaService.java
│   ├── ValidadorCPF.java
│   └── ValidadorEmail.java
└── Main/
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
PersistenciaService   → salvar/carregar Banco via serialização
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
| Serialização | Persistência via `ObjectOutputStream` / `ObjectInputStream` |
| Classe utilitária | `ValidadorCPF`, `ValidadorEmail`, `Formatador`, `PersistenciaService` |

---

## ⚙️ Como Executar

1. Clone o repositório
2. Abra o projeto no IntelliJ IDEA
3. Adicione `-Dfile.encoding=UTF-8` nas VM options para exibir corretamente os caracteres do menu no Windows
4. Execute `Main.java`
5. O arquivo `banco.dat` será criado automaticamente na raiz do projeto na primeira operação

---

## 👨‍💻 Autor

**Isaque Costa Da Cunha**  
[github.com/isaque-collab](https://github.com/isaque-collab)