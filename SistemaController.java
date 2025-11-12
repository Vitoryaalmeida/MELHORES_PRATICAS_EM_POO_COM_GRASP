import java.util.Scanner;

/**
 * Classe: SistemaController
 *
 * Princípio GRASP aplicado:
 *  - Controller
 *
 * Justificativa:
 * A classe SistemaController atua como o controlador central do sistema.
 * Ela é responsável por receber as entradas do usuário (menu),
 * delegar as ações para as classes correspondentes (como Mercado)
 * e manter o fluxo principal do programa.
 * 
 * Assim, segue o princípio Controller do GRASP, separando a lógica de controle
 * da lógica de negócio (Mercado e Produto), promovendo alta coesão e baixo acoplamento.
 */
public class SistemaController {

    private Mercado mercado = new Mercado();
    private Scanner input = new Scanner(System.in);

    /**
     * Método: iniciar
     *
     * Controla o fluxo do sistema e a interação com o usuário.
     * Aplicação direta do padrão GRASP Controller.
     */
    public void iniciar() {
        int opcao;

        do {
            exibirMenu();
            opcao = lerInteiro("Escolha uma opção: ");

            switch (opcao) {
                case 1:
                    adicionarProduto();
                    break;
                case 2:
                    mercado.listarProdutos();
                    break;
                case 0:
                    System.out.println("Encerrando o sistema... Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        } while (opcao != 0);
    }

    // --- Métodos auxiliares ---

    private void exibirMenu() {
        System.out.println("\n=== SISTEMA DE MERCADO ===");
        System.out.println("1 - Adicionar Produto");
        System.out.println("2 - Listar Produtos");
        System.out.println("0 - Sair");
    }

    private void adicionarProduto() {
        System.out.print("Nome do produto: ");
        String nome = input.nextLine();

        double preco = lerDouble("Preço do produto: ");

        mercado.adicionarProduto(nome, preco);
    }

    private int lerInteiro(String mensagem) {
        System.out.print(mensagem);
        while (!input.hasNextInt()) {
            System.out.print("Por favor, digite um número válido: ");
            input.next();
        }
        int valor = input.nextInt();
        input.nextLine(); // limpar o buffer
        return valor;
    }

    private double lerDouble(String mensagem) {
        System.out.print(mensagem);
        while (!input.hasNextDouble()) {
            System.out.print("Por favor, digite um número válido: ");
            input.next();
        }
        double valor = input.nextDouble();
        input.nextLine(); // limpar o buffer
        return valor;
    }
}
