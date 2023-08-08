package classes.hangman;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    private Game game;

    @BeforeEach
    public void setUp() {
        String wordToGuess = "hangman";
        game = new Game(wordToGuess);
    }

    @Test
    public void testIncorrectLetterGuess() {
        InputStream inputStream = new ByteArrayInputStream("z\ny\nx\nw\nv\nt\n".getBytes());
        System.setIn(inputStream);

        game.play();

        assertFalse(game.hasWon());
    }

    @Test
    public void testMaxTriesReached() {
        InputStream inputStream = new ByteArrayInputStream("z\ny\nx\nw\nv\nt\nu\n".getBytes());
        System.setIn(inputStream);

        game.play();

        assertFalse(game.hasWon());
    }
}