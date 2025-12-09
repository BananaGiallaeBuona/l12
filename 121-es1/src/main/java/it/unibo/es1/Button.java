package it.unibo.es1;

/**
 * a model implementation of the button.
 */
public final class Button {
    private int value;

    Button() {
        value = 0;
    }

    /**
     * @return the int value of the button
     */
    public int getValue() {
        return value;
    }

    /**
     * increments the value associatd to the button.
     */
    public void increment() {
        this.value = value + 1;
    }
}

