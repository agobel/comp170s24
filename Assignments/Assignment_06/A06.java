import java.io.FileNotFoundException;
import java.io.File;
import java.util.Random;
import java.util.Scanner;

public class A06 {
    public static void main(String[] args) {
        Random rand = new Random();
        // Get a random number between 0 and 99
        int randomNumber = rand.nextInt(100);
        // Connect a scanner to the keyboard
        Scanner sc = new Scanner(System.in);

        int guess; //stores the user's guess
        boolean correct = false; //tracks if the guess is correct

        while (sc.nextInt()){ 
            // asks user to enter a guess
            System.out.print("Enter guess (between 0 and 99, or -1 to quit): ");
            guess = sc.nextInt();

            if (guess == -1){
                // user terminates execution
                System.out.println("User quits");
                break;
            } else if (guess < 0 || guess > 99) {
                // guess is not in between 0 and 99
                System.out.println("Invalid guess");
            } else if (guess < randomNumber) {
                // guess is lower than the random number
                System.out.println("Guess is too low");
            } else if (guess > randomNumber) {
                // guess is higher than the random number
                System.out.println("Guess is too high");
            } else {
                // user guesses the random number
                System.out.println("You guessed correct");
                correct = true;
            }
        }
        
        // Close the scanner
        sc.close(); 
    } // method main
}
