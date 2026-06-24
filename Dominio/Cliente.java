package POO.Projetos.SistemaBancario.Dominio;

import POO.Projetos.SistemaBancario.Exceptions.ClienteInvalidoException;
import POO.Projetos.SistemaBancario.Utils.ValidadorCPF;
import POO.Projetos.SistemaBancario.Utils.ValidadorEmail;

public class Cliente {
    private String nome;
    private String cpf;
    private String email;
    private String telefone;

    public Cliente(String nome, String cpf, String email, String telefone) throws ClienteInvalidoException {
        if (nome == null || nome.isBlank()){
            throw new ClienteInvalidoException("Nome do cliente é obrigatório");
        }

        if (!ValidadorCPF.isCPF(cpf)){
            throw new ClienteInvalidoException("CPF inválido"+cpf);
        }

        if (!ValidadorEmail.isEmail(email)){
            throw new ClienteInvalidoException("E-mail inválido"+email);
        }

        String telefoneLimpo = telefone == null ? "" : telefone.replaceAll("[^0-9]", "");
        if (telefoneLimpo.length() < 10 || telefoneLimpo.length() > 11){
            throw new ClienteInvalidoException("Telefone inválido - Informe 10 ou 11 digitos");
        }
        this.nome = nome.trim();
        this.cpf = cpf.replaceAll("[^0-9]", "");
        this.email = email.trim();
        this.telefone = telefoneLimpo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return nome;
    }
}
