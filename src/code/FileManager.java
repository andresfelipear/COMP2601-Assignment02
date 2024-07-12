import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Main
 *
 * @author Andres Arevalo
 * @version 1.0
 */
public class FileManager
{
    private final List<Integer> oddNumbers;
    private final List<Integer> evenNumbers;

    private FileReader fr;

    private static final String ERROR_READING_FILE;
    private static final String ERROR_CLOSING_FILE;
    private static final String FILE_NAME;

    static
    {
        FILE_NAME = "numbers.txt";
        ERROR_CLOSING_FILE = "Error closing the file";
        ERROR_READING_FILE = "Error reading file";
    }

    public static void main(String[] args)
    {
        System.out.println("Hello World!");
        FileManager fm;
        fm = new FileManager();

        fm.readFileAndSaveNumbers();
        System.out.println("Odd Numbers");
        System.out.println(fm.getOddNumbers());

        System.out.println("\nEven Numbers");
        System.out.println(fm.getEvenNumbers());
    }

    public FileManager()
    {

        oddNumbers = new ArrayList<>();
        evenNumbers = new ArrayList<>();
    }

    private void readFileAndSaveNumbers()
    {
        final Scanner scanner;
        List<String> numbers;
        String       line;

        try
        {
            fr = new FileReader(FILE_NAME);
            scanner = new Scanner(fr);

            while(scanner.hasNextLine())
            {
                line = scanner.nextLine();
                numbers = Arrays.stream(line.split("\\s+")).toList();
                numbers.stream()
                       .mapToInt(Integer::parseInt)
                       .forEach(num ->
                                {
                                    if(num % 2 == 0)
                                    {
                                        evenNumbers.add(num);
                                    }
                                    else
                                    {
                                        oddNumbers.add(num);
                                    }
                                });
            }
        }
        catch(final Exception e)
        {
            System.out.println(ERROR_READING_FILE);
            System.out.println(e.getMessage());
        }
        finally
        {
            if(fr != null)
            {
                try
                {
                    fr.close();
                }
                catch(final Exception e)
                {
                    System.out.println(ERROR_CLOSING_FILE);
                }
            }
        }
    }

    public List<Integer> getOddNumbers()
    {
        return oddNumbers;
    }

    public List<Integer> getEvenNumbers()
    {
        return evenNumbers;
    }
}
