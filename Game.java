/**
 * The class that models the game.
 * Add your name as an author and the date!
 * @modifier Harleen Kaur, 2023
 * @modifier Jasmine Saini, 2023
 * @modifier Priyanka Priyanka, 2023
 * @modifier Arman Sharma, 2023
 */

package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    private final String gameName;
    private ArrayList<Player> players;

    public Game(String givenName) {
        gameName = givenName;
    }

    public String getGameName() {
        return gameName;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public void play() {
        
    }

    public String checkFinalWinner(Player p1, Player p2) {
        
        return "";
    }

    public boolean checkNumCards(Player p1, Player p2) {
        
        return false;
    }

    public static boolean checkExistedName(String user1, String user2) {
        return user1.equalsIgnoreCase(user2);
    }
}
