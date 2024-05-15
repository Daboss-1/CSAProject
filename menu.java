import java.util.Scanner;
public class menu {
    public static void menu(){
        String choice = "";
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n");
        System.out.println("****************************************");
        System.out.println("Welcome");
        System.out.println("A. Use ATM");
        System.out.println("B. Play Blackjack");
        System.out.println("C. Play Roulette");
        System.out.println("D. Play Slots");
        System.out.println("E. Play Craps");
        System.out.println("F. Coin Flip");
        System.out.println("G. Leave Casino");
        System.out.println("****************************************");

        do{
            System.out.println("Enter choice");
            choice = scanner.next().substring(0,1);

            switch(choice){

                case "A":
                ATM.menu();
                    break;
                case "B":

                    break;
                case "C":

                    break;
                case "D":

                    break;
                case "E":

                    break;
                case "F":
                    break;
                case "G":
                    break;
                default:
                    System.out.println("Invalid");
                    break;
            }
        }
        while(!choice.equals("G"));
        System.out.println("Thank you for playing at the casino!");
        scanner.close();
    }
}
