import java.util.ArrayList;
import java.util.List;

/**
 * Classe: Mercado
 * 
 * Princípios GRASP aplicados:
 *  Creator  
 *  Low Coupling (Baixo Acoplamento)
 *  High Cohesion (Alta Coesão)
 * 
 * Justificativas:
 * 
 * Creator:
 * O Mercado "contém" produtos, logo é responsável por criá-los.
 * Isso reduz dependências externas e segue o princípio Creator do GRASP.
 * Aplicado no método adicionarProduto().
 *
 * Low Coupling:
 * A classe Mercado tem baixo acoplamento porque se comunica apenas com a classe Produto
 * e não depende de outras classes do sistema (como controladores ou menus).
 * Isso facilita a manutenção e a reutilização do código.
 * 
 */
public class Mercado {
    private List<Produto> produtos;
    private int proximoCodigo = 1;

    public Mercado() {
        produtos = new ArrayList<>();
    }

    /**
     * Método: adicionarProduto
     * 
     * Aplicação do GRASP: Creator
     * 
     * O Mercado cria objetos da classe Produto, pois ele os contém.
     * Isso segue o princípio Creator do GRASP.
     */
    public void adicionarProduto(String nome, double preco) {
        Produto novoProduto = new Produto(proximoCodigo, nome, preco);
        produtos.add(novoProduto);
        proximoCodigo++;
        System.out.println("Produto adicionado com sucesso!");
    }

    /**
     * Método: listarProdutos
     * 
     * Aplicação do GRASP: High Cohesion
     * 
     * O método é responsável por exibir todos os produtos cadastrados.
     * Mantém alta coesão, pois está diretamente ligado à função da classe Mercado.
     */
    public void listarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            System.out.println("\n--- Produtos cadastrados ---");
            for (Produto p : produtos) {
                System.out.println(p);
            }
        }
    }

    /**
     * Método: atualizarProduto
     * 
     * Aplicação do GRASP: High Cohesion
     * 
     * O método permite atualizar as informações de um produto existente.
     * A lógica pertence ao Mercado, pois ele é o responsável por gerenciar seus produtos.
     */
    public boolean atualizarProduto(int codigo, String novoNome, double novoPreco) {
        for (Produto p : produtos) {
            if (p.getCodigo() == codigo) {
                p.setNome(novoNome);
                p.setPreco(novoPreco);
                System.out.println("Produto atualizado com sucesso!");
                return true;
            }
        }
        System.out.println("Produto não encontrado!");
        return false;
    }

    /**
     * Método: removerProduto
     * 
     * Aplicação do GRASP: High Cohesion e Low Coupling
     * 
     * O método remove um produto da lista.
     * Mantém baixo acoplamento, pois não depende de outras classes para realizar a exclusão,
     * e alta coesão, já que trata diretamente da responsabilidade do Mercado.
     */
    public boolean removerProduto(int codigo) {
        for (Produto p : produtos) {
            if (p.getCodigo() == codigo) {
                produtos.remove(p);
                System.out.println("Produto removido com sucesso!");
                return true;
            }
        }
        System.out.println("Produto não encontrado!");
        return false;
    }
}
