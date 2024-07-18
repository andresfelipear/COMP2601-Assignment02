/**
 * Counter
 *
 * @author Andres Arevalo
 * @version 1.0
 */
public class Counter implements Runnable
{
    private int count;

    private static final int MAX_COUNT;

    static
    {
        MAX_COUNT = 5000;
    }

    {
        count = 0;
    }

    /**
     * Increments the count value up to MAX_COUNT.
     * This method is synchronized to ensure thread safety.
     */
    @Override
    public void run()
    {
        for(int i = 0; i < MAX_COUNT; i++)
        {
            increment();
        }
    }

    /**
     * Increments the counter value by one.
     * This method is synchronized to ensure that only one thread
     * can modify the count at a time, preventing race conditions.
     */
    public synchronized void increment()
    {
        count++;
    }

    /**
     * Returns the current count value.
     *
     * @return the current count value
     */
    public int getCount()
    {
        return count;
    }
}
