package ed04;

public class PessoaFisica extends ContatoBase {
    private String cpf;

    public PessoaFisica(String nome, String telefone, String email, String cpf) {
        super(nome, telefone, email);
        setCpf(cpf);
    }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) {
        if (!cpf.matches("\\d{11}"))
            throw new IllegalArgumentException("CPF inválido");
        this.cpf = cpf;
    }
}
