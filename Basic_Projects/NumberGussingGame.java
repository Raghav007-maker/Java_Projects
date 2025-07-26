package Basic_Projects;

import java.util.Random;
import java.util.Scanner;

public class NumberGussingGame {
    public static void main(String[] args) {
        // step-1 Generate The random Number
        // Step-2 Taking User Input
        // Step-3 Validating the Guess
        // Step-4 Checking User Input 
        // Step-5 Show The Results
        
        int SecretNumber=GenerateRandomNumber();
        UserNumber(SecretNumber);
    }

    public static String Checking(int Guess,int SecretNumber){
        if(Guess==SecretNumber){
            return "Right";
        }
        else if(Math.abs(Guess-SecretNumber)<=10)
        return "Hot";
        
        return "cold";
    }

    public static void ShowResult(String answer){

        if("Right".equals(answer)) {
            System.out.println("Congratulations! You guessed the correct number.");
        } else if ("Hot".equals(answer)) {
            System.out.println("Hot! You are very close.");
        } else {
            System.out.println("Cold! Try again.");
        }
        System.out.println();


    }
    public static void UserNumber(int SecretNumber){
        System.out.println("Let,s Start The Gussing Game");
        int Guess=-1;
        int Chances=8;
        
        while(Guess!=SecretNumber && Chances!=0){
            System.out.println("You Have "+Chances+" To Guess The Number");
            System.out.print("Pls Enter The Number:");
            Scanner sc=new Scanner(System.in);
            Guess=sc.nextInt();
            if(Validate(Guess)){
                    String check=Checking(Guess,SecretNumber);
                    ShowResult(check);
            }
            else{
                System.out.println("Invalid Input, Enter The Number B/w 1-100");
    
            }
            Chances--;
        }
        
    }
    public static boolean Validate(int guess){
        if(guess>=1 && guess<=100) return true;
        return false;
        
    }
    
    
    public static int GenerateRandomNumber(){
        // int randomNum = rand.nextInt(100); // Generates a number between 0 and 99
        int min=1;
        int max=100;
        Random random=new Random();

        int randomNum=random.nextInt((max-min+1)+min);
        // nextInt(bound) generates integers from 0 (inclusive) to bound (exclusive).
        // take the example as min=10, max=50;
        // (50-10+1)----->41 give random number from [0,40] and adding min to set he random number in range
        // System.out.println(randomNum);
        return randomNum;
    }
}
