// Author: Aman Kumar
// Project: Number Guessing Game - OIBSIP Task 1

import java.util.Random;
import java.util.Scanner;

public class NumberGuess {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("===== Welcome to Number Guessing Game =====");
        System.out.println("I have picked a number between 1 and 100.");
        System.out.println("Can you guess it? You have 10 attempts.\n");

        int numberToGuess = rand.nextInt(100) + 1; // 1 to 100
        int attempts = 0;
        int maxAttempts = 10;
        boolean hasWon = false;

        while (attempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            
            if (!sc.hasNextInt()) {
                System.out.println("Please enter a valid number!");
                sc.next(); // skip invalid input
                continue;
            }

            int guess = sc.nextInt();
            attempts++;

            if (guess == numberToGuess) {
                hasWon = true;
                break;
            } else if (guess < numberToGuess) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too high! Try again.");
            }

            System.out.println("Attempts left: " + (maxAttempts - attempts));
        }

        if (hasWon) {
            System.out.println("\n🎉 Congratulations! You guessed the number in " + attempts + " attempts.");
        } else {
            System.out.println("\n😢 Sorry! You ran out of attempts. The number was: " + numberToGuess);
        }

        sc.close();
    }
}
