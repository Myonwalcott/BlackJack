public class Card {
    private String suit;
    private String rank;

    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public String getRank() {
        return rank;
    }

    public int getValue() {
        // Return the value of the card based on Blackjack rules
        // Number cards have their face value, face cards are 10, Ace is 1 or 11 (handled elsewhere)
        switch (rank) {
            case "2":  return 2;
            case "3":  return 3;
            case "4":  return 4;
            case "5":  return 5;
            case "6":  return 6;
            case "7":  return 7;
            case "8":  return 8;
            case "9":  return 9;
            case "10": return 10;
            case "Jack":  // Fall-through intentional
            case "Queen":
            case "King":
                return 10;
            case "Ace": return 11;  // Will handle Ace logic in Player class
            default:
                return 0;
        }
    }

    public String toString() {
        return rank + " of " + suit;
    }
}
