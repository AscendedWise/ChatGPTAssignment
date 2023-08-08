package classes.hangman;

public class GameConfiguration {
    private static GameConfiguration instance;
    private int maxTries;

    private GameConfiguration() {
        // Private constructor to prevent instantiation from outside the class.
        maxTries = 6; // Holds maximum attempts per game
    }

    public static GameConfiguration getInstance() {
        if (instance == null) {
            instance = new GameConfiguration();
        }
        return instance;
    }

    public int getMaxTries() {
        return maxTries;
    }

    public void setMaxTries(int maxTries) {
        this.maxTries = maxTries;
    }
}
