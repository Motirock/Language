import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import java.util.Dictionary;
import java.util.Hashtable;

import java.io.IOException;

public class Main {
    static ArrayList<String> allWordIDs = new ArrayList<String>();
    static Dictionary<String, Word> dictionary = new Hashtable<>();
    static ArrayList<Syllable> allSyllables = new ArrayList<Syllable>();
    final static int maxWordLengthSyllables = 3;
    final static int totalSyllables = 30;

    public static void createRandomWord(String wordID) {
        int syllableCount = (int) (Utils.randomGenerator()*maxWordLengthSyllables)+1;
        ArrayList<Syllable> syllables = new ArrayList<Syllable>();
        for (int i = 0; i < syllableCount; i++)
            syllables.add(allSyllables.get((int) (Utils.randomGenerator()*allSyllables.size())));
        dictionary.put(wordID, new Word(syllables));
    }

    public static String getSentence(ArrayList<String> words) {
        String r = "";
        for (String wordID : words) {
            r += dictionary.get(wordID)+" ";
        }
        return r;
    }

    public static void printSentence(ArrayList<String> words) {
        for (String word : words)
            System.out.print(word + " ");
        System.out.print("= ");
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

    public static void main(String[] args) throws Exception {
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
            Syllable syllable = new Syllable();
            boolean isNew = true;
            for (Syllable otherSyllable : allSyllables) {
                if (otherSyllable == syllable) {
                    isNew = true;
                }
            }
            if (isNew)
                allSyllables.add(new Syllable());
            else
                i--;
        }

        for (String wordID : allWordIDs)
            createRandomWord(wordID);

        ArrayList<String> words = new ArrayList<String>();
        String fullSentence = "";
        try {
			reader = new BufferedReader(new FileReader(System.getProperty("user.dir")+"/data/input.txt"));
			String line = reader.readLine();

			while (line != null) {
                ArrayList<String> lineWords = new ArrayList<String>();
                for (String word : line.split(" ")) {
				    words.add(word.toLowerCase());
                    lineWords.add(word.toLowerCase());
                }
                fullSentence += getSentence(lineWords)+"\n";
				line = reader.readLine();
			}

			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

        printSentence(words);
        saveSentence(fullSentence);
    }
}
