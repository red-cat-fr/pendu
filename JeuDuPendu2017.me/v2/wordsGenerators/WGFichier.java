package v2.wordsGenerators;

import v2.WordsGenerator;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Scanner;

public class WGFichier implements WordsGenerator {
    public List<String> words;

    public WGFichier() throws FileNotFoundException {
        FileReader f = new FileReader("wordlist.txt");
        Scanner s = new Scanner(f);
        String line;
        while(true) {
            try {
                line = s.nextLine();
                words.add(line);
                System.out.println(line);
            }
            catch (Exception e) {
                System.out.println("il fait beau");
                break;
            }
        }
    }

    @Override
    public String getWord() {
        int i = (int) (Math.random() * words.size());
        return words.get(i);
    }

}
