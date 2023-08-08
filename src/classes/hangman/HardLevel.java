package classes.hangman;

// Holds every Hard modes words
public class HardLevel implements DifficultyLevel {
    private static final String[] WORDS = {"grape"};

    @Override
    public String[] getWords() {
        return WORDS;
    }
}