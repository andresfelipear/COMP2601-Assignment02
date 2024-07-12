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

    @Override
    public void run()
    {
        for(int i = 0; i < MAX_COUNT; i++)
        {
            increment();
        }
    }

    public synchronized void increment()
    {
        count++;
    }

    public int getCount()
    {
        return count;
    }
}
