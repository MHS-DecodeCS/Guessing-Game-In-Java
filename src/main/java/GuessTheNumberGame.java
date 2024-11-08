import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {
    private final Scanner scanner = new Scanner(System.in); 

    public int getPlayerGuess() {
        int guess = 0;
        boolean validInput = false;
        while (!validInput) {
            System.out.print("Enter your guess (1-100): ");
            if (scanner.hasNextInt()) {
                guess = scanner.nextInt();
                if (guess >= 1 && guess <= 100) {
                    validInput = true;
                } else {
                    System.out.println("Please enter a number between 1 and 100.");
                }
            } else {
                System.out.println("Invalid input! Please enter an integer.");
                scanner.next(); 
            }
        }
        return guess;
    }

    public int getComputerGuess() {
        Random random = new Random();
        return random.nextInt(100) + 1; 
    }

    public void playGame() {
        int targetNumber = getComputerGuess();
        int attempts = 0;
        boolean hasWon = false;

        System.out.println("Welcome to the Guess the Number Game! Try to guess the number between 1 and 100.");

        while (!hasWon) {
            int playerGuess = getPlayerGuess();
            attempts++;

            if (playerGuess < targetNumber) {
                System.out.println("Too Low!");
            } else if (playerGuess > targetNumber) {
                System.out.println("Too High!");
            } else {
                hasWon = true;
                System.out.println("Congratulations! You've guessed the number in " + attempts + " attempts.");
            }
        }
        scanner.close(); 
    }
}
