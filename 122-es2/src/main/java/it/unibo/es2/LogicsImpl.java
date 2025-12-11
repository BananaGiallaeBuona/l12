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
        if (p.x() < 0 || p.x() >= dimensions || p.y() < 0 || p.y() >= dimensions) {
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
        for (int row = 0; row < this.dimensions; row++) {
            boolean rowFull = true;
            // Continuo il ciclo solo se rowFull è ancora true to mantain FF
            for (int col = 0; col < this.dimensions && rowFull; col++) {
                if (!matrix.get(new Pair<>(row, col))) {
                    rowFull = false;
                }
            }
            if (rowFull) {
                return true;
            }
        }

        // Controllo le colonne
        for (int col = 0; col < this.dimensions; col++) {
            boolean colFull = true;
            // Continuo il ciclo solo se colFull è ancora true
            for (int row = 0; row < this.dimensions && colFull; row++) {
                if (!matrix.get(new Pair<>(row, col))) {
                    colFull = false;
                }
            }
            if (colFull) {
                return true;
            }
        }

        return false;
    }
    
}
