package it.unibo.es2;

import java.util.HashMap;
import java.util.Map;

public class LogicsImpl implements Logics{
    private final int dimensions;
    private final Map<Pair<Integer, Integer>, Boolean> matrix;

    LogicsImpl(final int dimensions){
        this.dimensions = dimensions;
        this.matrix = new HashMap<>();
        for (int x = 0; x < dimensions; x++){
            for (int y = 0; y < dimensions; y++){
                matrix.put(new Pair<>(x, y), false);
            }
        }
    }

    @Override
    public boolean hit(final Pair<Integer, Integer> p) {
        if ((p.x() < 0 && p.x() > dimensions) || p.y() < 0 && p.y() > dimensions){
            throw new IllegalArgumentException("this position isn't in the grid");
        } else {
            //good
            if (isClicked(p)){
                matrix.put( p, false);
                return false;
            } else {
                matrix.put( p, true);
                return true;
            }
        }
    }
    
    @Override
    public boolean isClicked(final Pair<Integer, Integer> p) {
        return matrix.get(p) == true;
    }

    @Override
    public boolean toQuit() {
        int counter = 0;
        //TODO I don't know how to chack every cell
        for (int x = 0; x < dimensions; x++){
            for (int y = 0; y < dimensions; y++){
                
            }
        }
    }
    
}
