import java.util.Scanner;

/**
 * Jogo
 */
public class Game {

    private Board board = new Board(); // Tabuleiro
    private String turn = "X"; // Vez
    private Player playerX = new Player(); // Jogador "X"
    private Player playerO = new Player(); // Jogador "O"
    public Scanner scanner = new Scanner(System.in); // Scanner

    /**
     * CONSTRUTOR - Jogo
     */
    public Game() {
        initializePlayers();

        boolean keepPlaying = true;
        while (keepPlaying) {
            keepPlaying = play();
        }
    }

    /**
     * Inicializa os jogagores
     */
    public void initializePlayers() {
        System.out.println("Qual o nome do jogador X?");
        this.playerX.setName(scanner.next());

        System.out.println("Qual o nome do jogador O?");
        this.playerO.setName(scanner.next());
    }

    /**
     * Realiza uma jogada
     */
    public void executeMove() {
        int line = 0;
        int column = 0;

        do {
            do {
                System.out.print("Linha: ");
                line = scanner.nextInt();

                if (line > 3 || line < 1) {
                    System.out.println("Linha inválida. Possíveis valores: 1, 2 ou 3.");
                }
            } while (line > 3 || line < 1);

            do {
                System.out.print("Coluna: ");
                column = scanner.nextInt();

                if (column > 3 || column < 1) {
                    System.out.println("Coluna inválida. Possíveis valores: 1, 2 ou 3.");
                }
            } while (column > 3 || column < 1);

            line--;
            column--;

            if (!board.checkIfPositionIsFree(line, column))
                System.out.println("Esta posição já foi marcada. Tente novamente.");
        } while (!board.checkIfPositionIsFree(line, column));

        board.setPosition(line, column, turn);
        board.show();
    }

    /**
     * Regras de jogo e controle das jogadas até o fim de jogo.
     * 
     * @return boolean se o jogo irá continuar.
     */
    public boolean play() {
        String boardResult = checkBoard();
        if (boardResult == "") {
            System.out.println((turn == "X" ? this.playerX.getName() : this.playerO.getName()) + " é a sua vez!");
            executeMove();

            if (board.checkIfBoardIsComplete()) {
                System.out.println("Empatado!");
                return false;
            }

            turn = turn == "X" ? "O" : "X";

        } else if (boardResult == "X") {
            System.out.println(this.playerX.getName() + " ganhou!");
            return false;
        } else {
            System.out.println(this.playerO.getName() + " ganhou!");
            return false;
        }

        return true;
    }

    /**
     * Verifica o tabuleiro
     * 
     * @return string Símbolo do vencedor, vazio caso o jogo ainda nao esteja
     *         definido.
     */
    public String checkBoard() {
        if (board.checkLines() == "X" || board.checkColumns() == "X" || board.checkDiagonals() == "X") {
            return "X";
        } else if (board.checkLines() == "O" || board.checkColumns() == "O" || board.checkDiagonals() == "O") {
            return "O";
        } else {
            return "";
        }
    }
}