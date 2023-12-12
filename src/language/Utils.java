package language;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Utils {
    public static final String[] phonemesArray = {"a", "b", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "r", "s", "t", "u", "v", "w", "y", "z", "θ", "∫", "ð", "ɹ", "ʒ", "ʔ", "œ", "ø", "ɔ", "λ"};
    public static final String[] vowelsArray = {"a", "e", "i", "o", "u", "y", "ə", "ɛ", "œ", "ɔ", "ø"};
    public static final String[] consonantsArray = {"b", "d", "f", "g", "h", "j", "k", "l", "m", "n", "p", "r", "s", "t", "v", "w", "z", "θ", "∫", "ð", "ɹ", "ʒ", "ʔ", "λ"};
    public static final ArrayList<String> phonemes = new ArrayList<String>(Arrays.asList(phonemesArray));
    public static final ArrayList<String> vowels = new ArrayList<String>(Arrays.asList(vowelsArray));
    public static final ArrayList<String> consonants = new ArrayList<String>(Arrays.asList(consonantsArray));

    public static boolean isPhoneme(String string) {
        if (string.length() != 1)
            return false;
        for (String phoneme : phonemes)
            if (phoneme.equals(string))
                return true;
        return false;
    }

    static long seed = 0;
    static Random random = new Random(seed);
    static public double randomDouble() {
        return random.nextDouble();
    }
}
