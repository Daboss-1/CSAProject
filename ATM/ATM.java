import java.util.Scanner;
public class ATM {

  private static double balance = 1000;
  private static double oldAmount;
  private static double money = 1000;
  
  public static void setAmount(double amount)
  {
    balance = amount;
    money = amount;
  }

  public static double getBalance()
  {
    return balance;
  }

  public static void addAmount(double amount){
    if(amount > 0){
      money += amount;
    }
    else{
      System.out.print("Choose positive number");
    }
  }
  public static void removeAmount(double amount){
    if(amount > 0){
      money -= amount;
    }
     else{
      System.out.print("Choose positive number");
    }
  }
  public static void deposit(double amount){
    if(amount > money){
      System.out.println("You don't have enough money to deposit " + amount + " dollars");
    }
  else if(amount > 0){
      balance += amount;
      oldAmount = amount;
       money -= amount;
    }
    else{
  System.out.println("Error: Pick number greater than 0");
      }
  }
    public static void withdraw(double amount){
      if(amount > balance){
      System.out.println("Your balance is too low to withdraw " + amount + " dollars");
    }
   else if(amount > 0){
      balance -= amount;
      oldAmount = -amount;
      money += amount;
    }
      else{
        System.out.println("Error: Pick number greater than 0");
      }
 }
public static void getPreviousTransaction(){
  if(oldAmount > 0){
    System.out.println("Deposited " + oldAmount);
  }
  else if(oldAmount < 0){
    System.out.println("Withdrew " + Math.abs(oldAmount));
  }
  else{
    System.out.println("There has not been a transaction");
  }
}
  public static void menu(){
    String choice = "";
    Scanner scanner = new Scanner(System.in);
System.out.println("\n");
System.out.println("****************************************");
System.out.println("Welcome");
System.out.println("A. Check balance");
System.out.println("B. Check money in hand");
System.out.println("C. Withdraw");
System.out.println("D. Deposit");
System.out.println("E. Previous Deposit / Withdrawal");
System.out.println("F. Sign out");
System.out.println("****************************************");
    
    do{
      System.out.println("Enter choice");
      choice = scanner.next().substring(0,1);
      
    switch(choice){
        
      case "A":
  System.out.println("****************************************");
System.out.println("Balance = " + balance);
  System.out.println("****************************************");
break;
      case "B":
 System.out.println("****************************************");
System.out.println("Money in Hand = " + money);
  System.out.println("****************************************");       
        break;
  case "C":
        System.out.println("****************************************");
     System.out.println("Enter amount to withdraw");
       int amountOne = scanner.nextInt();
        withdraw(amountOne);
        System.out.println("****************************************");
break;
  case "D":
        System.out.println("****************************************");
        System.out.println("Enter amount to deposit");
        int amountTwo = scanner.nextInt();
        deposit(amountTwo);
        System.out.println("****************************************");
        break;
  case "E":
        System.out.println("****************************************");
      getPreviousTransaction();
        System.out.println("****************************************");
  break;
    case "F":
        break;
    default:
        System.out.println("****************************************");
        System.out.println("Invalid");
        System.out.println("****************************************");
        break;
     }
    } 
      while(!choice.equals("F"));
  System.out.println("****************************************");
  System.out.println("Thank you for using the ATM!");
  System.out.println("Current Amount in account: " + balance);
      System.out.println("Current Amount in hand: " + money);
  System.out.println("****************************************");
  scanner.close();
    }
  } 
