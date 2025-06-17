package ed04;

import java.util.List;
import java.util.Scanner;

public class ContatoView {
    private final ContatoController controller = new ContatoController();
    private final Scanner in = new Scanner(System.in);

    public void exibirMenu() {
        int op;
        do {
            System.out.println("\n1-Adicionar 2-Listar 3-Remover 0-Sair");
            op = Integer.parseInt(in.nextLine());
            switch (op) {
                case 1 -> adicionar();
                case 2 -> mostrarContatos(controller.listar());
                case 3 -> remover();
            }
        } while (op != 0);
    }

    private void adicionar() {
        try {
            System.out.print("Nome: ");
            String nome = in.nextLine();
            System.out.print("Telefone: ");
            String tel = in.nextLine();
            System.out.print("Email: ");
            String email = in.nextLine();
            System.out.print("Tipo (1-Física 2-Jurídica): ");
            int tipo = Integer.parseInt(in.nextLine());

            if (tipo == 1) {
                System.out.print("CPF: ");
                String cpf = in.nextLine();
                controller.adicionar(new PessoaFisica(nome, tel, email, cpf));
            } else {
                System.out.print("CNPJ: ");
                String cnpj = in.nextLine();
                controller.adicionar(new PessoaJuridica(nome, tel, email, cnpj));
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private void remover() {
        System.out.print("CPF ou CNPJ: ");
        String doc = in.nextLine();
        controller.remover(doc);
    }

    public void mostrarContatos(List<Contato> lista) {
        System.out.printf("%-20s %-15s %-25s %-15s\n", "Nome", "Telefone", "Email", "Doc");
        for (Contato c : lista) {
            String doc = c instanceof PessoaFisica pf ? pf.getCpf() : ((PessoaJuridica) c).getCnpj();
            System.out.printf("%-20s %-15s %-25s %-15s\n",
                    c.getNome(), c.getTelefone(), c.getEmail(), doc);
        }
    }
}
