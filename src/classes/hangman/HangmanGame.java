package classes.hangman;

import java.util.Scanner;

public abstract class HangmanGame {

    // Gets the difficulty for the game
    public static int getDifficultyChoice(Scanner scanner) {
        int difficultyChoice;
        while (true) {
            System.out.println("Select difficulty level:");
            System.out.println("1. Easy");
            System.out.println("2. Medium");
            System.out.println("3. Hard");
            System.out.print("Enter the number corresponding to your choice: ");
            String input = scanner.next();
            try {
                difficultyChoice = Integer.parseInt(input);
                if (difficultyChoice >= 1 && difficultyChoice <= 3) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter a number between 1 and 3.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
        return difficultyChoice;
    }

    // Gets a random word for the start of the game
    public static String getRandomWord(String[] words) {
        int randomIndex = (int) (Math.random() * words.length);
        return words[randomIndex];
    }

    // Gets the category of the word Hard/Easy/Mediuem
    public static String getCategory(int difficultyChoice) {
        return switch (difficultyChoice) {
            case 1 -> "Fruits - Easy";
            case 2 -> "Fruits - Medium";
            case 3 -> "Fruits - Hard";
            default -> throw new IllegalArgumentException("Invalid difficulty choice.");
        };
    }

    // Other methods common to all HangmanGame implementations can be added here
}