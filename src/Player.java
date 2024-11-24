import java.util.Scanner; // Importing Scanner class to read input from the user

public class Player {
    private String name;   // The name of the player
    private char symbol;   // The symbol assigned to the player ('X' or 'O')

    // Constructor to initialize the player with a name and a symbol
    public Player(String name, char symbol) {
        this.name = name;   // Set the player's name
        this.symbol = symbol; // Set the player's symbol
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }

    // Method for the player to take their turn on the board
    public void takeTurn(char[][] board, Scanner scanner) {
        String userInput;
        // Keep asking for input until a valid move is made
        while (true) {
            System.out.println(name + ", where would you like to play? (1-9)");
            userInput = scanner.nextLine();
            // Check if the move is valid
            if (TicTacToeGame.isValidMove(board, userInput)) {
                break;  // Exit the loop if the move is valid
            } else {
                System.out.println(userInput + " is not a valid move.");  // Inform the player if the move is invalid
            }
        }
        TicTacToeGame.placeMove(board, userInput, symbol);
    }
}