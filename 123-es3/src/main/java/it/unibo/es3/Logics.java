package it.unibo.es3;

import java.util.Map;
import java.util.Set;

/**
 * this interface tapresents the logic of the game. I can continue using the map because i can access to the 
 * elements with the new.
 * @param <COORDINATES> first argument
 * @param <VALUE> second argument
 */
public interface Logics<COORDINATES, VALUE> {

    /**
     * this method select 3 randome cells to add in the expanded.
     */
    void bigBang();
    /**
     * this does the expansion work. 
     * It will use a private collection that contains the actually activated cells
     * and then with a cycle will do the needed operation foreach.
     */
    void expansion();

    /**
     * @return a set that contains all the coordinates of the expanded cells.
     */
    Set<COORDINATES> getExpanded();

    /**
     * @return a map that has for keys the coordinates, and for value the buolena value.
     */
    Map<COORDINATES,VALUE> getMatrix();
}
