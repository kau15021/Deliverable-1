/**
 * A class that represents a group of cards for a Game.
 * Add your name as an author and the date!
 * @modifier Harleen Kaur, 2023
 * @modifier Jasmine Saini, 2023
 * @modifier Priyanka Priyanka, 2023
 * @modifier Arman Sharma, 2023
 */

package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

public class GroupOfCards {

    private ArrayList<Card> cards;

    public GroupOfCards() {
        cards = new ArrayList<>();
        setCards();
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards() {
        for (Card.Suit s : Card.Suit.values()) {
            for (Card.Rank r : Card.Rank.values()) {
                cards.add(new Card(s, r));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }
}
