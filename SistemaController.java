import java.util.Scanner;

/**
 * Classe: SistemaController
 * 
 * Princípios GRASP aplicados:
 *  Controller e Low Coupling
 * 
 * Justificativa:
 * Esta classe é responsável por controlar o fluxo do sistema, recebendo
 * as entradas do usuário e delegando as ações para a classe Mercado.
 * Assim, mantém baixo acoplamento entre interface e lógica de negócios.
 */
public class SistemaController {
    private Mercado mercado;
    private Scanner scanner;

    public SistemaController() {
        mercado = new Mercado();
        scanner = new Scanner(System.in);
    }

    public void iniciar() {
        int opcao;
        do {
            System.out.println("\n===== SISTEMA DE MERCADO =====");
            System.out.println("1 - Adicionar produto");
            System.out.println("2 - Listar produtos");
            System.out.println("3 - Atualizar produto");
            System.out.println("4 - Remover produto");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (opcao) {
                case 1:
                    adicionarProduto();
                    break;
                case 2:
                    mercado.listarProdutos();
                    break;
                case 3:
                    atualizarProduto();
                    break;
                case 4:
                    removerProduto();
                    break;
                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        } while (opcao != 0);
    }

    private void adicionarProduto() {
        System.out.print("Nome do produto: ");
        String nome = scanner.nextLine();
        System.out.print("Preço: ");
        double preco = scanner.nextDouble();
        mercado.adicionarProduto(nome, preco);
    }

    private void atualizarProduto() {
        System.out.print("Código do produto a atualizar: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Novo nome: ");
        String nome = scanner.nextLine();
        System.out.print("Novo preço: ");
        double preco = scanner.nextDouble();
        mercado.atualizarProduto(codigo, nome, preco);
    }

    private void removerProduto() {
        System.out.print("Código do produto a remover: ");
        int codigo = scanner.nextInt();
        mercado.removerProduto(codigo);
    }
}
