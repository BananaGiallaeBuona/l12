package it.unibo.es3;

/**
 * this interface tapresents the logic of the game. I can continue using the map because i can access to the 
 * elements with the new.
 */
public interface Logics {
    /**
     * this activates the process, i already don't know if it's useful or 
     * not becuase i don't know the lenght of other methods.
     */
    void next();

    /**
     * this does the expansion work. 
     * It will use a private collection that contains the actually activated cells
     * and then with a cycle will do the needed operation foreach.
     */
    void expansion();
}
