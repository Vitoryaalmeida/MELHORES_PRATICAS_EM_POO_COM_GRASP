/**
 * Classe: Produto
 * 
 * Princípios GRASP aplicados:
 *  High Cohesion (Alta Coesão)
 * 
 * Justificativa:
 * Esta classe tem alta coesão porque suas responsabilidades são bem definidas e limitadas:
 * armazenar e fornecer informações sobre um produto (código, nome e preço).
 * Ela não cria outros objetos nem controla o fluxo do sistema.
 * 
 * Assim, a classe é coesa — trata apenas de seus próprios dados.
 */
public class Produto {
    private int codigo;
    private String nome;
    private double preco;

    /**
     * Construtor da classe Produto.
     * 
     * Cria um produto com código, nome e preço definidos.
     */
    public Produto(int codigo, String nome, double preco) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
    }

    // Métodos de acesso (getters)
    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    // Exibe as informações do produto
    @Override
    public String toString() {
        return "Código: " + codigo + " | Produto: " + nome + " | Preço: R$ " + preco;
    }
}
