package classes.hangman;

// Creates the difficulty levels can add more if wanted to
public class DifficultyLevelFactory {
    public DifficultyLevel createDifficultyLevel(int level) {
        return switch (level) {
            case 1 -> new EasyLevel();
            case 2 -> new MediumLevel();
            case 3 -> new HardLevel();
            default -> throw new IllegalArgumentException("Invalid difficulty level.");
        };
    }
}
