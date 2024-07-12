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

    private Logger()
    {
        logs = new ArrayList<>();
    }

    public static Logger getInstance()
    {
        if(logger == null)
        {
            logger = new Logger();
        }
        return logger;
    }

    public void recordNumber(final int number)
    {
        logs.add(number);
    }

    public List<Integer> getLogs()
    {
        return logs;
    }
}
