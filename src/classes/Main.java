package classes;

import classes.hangman.DifficultyLevel;
import classes.hangman.DifficultyLevelFactory;
import classes.hangman.Game;
import classes.hangman.HangmanGame;

import java.util.Scanner;

// Starts a hangman game instance
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Hangman!");

        int difficultyChoice = HangmanGame.getDifficultyChoice(scanner);

        DifficultyLevelFactory levelFactory = new DifficultyLevelFactory();
        DifficultyLevel difficultyLevel = levelFactory.createDifficultyLevel(difficultyChoice);
        String[] words = difficultyLevel.getWords();

        String wordToGuess = HangmanGame.getRandomWord(words);
        String category = HangmanGame.getCategory(difficultyChoice);

        System.out.println("Category: " + category);

        Game game = new Game(wordToGuess);

        game.play();

        System.out.println("Thank you for playing Hangman!");
        scanner.close();
    }
}
