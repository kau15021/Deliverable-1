/**
 * A class that models each Card in the game.
 * Add your name as an author and the date!
 * @modifier Harleen Kaur, 2023
 * @modifier Jasmine Saini, 2023
 * @modifier Priyanka Priyanka, 2023
 * @modifier Arman Sharma, 2023
 */

package ca.sheridancollege.project;

public class Card {

    public enum Suit {
        CLUB, SPADE, HEARTS, DIAMONDS
    };

    public enum Rank {
        ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
    };

    private final Suit cardSuit;
    private final Rank cardRank;

    public Card(Suit suit, Rank rank) {
        cardSuit = suit;
        cardRank = rank;
    }

    public Rank getRank() {
        return this.cardRank;
    }

    public Suit getSuit() {
        return this.cardSuit;
    }

    public int getNumericValue() {
        // Implement logic for numeric values of cards if needed
        return 0;
    }

    @Override
    public String toString() {
        String format = "%s of %s";
        return String.format(format, cardRank, cardSuit);
    }
}
