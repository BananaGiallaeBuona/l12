package it.unibo.es3;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LogicsImpl implements Logics{
    private int dimensions;
    private final Map<Pair<Integer, Integer>, Boolean> matrix;
    private Set<Pair<Integer, Integer>> expanded;

    LogicsImpl(final int dimensions) {
        this.dimensions = dimensions;
        this.matrix = new HashMap<>();
        for (int x = 0; x < dimensions; x++) {
            for (int y = 0; y < dimensions; y++) {
                matrix.put(new Pair<>(x, y), false);
            }
        }
    }
    
    @Override
    public void expansion() {
        for (Pair<Integer,Integer> pair : expanded) {
            //UP
            put(pair.x(), pair.y()-1);
            //DOWN
            put(pair.x(), pair.y()+1);
            //LEFT
            put(pair.x()-1, pair.y());
            //RIGHT
            put(pair.x()+1, pair.y());
            //OBLIQUAL
            put(pair.x()-1, pair.y()-1); //HIGH SX
            put(pair.x()+1, pair.y()-1); //HIGH DX
            put(pair.x()-1, pair.y()+1); //DOWN SX
            put(pair.x()+1, pair.y()+1); //DOWN DX
        }
        for (Pair<Integer,Integer> pair : matrix.keySet()) {
            if (matrix.get(pair)){
                expanded.add(pair);
            }
        }
    }

    private void put(int x, int y){
        if (x < dimensions && x >= 0 && y < dimensions && y >= 0){
            matrix.put(new Pair<>(x, y), true);
        }
    } 
}
