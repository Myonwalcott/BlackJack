import java.util.Scanner;

public class Game {
    private Deck deck;
    private Player player;
    private Dealer dealer;
    private Scanner scanner;

    public Game() {
        this.deck = new Deck();
        this.player = new Player();
        this.dealer = new Dealer();
        this.scanner = new Scanner(System.in);
    }

    public void startGame() {
        deck.shuffle();
        dealInitialCards();
        playerTurn();
        if (!player.busted()) {
            dealer.showFirstCard();
            dealer.playTurn(deck);
            determineOutcome();
        } else {
            System.out.println("Player busted. Dealer wins.");
        }
    }

    private void dealInitialCards() {
        player.addCard(deck.dealCard());
        dealer.addCard(deck.dealCard());
        player.addCard(deck.dealCard());
        dealer.addCard(deck.dealCard());
    }

    private void playerTurn() {
        while (true) {
            System.out.println("Your hand:");
            player.displayHand();
            System.out.print("Do you want to hit (h) or stand (s)? ");
            String choice = scanner.nextLine().toLowerCase();
            if (choice.equals("h")) {
                player.addCard(deck.dealCard());
                if (player.busted()) {
                    System.out.println("Player busted with hand:");
                    player.displayHand();
                    break;
                }
            } else if (choice.equals("s")) {
                break;
            } else {
                System.out.println("Invalid input. Please enter 'h' or 's'.");
            }
        }
    }

    private void determineOutcome() {
        int playerScore = player.calculateHandValue();
        int dealerScore = dealer.calculateHandValue();

        System.out.println("Player's hand:");
        player.displayHand();
        System.out.println("Dealer's hand:");
        dealer.displayHand();

        if (playerScore > 21) {
            System.out.println("Player busted. Dealer wins.");
        } else if (dealerScore > 21 || playerScore > dealerScore) {
            System.out.println("Player wins!");
        } else if (playerScore < dealerScore) {
            System.out.println("Dealer wins.");
        } else {
            System.out.println("It's a tie!");
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.startGame();
    }
}
