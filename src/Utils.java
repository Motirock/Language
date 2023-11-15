import java.util.Random;

public class Utils {
    public static String[] phonemes = {"a", "b", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "r", "s", "t", "u", "v", "w", "y", "z", "θ", "∫", "ð", "ɹ", "ʒ"};
    public static String[] vowels = {"a", "e", "i", "o", "u", "y", "ə", "ɛ"};
    public static String[] consonants = {"b", "d", "f", "g", "h", "j", "k", "l", "m", "n", "p", "r", "s", "t", "v", "w", "z", "θ", "∫", "ð", "ɹ", "ʒ"};

    static long seed = 7;
    static Random random = new Random(seed);
    static public double randomGenerator() {
        return random.nextDouble();
    }
}
