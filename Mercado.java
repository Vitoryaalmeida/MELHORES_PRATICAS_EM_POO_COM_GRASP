import java.util.ArrayList;
import java.util.List;

/**
 * Classe: Mercado
 * 
 * Princípios GRASP aplicados:
 *  Creator  
 * Low Coupling (Baixo Acoplamento)
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
 */
public class Mercado {
    private List<Produto> produtos;
    private int proximoCodigo = 1; // contador automático de códigos

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
     * Mostra todos os produtos cadastrados.
     * Mantém alta coesão, pois está diretamente ligado à função da classe Mercado.
     */
    public void listarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            System.out.println(" Produtos cadastrados:");
            for (Produto p : produtos) {
                System.out.println(p);
            }
        }
    }
}

