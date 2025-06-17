package ed04;

public class PessoaJuridica extends ContatoBase {
    private String cnpj;

    public PessoaJuridica(String nome, String telefone, String email, String cnpj) {
        super(nome, telefone, email);
        setCnpj(cnpj);
    }

    public String getCnpj() { return cnpj; }
    public void setCnpj(String cnpj) {
        if (!cnpj.matches("\\d{14}"))
            throw new IllegalArgumentException("CNPJ inválido");
        this.cnpj = cnpj;
    }
}
