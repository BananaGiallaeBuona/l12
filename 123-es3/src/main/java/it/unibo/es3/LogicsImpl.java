package it.unibo.es3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Random;

/**
 * this class.
 */
public final class LogicsImpl implements Logics<Pair<Integer, Integer>, Boolean> {
    private final int dimensions;
    private final Map<Pair<Integer, Integer>, Boolean> matrix;
    private final Set<Pair<Integer, Integer>> expanded;

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
        if (expanded.isEmpty()) {
            throw new IllegalStateException("there already some activated cells");
        }
        final Random rnd = new Random();
        while (expanded.size() < 3) {
            final int x = rnd.nextInt(dimensions); // 0 <= x < size
            final int y = rnd.nextInt(dimensions); // 0 <= y < size
            put(x, y);
            expanded.add(new Pair<>(x, y));
        }

    }

    @Override
    public void expansion() {
        for (final Pair<Integer, Integer> pair : expanded) {
            //UP
            put(pair.x(), pair.y() - 1);
            //DOWN
            put(pair.x(), pair.y() + 1);
            //LEFT
            put(pair.x() - 1, pair.y());
            //RIGHT
            put(pair.x() + 1, pair.y());
            //OBLIQUAL
            put(pair.x() - 1, pair.y() - 1); //HIGH SX
            put(pair.x() + 1, pair.y() - 1); //HIGH DX
            put(pair.x() - 1, pair.y() + 1); //DOWN SX
            put(pair.x() + 1, pair.y() + 1); //DOWN DX
        }
        for (final Pair<Integer, Integer> pair : matrix.keySet()) {
            if (matrix.get(pair)) {
                expanded.add(pair);
            }
        }
    }

    private void put(final int x, final int y) {
        if (x < dimensions && x >= 0 && y < dimensions && y >= 0) {
            matrix.put(new Pair<>(x, y), true);
        }
    }

    @Override
    public Set<Pair<Integer, Integer>> getExpanded() {
        final Set<Pair<Integer, Integer>> copy = this.expanded; //NOPMD it says that i should 
        // use the value, but i want do rerturn a definsive copy
        return copy;
        //PMD says "Consider simply using the value vs. storing it in local variable 'copy'."
    }

    @Override
    public Map<Pair<Integer, Integer>, Boolean> getMatrix() {
        final Map<Pair<Integer, Integer>, Boolean> copy = this.matrix; //NOPMD it says that i should
        //  use the value, but i want do rerturn a definsive copy
        return copy;
        //PMD says "Consider simply using the value vs. storing it in local variable 'copy'."
    }
}
