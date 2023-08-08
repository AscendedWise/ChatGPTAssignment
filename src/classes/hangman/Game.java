package classes.hangman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    // The internal game controller
    private static final int MAX_TRIES = GameConfiguration.getInstance().getMaxTries();
    private String wordToGuess;
    private char[] guessedLetters;
    private List<Character> previousGuesses;
    private int triesLeft;
    private long startTime;

    // Sets up the games attributes when ran
    public Game(String wordToGuess) {
        this.wordToGuess = wordToGuess;
        this.guessedLetters = new char[wordToGuess.length()];
        this.previousGuesses = new ArrayList<>();
        this.triesLeft = MAX_TRIES;
        this.startTime = System.currentTimeMillis();
    }

    // Starts a game instance
    public void play() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Hangman!");
        System.out.println("Category: Fruits"); // You can replace this with the actual category.

        while (true) {
            displayHangman(triesLeft);
            displayWord();
            displayPreviousGuesses();

            if (hasWon()) {
                System.out.println("Congratulations! You've guessed the word: " + wordToGuess);
                displayGameStats();
                break;
            }

            if (triesLeft == 0) {
                System.out.println("Game Over! The word was: " + wordToGuess);
                displayGameStats();
                break;
            }

            System.out.print("Enter a letter: ");
            char guess = scanner.next().charAt(0);

            if (!isLetterValid(guess)) {
                System.out.println("Invalid input. Please enter a valid letter.");
                continue;
            }

            if (isLetterGuessed(guess)) {
                System.out.println("You already guessed this letter.");
                continue;
            }

            previousGuesses.add(guess);

            if (!isLetterInWord(guess)) {
                triesLeft--;
                System.out.println("Incorrect guess. Tries left: " + triesLeft);
            }

            updateGuessedLetters(guess);
        }

        scanner.close();
    }

    // Displays the hangman for the game
    private void displayHangman(int incorrectGuesses) {
        System.out.println("  ________     ");
        System.out.println("  |      |     ");
        switch (incorrectGuesses) {
            case 6 -> {
                System.out.println("  |            ");
                System.out.println("  |            ");
                System.out.println("  |            ");
            }
            case 5 -> {
                System.out.println("  |      O     ");
                System.out.println("  |            ");
                System.out.println("  |            ");
            }
            case 4 -> {
                System.out.println("  |      O     ");
                System.out.println("  |      |     ");
                System.out.println("  |            ");
            }
            case 3 -> {
                System.out.println("  |      O     ");
                System.out.println("  |     /|     ");
                System.out.println("  |            ");
            }
            case 2 -> {
                System.out.println("  |      O     ");
                System.out.println("  |     /|\\   ");
                System.out.println("  |            ");
            }
            case 1 -> {
                System.out.println("  |      O     ");
                System.out.println("  |     /|\\   ");
                System.out.println("  |     /      ");
            }
            case 0 -> {
                System.out.println("  |      O     ");
                System.out.println("  |     /|\\   ");
                System.out.println("  |     / \\   ");
            }
        }
        System.out.println(" _|___         ");
    }

    // Displays the word
    private void displayWord() {
        for (char letter : guessedLetters) {
            if (letter == 0) {
                System.out.print("_ ");
            } else {
                System.out.print(letter + " ");
            }
        }
        System.out.println();
    }
 // Displays the previous guesses
    private void displayPreviousGuesses() {
        System.out.print("Previous guesses: ");
        for (char guess : previousGuesses) {
            System.out.print(guess + " ");
        }
        System.out.println();
    }

    // Determines if they won or loss
    boolean hasWon() {
        for (char letter : guessedLetters) {
            if (letter == 0) {
                return false;
            }
        }
        return true;
    }

    //
    private boolean isLetterValid(char letter) {
        return Character.isLetter(letter);
    }

    private boolean isLetterGuessed(char letter) {
        return previousGuesses.contains(letter);
    }

    private boolean isLetterInWord(char letter) {
        return wordToGuess.indexOf(letter) >= 0;
    }

    private void updateGuessedLetters(char letter) {
        for (int i = 0; i < wordToGuess.length(); i++) {
            if (wordToGuess.charAt(i) == letter) {
                guessedLetters[i] = letter;
            }
        }
    }

    // Keeps track of the games time
    private void displayGameStats() {
        long endTime = System.currentTimeMillis();
        long elapsedTime = (endTime - startTime) / 1000; // Time elapsed in seconds
        System.out.println("Game completed in " + elapsedTime + " seconds.");
    }
}
