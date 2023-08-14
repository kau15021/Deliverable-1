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
            if (players.get(0).getHand().isEmpty() || players.get(1).getHand().isEmpty()) {
                continuePlaying = false;
                displayWinner();
            } else {
                System.out.println("\nWant to play another round? (Type 'y' for yes or 'n' for No)");
                String play = scanner.next().toLowerCase();
                continuePlaying = play.equals("y");
            }
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
            initiateWar(currentPlayer, opponent, scanner);
        }

        // Proceed to the next round
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
    }

    public void initiateWar(Player currentPlayer, Player opponent, Scanner scanner) {
    System.out.println("Initiating war...");

    // Each player places three cards face down
    Card[] currentPlayerCards = new Card[4];
    Card[] opponentCards = new Card[4];

    for (int i = 0; i < 3; i++) {
        currentPlayerCards[i] = currentPlayer.playCard();
        opponentCards[i] = opponent.playCard();
    }

    // Each player places one card face up
    currentPlayerCards[3] = currentPlayer.playCard();
    opponentCards[3] = opponent.playCard();

    System.out.println(currentPlayer.getName() + "'s cards for war:");
    for (int i = 0; i < 4; i++) {
        System.out.println("Card " + (i + 1) + ": " + currentPlayerCards[i]);
    }

    System.out.println(opponent.getName() + "'s cards for war:");
    for (int i = 0; i < 4; i++) {
        System.out.println("Card " + (i + 1) + ": " + opponentCards[i]);
    }

    // Determine the winner of the war
    if (currentPlayerCards[3].getRank().ordinal() > opponentCards[3].getRank().ordinal()) {
        System.out.println(currentPlayer.getName() + " wins the war and collects all the cards!");
        currentPlayer.collectCards(currentPlayerCards);
        currentPlayer.collectCards(opponentCards);
    } else if (currentPlayerCards[3].getRank().ordinal() < opponentCards[3].getRank().ordinal()) {
        System.out.println(opponent.getName() + " wins the war and collects all the cards!");
        opponent.collectCards(currentPlayerCards);
        opponent.collectCards(opponentCards);
    } else {
        System.out.println("It's another tie! The war continues.");
        initiateWar(currentPlayer, opponent, scanner); // Recursively continue the war until a winner is determined
    }


    }

    public void displayWinner() {
        if (players.get(0).getHand().isEmpty()) {
            System.out.println(players.get(1).getName() + " wins the game!");
        } else if (players.get(1).getHand().isEmpty()) {
            System.out.println(players.get(0).getName() + " wins the game!");
        }
    }
}
