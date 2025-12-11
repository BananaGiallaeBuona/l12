package it.unibo.es2;

/**
 * this interface is the model of the game.
 */
public interface Logics {

    /**
     * @param p is the pair, which give me the coordinats to hit a specified button.
     * 
     * @return true if the button NOW has *, returns false instead.
     */
    boolean hit(Pair<Integer, Integer> p);

    /**
     * @param p is the pair, which give me the coordinats to check a specified button.
     * 
     * @return true if the button NOW has *, returns false instead.
     */
    boolean isClicked(Pair<Integer, Integer> p);

    /**
     * @return true if there is anuy condition needed to end the game: line or column full *.
     */
    boolean toQuit();
}
