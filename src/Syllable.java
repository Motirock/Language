import java.util.Random;

public class Syllable {
    String string = "";

    public Syllable(String s) {
        string = s;
    }

    public Syllable() {
        boolean startsWithConsonant = Utils.randomGenerator() < 0.8;
        boolean endsWithConsonant = Utils.randomGenerator() < 0.6;
        if (startsWithConsonant)
            string += Utils.consonants[(int) (Utils.randomGenerator()*Utils.consonants.length)];
        string += Utils.vowels[(int) (Utils.randomGenerator()*Utils.vowels.length)];
        if (endsWithConsonant)
            string += Utils.consonants[(int) (Utils.randomGenerator()*Utils.consonants.length)];
    }
}