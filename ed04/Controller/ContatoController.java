package ed04;

import java.util.ArrayList;
import java.util.List;

public class ContatoController {
    private List<Contato> contatos = new ArrayList<>();

    public void adicionar(Contato contato) {
        if (contato instanceof PessoaFisica pf && existeCpf(pf.getCpf())) return;
        if (contato instanceof PessoaJuridica pj && existeCnpj(pj.getCnpj())) return;
        contatos.add(contato);
    }

    public void remover(String doc) {
        contatos.removeIf(c ->
            (c instanceof PessoaFisica pf && pf.getCpf().equals(doc)) ||
            (c instanceof PessoaJuridica pj && pj.getCnpj().equals(doc))
        );
    }

    public List<Contato> listar() {
        return contatos;
    }

    private boolean existeCpf(String cpf) {
        return contatos.stream()
            .filter(c -> c instanceof PessoaFisica)
            .map(c -> ((PessoaFisica) c).getCpf())
            .anyMatch(cpf::equals);
    }

    private boolean existeCnpj(String cnpj) {
        return contatos.stream()
            .filter(c -> c instanceof PessoaJuridica)
            .map(c -> ((PessoaJuridica) c).getCnpj())
            .anyMatch(cnpj::equals);
    }
}
