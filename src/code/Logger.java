import java.util.ArrayList;
import java.util.List;

/**
 * DataManager
 *
 * @author Andres Arevalo
 * @version 1.0
 */
public class Logger
{
    private final List<Integer> logs;

    private static Logger logger;

    /**
     * Private constructor to prevent direct instantiation.
     * Initializes the list of logs.
     */
    private Logger()
    {
        logs = new ArrayList<>();
    }

    /**
     * Provides access to the singleton instance of the Logger.
     * Creates a new instance if one does not already exist.
     *
     * @return the single instance of Logger
     */
    public static Logger getInstance()
    {
        if(logger == null)
        {
            logger = new Logger();
        }
        return logger;
    }

    /**
     * Records an integer into the log.
     *
     * @param number the integer to be recorded
     */
    public void recordNumber(final int number)
    {
        logs.add(number);
    }

    /**
     * Retrieves the list of recorded logs.
     *
     * @return a list of recorded integers
     */
    public List<Integer> getLogs()
    {
        return logs;
    }
}
