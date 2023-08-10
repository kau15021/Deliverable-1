/**
 * The class that models the game.
 * Add your name as an author and the date!
 * @modifier Harleen Kaur, 2023
 * @modifier Jasmine Saini, 2023
 * @modifier Priyanka Priyanka, 2023
 * @modifier Arman Sharma, 2023
 */

package ca.sheridancollege.project;

import java.util.Scanner;

public class WarGame {

    public static void main(String[] args) {

        Game war = new Game("war");
        String play;

        do {
            war.play();
            Scanner in = new Scanner(System.in);
            System.out.println("\nWant to play again? \nType 'y' for yes or 'n' for No!");
            play = in.next().toLowerCase();
        } while (play.equals("y"));

        System.out.println("Thank you for playing!");
    }
}
