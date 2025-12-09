package it.unibo.es1;

/**
 * a model implementation of the button.
 */
public final class Button {
    private int value;
    private boolean state;

    Button() {
        value = 0;
        state = true;
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

    /**
     * @return a variable that is true if the values is modifible
     */
    public boolean isState() {
        return state;
    }

    /**
     * @param enabled it's used to modify the state of the button
     */
    public void setEnabled(final boolean enabled) {
        this.state = enabled;
    }
}

