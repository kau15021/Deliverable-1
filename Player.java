package finaldeliverable;

import java.util.ArrayList;

public class Player {

    private String name;
    private ArrayList<Card> hand;

    public Player(String name) {
        this.name = name;
        hand = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void addCardToHand(Card card) {
        hand.add(card);
    }

    public void clearHand() {
        hand.clear();
    }

    public Card getTopCard() {
        return hand.get(hand.size() - 1);
    }

    public Card playCard() {
        return hand.remove(hand.size() - 1);
    }

    public void collectCards(Card... cards) {
        for (Card card : cards) {
            addCardToHand(card);
        }
    }
}
