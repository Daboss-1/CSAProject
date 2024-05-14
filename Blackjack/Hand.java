import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Hand {
private List<Card> cards;
  
public Hand() {
cards = new ArrayList<>();
}

public void addCard(Card card) {
cards.add(card);
}

public int getBlackjackValue() {
int value = 0;
int numAces = 0;
for (Card card : cards) {
value += card.getValue();
if (card.getValue() == 11) {
numAces++;
}
}
// Adjust value if there are aces and total value is over 21
while (value > 21 && numAces > 0) {
value -= 10;
numAces--;
}
return value;
}

@Override
public String toString() {
StringBuilder handString = new StringBuilder();
for (Card card : cards) {
handString.append(card).append(", ");
}
// Remove the trailing comma and space
if (handString.length() > 0) {
handString.setLength(handString.length() - 2);
}
return handString.toString();
}

public Card getCard(int index) {
return cards.get(index);
}
}