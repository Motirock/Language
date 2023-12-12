package language;
import java.util.ArrayList;

public class Word {
    public ArrayList<String> previousVersions = new ArrayList<String>();
    public ArrayList<Syllable> syllables = new ArrayList<Syllable>();

    public Word(ArrayList<Syllable> syllables) {
        this.syllables = syllables;
    }

    public String toString() {
        String r = "";
        for (Syllable s : syllables)
            r += s.string;
        return r;
    }

    public void mutate(Language language) {
        double chanceOfAdd = 0.5;
        double chanceOfRemove = 0.1;

        double randomValue = language.randomDouble();
        boolean tryAdd = randomValue < chanceOfAdd;
        boolean tryRemove = randomValue >= chanceOfAdd && randomValue < chanceOfAdd+chanceOfRemove;
        
        previousVersions.add(this.toString());

        if (tryAdd && syllables.size() < language.maxWordLengthSyllables) {
            syllables.add((int) (language.randomDouble()*syllables.size()), new Syllable(language));
        }
        else if (tryRemove && syllables.size() > 1) {
            syllables.remove((int) (language.randomDouble()*syllables.size()));
        }
        else {
            syllables.set((int) (language.randomDouble()*syllables.size()), new Syllable(language));
        }
    }

    public String getEtymology() {
        String r = "";
        for (String previousVersion : previousVersions) {
            r += previousVersion + " --> ";
        }
        r += this.toString();
        return r;
    }
}