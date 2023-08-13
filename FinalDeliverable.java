package finaldeliverable;

import java.util.Scanner;

public class FinalDeliverable {

    public static void main(String[] args) {
        // Create a game object
        Game war = new Game("War");

        // Start the game loop
        String play;
        Scanner in = new Scanner(System.in);

        do {
            // Start a new game
            war.startGame();

            // Ask if the player wants to play again
            System.out.println("\nWant to play again? \nType 'y' for yes or 'n' for No!");
            play = in.next().toLowerCase();
        } while (play.equals("y"));

        System.out.println("Thank you for playing!");
    }
}
