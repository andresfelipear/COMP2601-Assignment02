import org.junit.Test;
import org.junit.jupiter.api.Assertions;

/**
 * Tests
 *
 * @author Andres Arevalo
 * @version 1.0
 */
public class Assignment02Tests
{
    @Test
    public void testLoggerInstance()
    {
        // Test Part 3: Secret Keeper (Singleton Design Pattern)
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        Assertions.assertSame(logger1,
                              logger2);
    }

    @Test
    public void testConcurrency()
    {
        // Test Part 4: Speed Counter (Concurrency)
        Counter  counter    = new Counter();
        int      numThreads = 5;
        Thread[] threads    = new Thread[numThreads];
        for(int i = 0; i < numThreads; i++)
        {
            threads[i] = new Thread(() ->
                                    {
                                        for(int j = 0; j < 1000; j++)
                                        {
                                            counter.increment();
                                        }
                                    });
            threads[i].start();
        }
        for(Thread thread : threads)
        {
            try
            {
                thread.join();
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        Assertions.assertEquals(5000, counter.getCount());
    }
}
