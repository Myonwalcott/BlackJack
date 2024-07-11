import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Card> Hand;

    public Player() {
        this.Hand = new ArrayList<>();
    }

    public void addCard(Card card) {
        Hand.add(card);
    }

    public int calculateHandValue() {
        int value = 0;
        boolean hasAce = false;

        for (Card card : Hand) {
            value += card.getValue();
            if (card.getRank().equals("Ace")) {
                hasAce = true;
            }
        }

        // If the hand value is over 21 and there's an Ace, count the Ace as 1 instead of 11
        if (value > 21 && hasAce) {
            value -= 10;
        }

        return value;
    }

    public void displayHand() {
        for (Card card : Hand) {
            System.out.println(card.toString());
        }
        System.out.println("Total value: " + calculateHandValue());
    }

    public boolean busted() {
        return calculateHandValue() > 21;
    }
}
