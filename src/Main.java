import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creates two players with names and symbols ('X' for player 1 and 'O' for player 2)
        Player player1 = new Player("Player 1", 'X');
        Player player2 = new Player("Player 2", 'O');

        TicTacToeGame game = new TicTacToeGame(player1, player2);
        game.play(scanner);

        scanner.close();
    }
}