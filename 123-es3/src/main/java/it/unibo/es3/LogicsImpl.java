package it.unibo.es3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Random;

public final class LogicsImpl implements Logics<Pair<Integer, Integer>, Boolean>{
    private int dimensions;
    private final Map<Pair<Integer, Integer>, Boolean> matrix;
    private Set<Pair<Integer, Integer>> expanded;

    LogicsImpl(final int dimensions) {
        this.dimensions = dimensions;
        this.matrix = new HashMap<>();
        this.expanded = new HashSet<>();
        for (int x = 0; x < dimensions; x++) {
            for (int y = 0; y < dimensions; y++) {
                matrix.put(new Pair<>(x, y), false);
            }
        }
    }
    
    @Override
    public void bigBang() {
        if (expanded.size() > 0){
            throw new IllegalStateException("there already some activated cells");
        }
        Random rnd = new Random();
        while (expanded.size() < 3) {
            int x = rnd.nextInt(dimensions); // 0 <= x < size
            int y = rnd.nextInt(dimensions); // 0 <= y < size
            put(x, y);
            expanded.add(new Pair<>(x,y));
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

    @Override
    public Set<Pair<Integer, Integer>> getExpanded() {
        return this.expanded;
    }

    @Override
    public Map<Pair<Integer, Integer>, Boolean> getMatrix() {
        Map<Pair<Integer, Integer>, Boolean> cp = this.matrix;
        return cp;
    }
}
