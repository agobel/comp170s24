import java.io.FileNotFoundException;
import java.io.File;
import java.util.Random;
import java.util.Scanner;

public class A06Solution {
    public static void main(String[] args) {
        Random rand = new Random();
        // Get a random number between 0 and 10
        int randomNumber = rand.nextInt(11);
        // Connect a scanner to the keyboard
        Scanner sc = new Scanner(System.in);
        // Define a boolean variable to control a loop asking user to guess a numer
        boolean correct = false;
        // Define an int variable to capture the guessed value
        int guess = 0;
        // Run the loop for as long as the user guesses the wrong number. Also provide an
        // escape option: when user enters -1, the loop ends.
        while (!correct && guess > -1) {
            // Prompt the user
            System.out.print("\nGuess what number (between 0 and 10) I have in mind? ");
            // Grab the user's guess
            guess = sc.nextInt();
            // Determine if user guessed correctly
            correct = (guess == randomNumber);
            // If not correct, offer the user another round and also remind them
            // how to end the game by entering -1
            if (!correct) {
                System.out.println("Nope... that was not it. Try again or enter -1 to exit.");
            }
        }
        // Done with guessing game. Did the loop end because the guess was correct
        // or because the user entered -1 to finish the game?
        if (guess == -1) {
            // Game ented because user enters -1
            System.out.println("\nOK, if you want to give up, here's the answer: " + randomNumber);
        } else {
            // Game ented because user guessed correctly
            System.out.println("\nNice job reading (computer) minds!");
        }
        // Close the scanner
        sc.close();
    } // method main
}
