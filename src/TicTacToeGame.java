import java.util.Scanner;

public class TicTacToeGame {
    private char[][] board;
    private Player player1;
    private Player player2;

    public TicTacToeGame(Player player1, Player player2) {
        this.board = new char[][]{{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
        this.player1 = player1;
        this.player2 = player2;
    }

    public void play(Scanner scanner) {
        Player currentPlayer;
        boolean playAgain = true;

        while (playAgain) {
            currentPlayer = player1;

            while (true) {
                printBoard();
                currentPlayer.takeTurn(board, scanner);

                if (isGameFinished(currentPlayer)) {
                    printBoard();
                    break;
                }

                currentPlayer = (currentPlayer == player1) ? player2 : player1;
            }

            // Ask if players want to play again
            System.out.println("Would you like to play again? (yes/no)");
            String response = scanner.nextLine().toLowerCase();
            if (response.equals("yes")) {
                resetBoard(); // Reset the board for a new game
            } else {
                playAgain = false; // Exit the loop if players don't want to play again
            }
        }
    }

    private boolean isGameFinished(Player currentPlayer) {
        if (hasContestantWon(currentPlayer.getSymbol())) {
            System.out.println(currentPlayer.getName() + " wins!");
            return true;
        }

        if (isBoardFull()) {
            System.out.println("The game ended in a tie!");
            return true;
        }

        return false;
    }

    private boolean hasContestantWon(char symbol) {
        return (board[0][0] == symbol && board[0][1] == symbol && board[0][2] == symbol) ||
                (board[1][0] == symbol && board[1][1] == symbol && board[1][2] == symbol) ||
                (board[2][0] == symbol && board[2][1] == symbol && board[2][2] == symbol) ||

                (board[0][0] == symbol && board[1][0] == symbol && board[2][0] == symbol) ||
                (board[0][1] == symbol && board[1][1] == symbol && board[2][1] == symbol) ||
                (board[0][2] == symbol && board[1][2] == symbol && board[2][2] == symbol) ||

                (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) ||
                (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol);
    }

    private boolean isBoardFull() {
        for (char[] row : board) {
            for (char cell : row) {
                if (cell == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isValidMove(char[][] board, String position) {
        switch (position) {
            case "1": return (board[0][0] == ' ');
            case "2": return (board[0][1] == ' ');
            case "3": return (board[0][2] == ' ');
            case "4": return (board[1][0] == ' ');
            case "5": return (board[1][1] == ' ');
            case "6": return (board[1][2] == ' ');
            case "7": return (board[2][0] == ' ');
            case "8": return (board[2][1] == ' ');
            case "9": return (board[2][2] == ' ');
            default: return false;
        }
    }

    public static void placeMove(char[][] board, String position, char symbol) {
        switch (position) {
            case "1": board[0][0] = symbol; break;
            case "2": board[0][1] = symbol; break;
            case "3": board[0][2] = symbol; break;
            case "4": board[1][0] = symbol; break;
            case "5": board[1][1] = symbol; break;
            case "6": board[1][2] = symbol; break;
            case "7": board[2][0] = symbol; break;
            case "8": board[2][1] = symbol; break;
            case "9": board[2][2] = symbol; break;
            default: System.out.println("Invalid move.");
        }
    }

    private void printBoard() {
        System.out.println(board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
        System.out.println("-+-+-");
        System.out.println(board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
        System.out.println("-+-+-");
        System.out.println(board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
    }

    // Reset the board after each game
    private void resetBoard() {
        board = new char[][]{{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
    }
}