package InternPe;
import java.util.Scanner;
public class ConnectFourGame {
    private static final int ROWS = 6;
    private static final int COLS = 7;
    private static final int EMPTY = -1;

    private int[][] board;
    private int currentPlayer;

    public ConnectFourGame() {
        board = new int[ROWS][COLS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                board[i][j] = EMPTY;
            }
        }
        currentPlayer = 1;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printBoard();
            System.out.println("Player " + currentPlayer + "'s turn. Choose a column (1-" + COLS + "):");
            int column = scanner.nextInt() - 1;

            if (isValidMove(column)) {
                dropPiece(column, currentPlayer);

                if (checkWin(currentPlayer)) {
                    System.out.println("Player " + currentPlayer + " wins!");
                    break;
                } else if (isBoardFull()) {
                    System.out.println("It's a tie!");
                    break;
                }

                currentPlayer = (currentPlayer == 1) ? 2 : 1;
            } else {
                System.out.println("Invalid move. Please try again.");
            }
        }
    }

    private boolean isValidMove(int column) {
        return column >= 0 && column < COLS && board[0][column] == EMPTY;
    }

    private void dropPiece(int column, int player) {
        for (int i = ROWS - 1; i >= 0; i--) {
            if (board[i][column] == EMPTY) {
                board[i][column] = player;
                break;
            }
        }
    }

    private boolean checkWin(int player) {
        // Check horizontal
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS - 3; j++) {
                if (board[i][j] == player && board[i][j + 1] == player &&
                        board[i][j + 2] == player && board[i][j + 3] == player) {
                    return true;
                }
            }
        }

        // Check vertical
        for (int i = 0; i < ROWS - 3; i++) {
            for (int j = 0; j < COLS; j++) {
                if (board[i][j] == player && board[i + 1][j] == player &&
                        board[i + 2][j] == player && board[i + 3][j] == player) {
                    return true;
                }
            }
        }

        // Check diagonal (up-right)
        for (int i = 0; i < ROWS - 3; i++) {
            for (int j = 0; j < COLS - 3; j++) {
                if (board[i][j] == player && board[i + 1][j + 1] == player &&
                        board[i + 2][j + 2] == player && board[i + 3][j + 3] == player) {
                    return true;
                }
            }
        }

        // Check diagonal (up-left)
        for (int i = 0; i < ROWS - 3; i++) {
            for (int j = 3; j < COLS; j++) {
                if (board[i][j] == player && board[i + 1][j - 1] == player &&
                        board[i + 2][j - 2] == player && board[i + 3][j - 3] == player) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean isBoardFull() {
        for (int i = 0; i < COLS; i++) {
            if (board[0][i] == EMPTY) {
                return false;
            }
        }
        return true;
    }

    private void printBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (board[i][j] == EMPTY) {
                    System.out.print(" ");
                } else if (board[i][j] == 1) {
                    System.out.print("X");
                } else {
                    System.out.print("O");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        ConnectFourGame game = new ConnectFourGame();
        game.play();
    }
}