package language;
public class Syllable {
    String string = "";

    public Syllable(Language language) {
        boolean startsWithConsonant = language.randomDouble() < language.consonantStartsSyllable;
        boolean endsWithConsonant = language.randomDouble() < language.consonantEndsSyllable;
        String startingConsonant, vowel, endingConsonant;
        if (startsWithConsonant) {
            startingConsonant = language.consonants.get((int) (language.randomDouble()*language.consonants.size()));
            string += startingConsonant;
        }
        vowel = language.vowels.get((int) (language.randomDouble()*language.vowels.size()));
        string += vowel;
        if (endsWithConsonant) {
            endingConsonant = language.consonants.get((int) (language.randomDouble()*language.consonants.size()));
            string += endingConsonant;
        }
    }
}