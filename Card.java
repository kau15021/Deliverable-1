package finaldeliverable;

public class Card {

    public enum Suit {
        CLUB, SPADE, HEARTS, DIAMONDS
    }

    public enum Rank {
        ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
    }

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

    @Override
    public String toString() {
        String format = "%s of %s";
        return String.format(format, cardRank, cardSuit);
    }
}
