/**
 * Classe: Main
 *
 * Responsável por iniciar o sistema.
 * 
 * Aqui apenas instanciamos o controlador principal e chamamos o método iniciar().
 * Isso mantém o princípio de separação de responsabilidades:
 * - Main: ponto de entrada do programa;
 * - SistemaController: responsável pelo controle e fluxo.
 */
public class Main {
    public static void main(String[] args) {
        SistemaController controller = new SistemaController();
        controller.iniciar();
    }
}
