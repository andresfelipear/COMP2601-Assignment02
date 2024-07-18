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

    private String[] gameResultDetails()
    {
        final String numberVowels;
        final String numberConsonants;

        numberVowels = String.format("Vowels: %s", vowels.size());
        numberConsonants = String.format("Consonants: %s", consonants.size());
        return new String[] {numberVowels, numberConsonants};
    }

    public List<String> getVowels()
    {
        return vowels;
    }

    public List<String> getConsonants()
    {
        return consonants;
    }
}
