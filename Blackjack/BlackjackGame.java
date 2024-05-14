import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BlackjackGame {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
System.out.println("Welcome to Blackjack!");

// Initialize variables
int playerMoney = 10000; // Starting money for the player
boolean playing = true;

while (playing) {
System.out.println("You have $" + playerMoney + ". How much would you like to bet?");
int bet = scanner.nextInt();
if (bet > playerMoney) {
System.out.println("You don't have enough money.");
continue;
}

// Create and shuffle a deck
Deck deck = new Deck();
deck.shuffle();

// Deal cards to player and dealer
Hand playerHand = new Hand();
Hand dealerHand = new Hand();
playerHand.addCard(deck.dealCard());
dealerHand.addCard(deck.dealCard());
playerHand.addCard(deck.dealCard());
dealerHand.addCard(deck.dealCard());

// Player's turn
boolean playerTurn = true;
while (playerTurn) {
System.out.println("Your hand: " + playerHand + " " + "(" + playerHand.getBlackjackValue() + ")");
System.out.println("Dealer's hand: " + dealerHand.getCard(0) + " [Hidden]");
System.out.println("Would you like to Hit or Stand? (h/s)");
char choice = scanner.next().charAt(0);
if (choice == 'h') {
playerHand.addCard(deck.dealCard());
if (playerHand.getBlackjackValue() > 21) {
System.out.println("Busted! You lose.");
playerMoney -= bet;
playerTurn = false;
}
} else if (choice == 's') {
playerTurn = false;
} else {
System.out.println("Invalid choice. Please enter 'h' or 's'.");
}
}

// Dealer's turn
while (dealerHand.getBlackjackValue() <= playerHand.getBlackjackValue() && dealerHand.getBlackjackValue() < 17) {
dealerHand.addCard(deck.dealCard());
}

// Display final hands
System.out.println("Your hand: " + playerHand);
System.out.println("Dealer's hand: " + dealerHand);

// Determine winner
int playerValue = playerHand.getBlackjackValue();
int dealerValue = dealerHand.getBlackjackValue();
if (playerValue > 21) {
System.out.println("Dealer wins. You busted.");
playerMoney -= bet;
} else if (dealerValue > 21 || playerValue > dealerValue) {
System.out.println("You win!");
playerMoney += bet;
} else if (playerValue < dealerValue) {
System.out.println("Dealer wins.");
playerMoney -= bet;
} else {
System.out.println("It's a tie.");
}

// Check if player has run out of money
if (playerMoney <= 0) {
System.out.println("You're out of money! Game over.");
playing = false;
} else {
System.out.println("You have $" + playerMoney + " left. Would you like to play again? (y/n)");
char again = scanner.next().charAt(0);
if (again != 'y') {
playing = false;
}
}
}
}
}
