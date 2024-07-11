
import java.util.logging.Handler;

public class Dealer extends Player {
    public void showFirstCard() {
        System.out.println("Dealer's first card: " + hand.get(0).toString());
    }

    public void playTurn(Deck deck) {
        while (calculateHandValue() < 17) {
            addCard(deck.dealCard());
        }
        System.out.println("Dealer's hand:");
        displayHand();
    }
}
