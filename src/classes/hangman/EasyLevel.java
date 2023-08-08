package classes.hangman;

// Holds every easy modes words
public class EasyLevel implements DifficultyLevel {
    private static final String[] WORDS = {"apple", "banana"};

    @Override
    public String[] getWords() {
        return WORDS;
    }
}