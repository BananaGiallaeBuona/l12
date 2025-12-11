package it.unibo.es2;

/**
 * we need to represent a grid, so every element of the grid can be
 * clicked or not, it's not importnt if the 
 *
 */
public interface Logics {

    /**
     * 
     * @param p is the pair, which give me the coordinats to hit a specified button.  
     * 
     * @return true if the button has *, returns false instead.
     */
    public boolean hit(Pair<Integer, Integer> p);

    /**
     * 
     * @param p is the pair, which give me the coordinats to check a specified button.  
     * 
     * @return true if the button has *, returns false instead.
     */
    public boolean isClicked(Pair<Integer, Integer> p);

    /**
     * 
     * @return true if there is anuy condition needed to end the game, 
     * line or column full *.
     */
    public boolean toQuit();
}
