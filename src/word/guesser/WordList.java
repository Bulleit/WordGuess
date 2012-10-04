package word.guesser;

/**
 * This class stores a string array full of words and has some method to get a
 * new word from this string array.
 * 
 * @author Htx-Bruger, Anthony, Sebastian, Damian
 */
import java.util.Random;

public class WordList {

    private String[] m;
    private int i;

    /**
     * A list full of random words.
     */
    public WordList() {
        m = new String[20];
        m[0] = "Hello";
        m[1] = "School";
        m[2] = "World";
        m[3] = "Internet";
        m[4] = "video";
        m[5] = "YouTube";
        m[6] = "Volcano";
        m[7] = "program";
        m[8] = "language";
        m[9] = "DaftPunk";
        m[10] = "Dominion";
        m[11] = "Complexity";
        m[12] = "Serenade";
        m[13] = "Steamboiler";
        m[14] = "Watchmaker";
        m[15] = "Electricity";
        m[16] = "Fantasy";
        m[17] = "Future";
        m[18] = "Science";
        m[19] = "Ponies";
    }

    /**
     * Gets a random word.
     *
     * @return a secret word.
     */
    public String getWord() {
        Random rnd = new Random();
        i = rnd.nextInt(m.length);
        return m[i];
    }
}
