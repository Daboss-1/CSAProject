import java.util.Scanner;
import java.util.ArrayList;

/**
 * A class to represent the Roulette Game
 * Call the playGame() method with an argument of the amount of starting money
 */
public class Roulette {
  ArrayList<String> guesses;
  ArrayList<Double> bets;
  ArrayList<Integer> guessedNumbers;
  boolean finishedGuessing;
  double money;
  double payout;
  Scanner scanner;
  RouletteSpace number;
  RouletteSpace previousNumber;
  int[] redNumbers = {1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36};
  int[] blackNumbers = {2, 4, 6, 8, 10, 11, 13, 15, 17, 20, 22, 24, 26, 28, 29, 31, 33, 35};
  
  public Roulette(){
    scanner = new Scanner(System.in);
  }

  private String checkColor(int number){
    if(number == 0){
      return "green";
    }
    for(int num : redNumbers){
      if(num == number){
        return "red";
      }
    }
    return "black";
  }
  
  private RouletteSpace generateNumber(){
    int number = (int)(Math.random() * 37);
    System.out.println("------------------------\nSpinning wheel...\nIt landed on: " + number + " (" + checkColor(number) + ")");
    return new RouletteSpace(number, checkColor(number));
  }
  
  public void playGame(double startingMoney){
    money = startingMoney;
    number = generateNumber();
    previousNumber = new RouletteSpace(-1, "");
    while(money >= 0.01){
      guessedNumbers = new ArrayList<Integer>();
      guesses = new ArrayList<String>();
      bets = new ArrayList<Double>();
      finishedGuessing = false;
      while(!finishedGuessing){
        System.out.println("You have: $" + roundToCent(money - totalBets()));
        System.out.print("Would you like to bet on higher, lower, odd, even, red, black, or number? ");
        String currentGuess = scanner.next().toLowerCase();
        guesses.add(currentGuess);
        if(currentGuess.equals("number")){
          System.out.print("What number would you like to bet on? ");
          guessedNumbers.add(scanner.nextInt());
        } else {
          guessedNumbers.add(new Integer(-1));
        }
        System.out.print("How much would you like to bet? ");
        double currentBet = roundToCent(scanner.nextDouble());
        while(currentBet > money - totalBets()){
          System.out.print("You don't have that much money\nHow much would you like to bet? ");
          currentBet = roundToCent(scanner.nextDouble());
        }
        bets.add(roundToCent(currentBet));
        if(money - totalBets() >= 0.01){
          System.out.print("Would you like to bet again? (yes/no) ");
          if(scanner.next().equals("no")){
            finishedGuessing = true;
          }
        } else {
          finishedGuessing = true;
        }
      }
      previousNumber = number;
      number = generateNumber();
      payout = 0.0;
      for(int i = 0; i < guesses.size(); i++){
        payout(i);
      }
      money += payout;
      if(payout > 0){
        System.out.println("Nice job! You made $" + payout + " that round!");
      } else {
        System.out.println("Ouch... You lost $" + Math.abs(payout) + " that round");
      }
    }
    System.out.println("YOU GOT NO MONEY L BOZO HAHAHAHA");
  }

  private double roundToCent(double number){
    return Math.round(number * 100)/100.0;
  }

  private void payout(int i){
    String guess = guesses.get(i);
    double bet = bets.get(i).doubleValue();
    int guessedNumber = guessedNumbers.get(i).intValue();
    if((guess.equals("red") || guess.equals("black")) && guess.equals(number.getColor())){
      bet = roundToCent(bet * 2 - bet);
      payout += bet;
    } else if(guess.equals("higher") && number.getNumber() > previousNumber.getNumber()){
      bet = roundToCent(bet * (37.0 / (37 - previousNumber.getNumber())) - bet);
      payout += bet;
    } else if(guess.equals("lower") && number.getNumber() < previousNumber.getNumber()){
      bet = roundToCent(bet * 37.0 / previousNumber.getNumber() - bet);
      payout += bet;
    } else if(guess.equals("number") && number.getNumber() == guessedNumber){
      bet = roundToCent(bet * 36 - bet);
      payout += bet;
    } else if((guess.equals("odd") && number.getNumber() % 2 == 1) || (guess.equals("even") && number.getNumber() % 2 == 0)){
      bet = roundToCent(bet * 2 - bet);
      payout += bet;
    } else {
      payout -= bet;
    }
  }

  private double totalBets(){
    double sum = 0.0;
    for(double bet : bets){
      sum += bet;
    }
    return sum;
  }
}