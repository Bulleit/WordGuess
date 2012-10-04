package word.guesser;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Htx-Bruger
 */
public class GameConsole {

    private GameEngine ge = new GameEngine(); // initializes the Business Logic layer.
    private ArrayList<String> m = new ArrayList<String>(ge.wordLength()); // creates a new arraylist full of stars.
    private ArrayList<String> progress = new ArrayList<String>(); // the other array list with the letters we already guessed.
    boolean wordIsGuessed = false; // did we win?

    /**
     * The main method.
     */
    public void play() {
        ge.insertLetters(); // it takes the secret word and splits it up into letters which will be put in the 'letters' array list.
        System.out.println("This is the Word Guesser game.");
        System.out.println("In this game, you must guess a word.");
        System.out.println("Try entering different letters to see if they fit the word.");
        System.out.println("The length of the word is " + ge.wordLength() + " letters.\n");

        for (int i = 0; i < ge.wordLength(); i++) {
            m.add("*");
            System.out.print(m.get(i));
        }
        //System.out.println(ge.getSecretWord());
        guesses(); // asks for an input.
        System.out.println("Congratulations! You guessed the word in " + ge.tries.size() + " tries."); // Congrats.
    }

    /**
     * In case we guessed a letter it changes one of the stars.
     *
     * @param guess is the letter what we guessed.
     * @param i position.
     */
    public void progressChange(char guess, int i) {
        m.set(i, String.valueOf(guess));
        isGuessed(); // checks if the word is guessed or not.
    }

    /**
     * Asks for input; whether the whole word or just a single letter.
     */
    private void guesses() {
        Scanner sc = new Scanner(System.in);

        while (!wordIsGuessed) {
            System.out.print("\nYour guess: ");

            String guess = sc.nextLine();
            char letter = guess.charAt(0);
            if (ge.canSubmit(String.valueOf(guess))) {
                if (guess.length() == ge.wordLength()) {
                    if (ge.guessWord(guess)) {
                        ge.storeGuesses(guess);
                        wordIsGuessed = true;
                        break;
                    }
                    ge.storeGuesses(guess);
                } else {
                    ge.storeGuesses(String.valueOf(letter));
                    for (int i = 0; i < ge.wordLength(); i++) {
                        if (ge.guessLetter(letter, i)) {
                            progressChange(letter, i);
                        }
                    }
                }
            } else {
                System.out.println("You already guessed that.");
            }

            System.out.println("Your previous guesses: " + ge.tries.toString().replace("[", "").replace("]", "") + "\n");

            for (int i = 0; i < ge.wordLength(); i++) {
                System.out.print(m.get(i));
            }

            guesses(); // calls for itself.
        }
    }

    /**
     * Checks whether the word is fully guessed or not. Changes the
     * wordIsGuessed to true in case we've guessed the word.
     */
    private void isGuessed() {
        if (!m.contains("*")) {
            wordIsGuessed = true;
        }
    }
}
