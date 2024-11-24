import java.util.Scanner;

public class TicTacToeGame {
    private char[][] board;
    private Player player1;
    private Player player2;

    // Constructor to initialize the game with two players
    public TicTacToeGame(Player player1, Player player2) {
        this.board = new char[][]{{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
        this.player1 = player1; // Assign player1 to the game
        this.player2 = player2; // Assign player2 to the game
    }

    public void play(Scanner scanner) {
        Player currentPlayer;
        boolean playAgain = true;

        // Main game loop that runs until players decide to stop
        while (playAgain) {
            currentPlayer = player1;

            while (true) {
                printBoard();
                currentPlayer.takeTurn(board, scanner);

                // Check if the game is finished, win or tie
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
                playAgain = false; // End the game loop if players don't want to play again
            }
        }
    }

    // Method to check if the game has finished, win or tie
    private boolean isGameFinished(Player currentPlayer) {
        if (hasContestantWon(currentPlayer.getSymbol())) { // Check if the current player has won
            System.out.println(currentPlayer.getName() + " wins!");
            return true;  // Game is finished
        }

        if (isBoardFull()) {  // Check if the board is full, tie
            System.out.println("The game ended in a tie!");
            return true;  // Game is finished
        }

        return false;
    }

    // Method to check if a player has won the game
    private boolean hasContestantWon(char symbol) {
        // Check rows, columns, and diagonals for a win condition
        return (board[0][0] == symbol && board[0][1] == symbol && board[0][2] == symbol) ||
                (board[1][0] == symbol && board[1][1] == symbol && board[1][2] == symbol) ||
                (board[2][0] == symbol && board[2][1] == symbol && board[2][2] == symbol) ||

                (board[0][0] == symbol && board[1][0] == symbol && board[2][0] == symbol) ||
                (board[0][1] == symbol && board[1][1] == symbol && board[2][1] == symbol) ||
                (board[0][2] == symbol && board[1][2] == symbol && board[2][2] == symbol) ||

                (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) ||
                (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol);
    }

    // Method to check if the board is full
    private boolean isBoardFull() {
        for (char[] row : board) {
            for (char cell : row) {
                if (cell == ' ') {  // If any cell is empty, return false
                    return false;
                }
            }
        }
        return true;  // The board is full
    }

    // Method to validate if a move is legal
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
            default: return false; // If invalid position is entered, return false
        }
    }

    // Method to place the player's move on the board
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
            default: System.out.println("Invalid move."); // Handle invalid moves
        }
    }

    // Method to print the current state of the game board
    private void printBoard() {
        System.out.println(board[0][0] + "|" + board[0][1] + "|" + board[0][2]); // Print the first row
        System.out.println("-+-+-"); // Row separator
        System.out.println(board[1][0] + "|" + board[1][1] + "|" + board[1][2]); // Print the second row
        System.out.println("-+-+-"); // Row separator
        System.out.println(board[2][0] + "|" + board[2][1] + "|" + board[2][2]); // Print the third row
    }

    // Method to reset the board for a new game
    private void resetBoard() {
        board = new char[][]{{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
    }
}
