package crapsTable;

import java.util.Scanner;
import java.util.Random;

/**
 * This project is a simulation of how a craps table would operate in real life
 * @author nicolas.lankes
 */
public class CrapsTable {
    private static int numChips = 20;
    static boolean continueLoop = true;
    final static int LOW = 2;
    final static int HIGH = 12;
    
    public static void shootCraps(){
        System.out.println("How many chips would you like to bet?");
        Scanner scan = new Scanner(System.in);
        int placedBet = scan.nextInt();
        if (placedBet > numChips){
            System.out.println("Get more chips!");
            System.exit(0);
        } //end if
        numChips -= placedBet;
        System.out.println("Rolling Dice...");
        Random rand = new Random();
        int result = rand.nextInt(HIGH-LOW)+LOW;
        System.out.println("You rolled a " + result + ".");
        switch (result) {
            case 7:
                {
                    System.out.println("YOU WIN!!!");
                    int gainedChips = placedBet*2;
                    numChips += gainedChips;
                    break;
                }
            case 11:
                {
                    System.out.println("YOU WIN!!!");
                    int gainedChips = placedBet*2;
                    numChips += gainedChips;
                    break;
                }
            default:
                System.out.println("Sorry, you lose...");
                break; //end if/else
        }
        if (numChips <= 0){
            continueLoop = false;
        } //end if
    } //end method shootCraps
    
    public static void showStats(){
        System.out.println("*********************");
        System.out.println("You have " + numChips + " chips");
        int numDollars = numChips * 250;
        System.out.println("Each chip is worth $250");
        System.out.println("Which means that you have $" + numDollars);
        System.out.println("*********************");
    } //end method showStats
    
    public static void main(String[] args){
        System.out.println("Welcome to the craps table!");
        while(continueLoop){
            showStats();
            System.out.println("You need to roll a 7 or 11 to win!");
            shootCraps();
            showStats();
            System.out.println("Would you like to continue playing?");
            Scanner scan = new Scanner(System.in);
            String userResponse = scan.next();
            if(userResponse.equalsIgnoreCase("yes")){
                System.out.println("Starting Over...");
            } else {
                continueLoop = false;
            } //end if/else
        } //end continueLoop while
        System.out.println("Have a nice day!");
    } //end method main
    
} //end class CrapsTable
