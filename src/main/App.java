package main;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

import language.Language;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws Exception {
        String[] italianoVowelsArray = {"i", "u", "e", "o", "ɛ", "ɔ", "a"};
        String[] italianoConsonantsArray = {"m", "n", "p", "b", "t", "d", "k", "g", "f", "v", "s", "z", "ʃ", "ʒ", "j", "w", "l", "r"};
        ArrayList<String> italianoVowels = new ArrayList<String>(Arrays.asList(italianoVowelsArray));
        ArrayList<String> italianoConsonants = new ArrayList<String>(Arrays.asList(italianoConsonantsArray));
        Language italiano = new Language("Pizza language", 7, 3, 50, italianoVowels, italianoConsonants, 0.9, 0.2);
        
        String[] francaisVowelsArray = {"a", "e", "i", "o", "u", "y", "ə", "ɛ", "œ", "ø", "ɔ"};
        String[] francaisConsonantsArray = {"b", "d", "f", "g", "j", "k", "l", "m", "n", "p", "s", "t", "v", "w", "z", "∫", "ɹ", "ʒ"};
        ArrayList<String> francaisVowels = new ArrayList<String>(Arrays.asList(francaisVowelsArray));
        ArrayList<String> francaisConsonants = new ArrayList<String>(Arrays.asList(francaisConsonantsArray));
        Language francais = new Language("Baguette language", 7, 5, 20, francaisVowels, francaisConsonants, 0.8, 0.8);
        
        String[] hawaiianVowelsArray = {"a", "e", "i", "o", "u"};
        String[] hawaiianConsonantsArray = {"h", "l", "k", "m", "n", "w", "p", "ʔ"};
        ArrayList<String> hawaiianVowels = new ArrayList<String>(Arrays.asList(hawaiianVowelsArray));
        ArrayList<String> hawaiianConsonants = new ArrayList<String>(Arrays.asList(hawaiianConsonantsArray));
        Language hawaiian = new Language("Surfer language", 9, 5, 35, hawaiianVowels, hawaiianConsonants, 0.95, 0.05);
        
        italiano.load();
        francais.load();
        hawaiian.load();

        BufferedReader reader;

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
                fullSentence += hawaiian.getSentence(lineWords)+"\n";
				line = reader.readLine();
			}

			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
        hawaiian.printSentence(words);
        Language.saveSentence(fullSentence);
    }
}
