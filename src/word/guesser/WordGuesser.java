/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package word.guesser;

/**
 *
 * @author Htx-Bruger, Anthony, Sebastian, Damian
 */
public class WordGuesser {

    /**
     * This is the main object that runs the game
     *
     * @param args the command line arguments.
     */
    public static void main(String[] args) {
        GameConsole gc = new GameConsole();
        gc.instructions();
        gc.menu();
    }
}
