/*Task 2: Number Guessing Game
- Objective: Develop a simple number guessing game in Java.
- Functionality: The computer generates a random number, and the user has to guess it.
- Details: Your game should generate a random number between a specified range (e.g., 1 to 100). The user will input their guess, and your program should provide feedback on whether the guess is too high, too low, or correct. Keep track of the number of attempts the user makes and display it when they guess correctly.*/

import java.util.Random;
import java.util.Scanner;
public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.println("enter the upper and lower limit :");
        int lowerlimit = scanner.nextInt();
        int upperlimit = scanner.nextInt();
        int numberToGuess = random.nextInt(upperlimit - lowerlimit + 1) + lowerlimit;
        int numberOfAttempts = 0;
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I've selected a random number between " + lowerlimit + " and " + upperlimit + ". Try to guess it.");
        while (true) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            numberOfAttempts++;
            if (userGuess < lowerlimit || userGuess > upperlimit) {
                System.out.println("Please enter a number between " + lowerlimit + " and " + upperlimit + ".");
            } else if (userGuess < numberToGuess) {
                System.out.println("Too low! Try again.");
            } else if (userGuess > numberToGuess) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Congratulations! You guessed the number " + numberToGuess + " in " + numberOfAttempts + " attempts.");
                break;
            }
        }
        scanner.close();
    }
}
