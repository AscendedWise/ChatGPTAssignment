# Hangman Game Documentation

The Hangman Game is a text-based implementation of the classic Hangman word-guessing game. Players must guess letters of a secret word within a certain number of attempts to win the game.

## Table Of Contents

Any additional information goes here

## Project Structure
![Project Structure](https://i.imgur.com/dDEM4Pg.png)

- src/: This directory contains all the source code files for the Hangman game.
- classes.hangman/: This package (namespace) contains the main Hangman game classes.
- GameConfiguration.java: Singleton pattern implementation for the game configuration.
- Game.java: The main class responsible for running the game loop.
- DifficultyLevel.java: The interface for difficulty levels.
- EasyLevel.java: Implementation of the DifficultyLevel interface for the easy level.
- MediumLevel.java: Implementation of the DifficultyLevel interface for the medium level.
- HardLevel.java: Implementation of the DifficultyLevel interface for the hard level.
- DifficultyLevelFactory.java: Factory pattern implementation for creating difficulty levels.
- HangmanGame.java: The main class where the Hangman game logic is implemented.
- Main.java: The main entry point of the program to start the Hangman game.

# Design Patterns
### Factory Method Pattern
The DifficultyLevelFactory class follows the Factory Method design pattern. It encapsulates the creation of DifficultyLevel objects based on the chosen difficulty level. By using a factory, we can create different implementations of DifficultyLevel based on the user's input, promoting a more flexible and scalable solution for adding new difficulty levels in the future.

### Singleton Pattern
The Singleton pattern ensures that a class has only one instance and provides a global point of access to that instance. In the context of the Hangman game, we use the Singleton pattern for the game configuration, so we can have a single instance of the configuration throughout the game.

# How to Play
1. Run the Main.java file, and the game will display a welcome message and ask you to choose a difficulty level (easy, medium, or hard).
2. After choosing the difficulty level, the game will randomly select a word from the corresponding word list.
3. The game displays the category of the word, and you must start guessing letters one by one.
4. Enter a letter, and the game will inform you if the letter is correct or not. If correct, the letter will be revealed in the word.
5. The game provides feedback on incorrect guesses and the number of attempts left.
6. Continue guessing until you either guess the word correctly or run out of attempts.
7. At the end of the game, the result will be displayed along with the time taken to complete the game.

# Features
## Adding New Categories and Words
To add new categories and words to the game:
1. Open the HardLevel.java, Medium.java, EasyLevel.java files in the classes.hangman package.
2. Adds the words you want under the String Words[]
3. ![Words Image](https://i.imgur.com/98NgPqp.png)

## Editing Maximum Tries
You can also edit the maximum tries you have per game by increasing the number under GameConfigurations.java
![Words Image](https://i.imgur.com/9oWOA6o.png)

## Credits
This Hangman Game was implemented by Harrison Onah as part of a project or learning exercise.

##### Note
- There was no violation of SOLID or CA.