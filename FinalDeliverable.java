package finaldeliverable;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FinalDeliverable {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Welcome to the game of War!");

            // Ask for the number of players
            int numPlayers = getNumberOfPlayers(scanner);

            // Create a game object with the specified number of players
            Game war = new Game("War", numPlayers);

            // Start the game
            try {
                war.startGame(scanner);
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Consume the invalid input
            }

            // Ask if the player wants to play again
            System.out.println("\nWant to play again? (Type 'y' for yes or 'n' for No)");
        } while (scanner.next().equalsIgnoreCase("y"));

        System.out.println("Thank you for playing!");
    }

    private static int getNumberOfPlayers(Scanner scanner) {
        int numPlayers;
        do {
            System.out.println("Enter the number of players (2 or more):");
            numPlayers = scanner.nextInt();
            if (numPlayers < 2) {
                System.out.println("Invalid number of players. Please enter 2 or more.");
            }
        } while (numPlayers < 2);
        return numPlayers;
    }
}
