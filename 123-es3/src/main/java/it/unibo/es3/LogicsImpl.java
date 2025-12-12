package it.unibo.es3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

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
        final var rnd = ThreadLocalRandom.current();
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
        for (final var e : matrix.entrySet()) {
            if (e.getValue()) {
                expanded.add(e.getKey());
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
        return new HashSet<>(this.expanded);
    }

    @Override
    public Map<Pair<Integer, Integer>, Boolean> getMatrix() {
        return new HashMap<>(this.matrix);
    }
}
