/**
 * Tabuleiro
 */
public class Board {

    /**
     * Matriz de string
     */
    private String[][] board = new String[3][3];

    /**
     * Reseta ao instanciar
     */
    public Board() {
        reset();
    }

    /**
     * Reseta o tabuleiro
     */
    public void reset() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = "";
            }
        }
    }

    /**
     * Exibe o tabuleiro
     */
    public void show() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == "") {
                    if (i < 2) {
                        System.out.print("_");
                    } else {
                        System.out.print(" ");
                    }
                } else {
                    System.out.print(board[i][j]);
                }

                if (j != 2) {
                    System.out.print("|");
                }
            }
            System.out.println();
        }
    }

    /**
     * Verifica as linhas
     * 
     * @return
     */
    public String checkLines() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][0] == board[i][2]) {
                return board[i][0];
            }
        }

        return "";
    }

    /**
     * Verifica as colunas
     * 
     * @return
     */
    public String checkColumns() {
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == board[1][j] && board[0][j] == board[2][j]) {
                return board[0][j];
            }
        }

        return "";

    }

    /**
     * Verifica as diagonais
     * 
     * @return
     */
    public String checkDiagonals() {
        if (board[0][0] == board[1][1] && board[0][0] == board[2][2]) {
            return board[0][0];
        }

        if (board[0][2] == board[1][1] && board[0][2] == board[2][0]) {
            return board[0][2];
        }

        return "";
    }

    /**
     * Verifica se o tabuleiro está completo
     * 
     * @return
     */
    public boolean checkIfBoardIsComplete() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == "") {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Realiza uma jogada
     * 
     * @param line
     * @param column
     * @param value
     */
    public void setPosition(int line, int column, String value) {
        board[line][column] = value;
    }

    /**
     * Verifica se a posição está livre
     * 
     * @param line
     * @param column
     * 
     * @return
     */
    public boolean checkIfPositionIsFree(int line, int column) {
        if (board[line][column] == "") {
            return true;
        }

        return false;
    }
}