package word.guesser;

/**
 * This is the main class, which runs the UI.
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
        GameConsole gc = new GameConsole(); // initializes the UI.
        gc.instructions(); // prints out some text/instructions.
        gc.menu(); // shows the main menu.
    }
}
