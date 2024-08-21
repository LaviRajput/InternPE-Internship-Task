import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class GuessRandomNumber {
    public static void main(String[] args) {
        Random random=new Random();
        int randomNumber=random.nextInt(100)+1;
        Scanner scanner=new Scanner(System.in);
        int chance=5;
        System.out.println("Guess the number between 1  to 100.you have to 5 Chance only ");
        while(chance>0){
            System.out.println("Guess the  Number");
            int guess= scanner.nextInt();
            // Ternary Operator
            String result=(guess==randomNumber)?"Congratulation!You Guessed It right"
                    :(guess<randomNumber)?"Try Again your guess is too low.":"Your guess is too high";
            System.out.println(result);
            if(guess==randomNumber)
                break;
            chance--;
        }
        
        if(chance==0)
            System.out.println("Sorry, you ranout the chance Try Again! ");
    }
    Scanner close;

}
