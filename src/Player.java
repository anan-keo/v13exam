import java.util.Scanner;

public class Player {
    private String name;
    private char symbol;

    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }

    public void takeTurn(char[][] board, Scanner scanner) {
        String userInput;
        while (true) {
            System.out.println(name + ", where would you like to play? (1-9)");
            userInput = scanner.nextLine();
            if (TicTacToeGame.isValidMove(board, userInput)) {
                break;
            } else {
                System.out.println(userInput + " is not a valid move.");
            }
        }
        TicTacToeGame.placeMove(board, userInput, symbol);
    }
}