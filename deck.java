import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class deck {
    private List<card> cards;

    public deck() {
        cards = new ArrayList<>();
        createDeck();
    }

    private void createDeck() {
        ArrayList<String> suits = new ArrayList<>();
        ArrayList<Integer> values = new ArrayList<>();

        suits.add("clubs");
        suits.add("spades");
        suits.add("hearts");
        suits.add("diamonds");

        values.add(1);
        values.add(2);
        values.add(3);
        values.add(4);
        values.add(5);
        values.add(6);
        values.add(7);
        values.add(8);
        values.add(9);
        values.add(10);
        values.add(11);
        values.add(12);
        values.add(13);

        for(String suit : suits) {
            for(int value : values) {
                cards.add(new card(value, suit));
            }
        }
    }

    public void shuffle() {
           Collections.shuffle(cards);
    }

    public card dealCard() {
        if (!cards.isEmpty()) {
            return cards.remove(0);
        }
        return null;
    }

    public int cardsLeft() {
        return cards.size();
    }
}
