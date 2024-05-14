import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Deck {
private List<Card> cards;
private int currentCard;

public Deck() {
String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
cards = new ArrayList<>();
currentCard = 0;

for (String suit : suits) {
for (String rank : ranks) {
cards.add(new Card(rank, suit));
}
}
}

public void shuffle() {
Collections.shuffle(cards);
currentCard = 0;
}

public Card dealCard() {
if (currentCard < cards.size()) {
return cards.get(currentCard++);
} else {
return null;
}
}
}