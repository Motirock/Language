import java.util.ArrayList;

public class Word {
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
}