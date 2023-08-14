package finaldeliverable;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {

    private final String gameName;
    private ArrayList<Player> players;
    private GroupOfCards deck;
    private int currentPlayerIndex;

    public Game(String givenName, int numPlayers) {
        gameName = givenName;
        players = new ArrayList<>();
        deck = new GroupOfCards();
        deck.shuffle();
        currentPlayerIndex = 0;
        
        // Add specified number of players
        for (int i = 0; i < numPlayers; i++) {
            players.add(new Player("Player " + (i + 1)));
        }
    }

    public void startGame(Scanner scanner) {
        System.out.println("Welcome to the game of War!");

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
            playRound(scanner);

            // Check if the game should continue
            System.out.println("\nWant to play another round? (Type 'y' for yes or 'n' for No)");
            String play = scanner.next().toLowerCase();
            continuePlaying = play.equals("y");
        }

        System.out.println("Thank you for playing!");
    }

    public void playRound(Scanner scanner) {
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
        // TODO: Implement the war logic here
        // (This section is left blank as per your request)
    }
}
