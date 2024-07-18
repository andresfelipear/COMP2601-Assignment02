import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

/**
 * CountingGame
 *
 * @author Andres Arevalo
 * @version 1.0
 */
public class CountingGame
{
    private List<String> vowels;
    private List<String> consonants;

    /**
     * Processes the input string to count vowels and consonants.
     * This method takes an input string, splits it into individual characters, and filters them
     * to identify vowels and consonants. It then stores the counts of each and returns an array
     * containing formatted strings representing the counts of vowels and consonants.
     *
     * @param input The input string to be analyzed.
     * @return A string array where the first element is the count of vowels and the second
     *         element is the count of consonants, both formatted as "Vowels: X" and "Consonants: Y".
     */
    public String[] play(final String input)
    {
        final List<String> letters;
        final String       regexConsonants;
        final String       regexVowels;
        final Pattern      patternConsonants;
        final Pattern      patternVowels;

        regexVowels     = "[aeiou]";
        regexConsonants = "[bcdfghjklmnpqrstvwxyz]";

        patternConsonants = Pattern.compile(regexConsonants, Pattern.CASE_INSENSITIVE);
        patternVowels     = Pattern.compile(regexVowels, Pattern.CASE_INSENSITIVE);

        letters = Arrays.stream(input.split("")).toList();

        vowels = letters.stream()
                        .filter(Objects::nonNull)
                        .filter( letter -> patternVowels.matcher(letter).matches() )
                        .toList();

        consonants = letters.stream()
                            .filter(Objects::nonNull)
                            .filter( letter -> patternConsonants.matcher(letter).matches() )
                            .toList();

        return gameResultDetails();
    }

    /**
     * Generates the result details for the current input.
     * This method formats the counts of vowels and consonants into strings and returns them
     * in an array. The first element represents the number of vowels, and the second element
     * represents the number of consonants.
     *
     * @return A string array where the first element is the formatted count of vowels and the
     *         second element is the formatted count of consonants.
     */
    private String[] gameResultDetails()
    {
        final String numberVowels;
        final String numberConsonants;

        numberVowels = String.format("Vowels: %s", vowels.size());
        numberConsonants = String.format("Consonants: %s", consonants.size());
        return new String[] {numberVowels, numberConsonants};
    }

    /**
     * Retrieves the list of vowels found in the last processed input.
     *
     * @return A list of strings where each string is a vowel found in the last processed input.
     */
    public List<String> getVowels()
    {
        return vowels;
    }

    /**
     * Retrieves the list of consonants found in the last processed input.
     *
     * @return A list of strings where each string is a consonant found in the last processed input.
     */
    public List<String> getConsonants()
    {
        return consonants;
    }
}
