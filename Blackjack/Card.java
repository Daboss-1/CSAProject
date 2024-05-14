import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Card {
private String rank;
private String suit;

public Card(String rank, String suit) {
this.rank = rank;
this.suit = suit;
}

@Override
public String toString() {
return rank + " of " + suit;
}

public int getValue() {
if (rank.equals("Ace")) {
return 11; // For simplicity, we'll treat Ace as 11
} else if (rank.equals("Jack") || rank.equals("Queen") || rank.equals("King")) {
return 10;
} else {
return Integer.parseInt(rank);
}
}
}