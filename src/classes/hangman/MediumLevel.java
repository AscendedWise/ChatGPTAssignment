package classes.hangman;

// Holds every Medium modes words
public class MediumLevel implements DifficultyLevel {
    private static final String[] WORDS = {"cherry", "orange"};

    @Override
    public String[] getWords() {
        return WORDS;
    }
}