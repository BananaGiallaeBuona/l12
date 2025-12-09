package it.unibo.es1;

public class Button {
    private int value;
    private boolean state;

    Button() {
        value = 0;
        state = true;
    }

    public int getValue() {
        return value;
    }

    public void increment() {
        this.value = value + 1;
    }

    public boolean isState() {
        return state;
    }

    public void setEnabled(final boolean enabled) {
        this.state = enabled;
    }
}

