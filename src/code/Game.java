
/**
 * Game
 *
 * @author Andres Arevalo, Marius Guerra & Raaz
 * @version 1.0
 */
public interface Game
{
    /**
     * Plays the game with the given input.
     *
     * @param input The input for playing the game.
     * @return The result of the play.
     */
    String play(final int input);

    /**
     * Checks if the game is over.
     *
     * @return true if the game is over, false otherwise.
     */
    boolean isGameOver();

    /**
     * Restarts the game.
     */
    void restartGame();
}
