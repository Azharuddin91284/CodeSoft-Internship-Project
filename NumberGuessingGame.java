package CodeSoftTask;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int minRange = 1;
        int maxRange = 100;
        int attempts = 0;
        int score = 0;
        
        System.out.println("Welcome to the Number Guessing Game!");
        
        boolean playAgain = true;
        while (playAgain) {
            int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int userGuess;
            boolean hasGuessedCorrectly = false;
            
            System.out.println("I've selected a random number between " + minRange + " and " + maxRange + ". Try to guess it!");
            
            while (!hasGuessedCorrectly) {
                System.out.print("Enter your guess: ");
                userGuess = scanner.nextInt();
                attempts++;
                
                if (userGuess == randomNumber) {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    score++;
                    hasGuessedCorrectly = true;
                } else if (userGuess < randomNumber) {
                    System.out.println("Try a higher number.");
                } else {
                    System.out.println("Try a lower number.");
                }
            }
            
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainResponse = scanner.next().toLowerCase();
            if (!playAgainResponse.equals("yes")) {
                playAgain = false;
            }
        }
        
        System.out.println("Game Over! Your final score is: " + score + " rounds won.");
        scanner.close();
    }
}

