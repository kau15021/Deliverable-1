package finaldeliverable;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    private final String gameName;
    private ArrayList<Player> players;
    private GroupOfCards deck;
    private int currentPlayerIndex;

    public Game(String givenName) {
        gameName = givenName;
        players = new ArrayList<>();
        deck = new GroupOfCards();
        deck.shuffle();
        currentPlayerIndex = 0;
    }

    public void addPlayer(String name) {
        players.add(new Player(name));
    }

    public void startGame() {
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to the game of War!");

        // Setup the game
        System.out.println("Enter the number of players (2 in this case):");
        int numPlayers = in.nextInt();
        for (int i = 0; i < numPlayers; i++) {
            System.out.println("Enter the name of player " + (i + 1) + ":");
            String playerName = in.next();
            addPlayer(playerName);
        }

        // Deal cards to players
        for (Player player : players) {
            for (int i = 0; i < 26; i++) {
                player.addCardToHand(deck.getCards().remove(0));
            }
        }

        // Start the game loop
        boolean continuePlaying = true;
        while (continuePlaying) {
            // Play a round
            playRound();

            // Check if the game should continue
            System.out.println("\nWant to play another round? \nType 'y' for yes or 'n' for No!");
            String play = in.next().toLowerCase();
            continuePlaying = play.equals("y");
        }

        System.out.println("Thank you for playing!");
    }

    public void playRound() {
        Player currentPlayer = players.get(currentPlayerIndex);

        // Display the current player's hand and the top card of their pile
        System.out.println("Current Player: " + currentPlayer.getName());
        System.out.println("Top card of the pile: " + currentPlayer.getTopCard());

        // Player selects a card to play
        Card selectedCard = currentPlayer.playCard();
        System.out.println("Selected card: " + selectedCard);

        // Determine the opponent
        int opponentIndex = (currentPlayerIndex == 0) ? 1 : 0;
        Player opponent = players.get(opponentIndex);

        // Reveal the top card of the opponent's pile
        Card opponentTopCard = opponent.getTopCard();
        System.out.println("Opponent's top card: " + opponentTopCard);

        // Determine the winner and handle the outcome
        if (selectedCard.getRank().ordinal() > opponentTopCard.getRank().ordinal()) {
            System.out.println("Current player wins this round!");
            currentPlayer.collectCards(selectedCard, opponentTopCard);
        } else if (selectedCard.getRank().ordinal() < opponentTopCard.getRank().ordinal()) {
            System.out.println("Opponent wins this round!");
            opponent.collectCards(selectedCard, opponentTopCard);
        } else {
            // It's a tie, initiate a war
            System.out.println("It's a tie! A war occurs.");
            initiateWar();
        }

        // Proceed to the next round
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
    }

    public void initiateWar() {
        // Implement the war logic here
    }

    public static void main(String[] args) {
        Game war = new Game("War");
        war.startGame();
    }
}
