package language;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Random;

public class Language {
    public String name = "NO_NAME";
    public ArrayList<String> allWordIDs = new ArrayList<String>();
    public Dictionary<String, Word> dictionary = new Hashtable<>();
    public ArrayList<Syllable> allSyllables = new ArrayList<Syllable>();
    public ArrayList<String> vowels = Utils.vowels, consonants = Utils.consonants;
    public int maxWordLengthSyllables = 1;
    public int totalSyllables = 1;
    public double consonantStartsSyllable = 0.5, consonantEndsSyllable = 0.5;

    public Language(String name, long seed, int maxWordLengthSyllables, int totalSyllables, double consonantStartsSyllable, double consonantEndsSyllable) {
        this.name = name;
        this.seed = seed;
        this.maxWordLengthSyllables = maxWordLengthSyllables;
        this.totalSyllables = totalSyllables;
    }

    public Language(String name, long seed, int maxWordLengthSyllables, int totalSyllables, 
        ArrayList<String> vowels, ArrayList<String> consonants,
        double consonantStartsSyllable, double consonantEndsSyllable) {
        this.name = name;
        this.seed = seed;
        this.maxWordLengthSyllables = maxWordLengthSyllables;
        this.totalSyllables = totalSyllables;
        this.vowels = vowels;
        this.consonants = consonants;
        this.consonantStartsSyllable = consonantStartsSyllable;
        this.consonantEndsSyllable = consonantEndsSyllable;
    }

    long seed = 0;
    Random random = new Random(seed);
    public double randomDouble() {
        return random.nextDouble();
    }

    public void createRandomWord(String wordID) {
        int syllableCount = (int) (randomDouble()*maxWordLengthSyllables)+1;
        ArrayList<Syllable> syllables = new ArrayList<Syllable>();
        for (int i = 0; i < syllableCount; i++)
            syllables.add(allSyllables.get((int) (randomDouble()*allSyllables.size())));
        dictionary.put(wordID, new Word(syllables));
    }

    public String getSentence(ArrayList<String> words) {
        String r = "";
        for (String wordID : words) {
            r += dictionary.get(wordID)+" ";
        }
        return r;
    }

    public void printSentence(ArrayList<String> words) {
        //for (String word : words)
        //    System.out.print(word + " ");
        //System.out.print("= ");
        System.out.println(getSentence(words));
    }

    public static void saveSentence(String sentence) {
        try {
            FileWriter myWriter = new FileWriter(System.getProperty("user.dir")+"/data/output.txt");
            myWriter.write(sentence);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void load() {
        BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(System.getProperty("user.dir")+"/data/words.txt"));
			String line = reader.readLine();

			while (line != null) {
				allWordIDs.add(line.toLowerCase());
				line = reader.readLine();
			}

			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

        for (int i = 0; i < totalSyllables; i++) {
            Syllable syllable = new Syllable(this);
            boolean isNew = true;
            for (Syllable otherSyllable : allSyllables) {
                if (otherSyllable == syllable) {
                    isNew = true;
                }
            }
            if (isNew)
                allSyllables.add(new Syllable(this));
            else
                i--;
        }

        for (String wordID : allWordIDs)
            createRandomWord(wordID);
    }
}
