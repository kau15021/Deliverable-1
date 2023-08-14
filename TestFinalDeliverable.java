package finaldeliverable;

import java.util.Scanner;

public class TestFinalDeliverable {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the test of the game of War!");

        // Create a game object with 2 players for testing
        Game war = new Game("War Test", 2);

        // Start the test game
        try {
            war.startGame(scanner);
        } catch (Exception e) {
            System.out.println("An error occurred during testing.");
            e.printStackTrace();
        }

        System.out.println("Test complete!");
    }
}
