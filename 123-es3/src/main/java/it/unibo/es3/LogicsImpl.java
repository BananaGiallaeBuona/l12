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
        //TODO CHECKBORDER()
        for (Pair<Integer,Integer> pair : expanded) {
            //UP
            matrix.put(new Pair<>(pair.x(), pair.y()-1), true);
            //DOWN
            matrix.put(new Pair<>(pair.x(), pair.y()+1), true);
            //LEFT
            matrix.put(new Pair<>(pair.x()-1, pair.y()), true);
            //RIGHT
            matrix.put(new Pair<>(pair.x()+1, pair.y()), true);
            //OBLIQUAL
            matrix.put(new Pair<>(pair.x()-1, pair.y()-1), true); //HIGH SX
            matrix.put(new Pair<>(pair.x()+1, pair.y()-1), true); //HIGH DX
            matrix.put(new Pair<>(pair.x()-1, pair.y()+1), true); //DOWN SX
            matrix.put(new Pair<>(pair.x()+1, pair.y()+1), true); //DOWN DX
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
