import java.util.Scanner;

/**
 * Jogo da velha
 * 
 * @author Carine Casagrande
 * @author Walter Marinho
 */
public class App {

    /**
     * Main
     * 
     * @param args
     * 
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        boolean showMenu = true;

        while (showMenu) {
            System.out.println("----------------------------");
            System.out.println("        TIC TAC TOE        ");
            System.out.println("----------------------------");
            System.out.println("1 - Jogar");
            System.out.println("2 - Encerrar");
            System.out.println("----------------------------");

            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    new Game();
                    break;
                case 2:
                    System.out.println("Obrigado!");
                    showMenu = false;
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }

        scanner.close();
    }
}
