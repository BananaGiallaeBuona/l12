package it.unibo.es1;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the Logics interface.
 */
public class LogicsImpl implements Logics {
    private final List<Integer> buttons;

    /**
     * Constructor.
     *
     * @param size the size of the logics
     */
    public LogicsImpl(final int size) {
        this.buttons = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            this.buttons.add(0);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int size() {
        return this.buttons.size();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Integer> values() {
        return buttons;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Boolean> enabledStates() {
        final List<Boolean> states = new ArrayList<>();
        buttons.stream().forEach(i -> states.add(i != buttons.size()));
        return states;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hit(final int elem) {
        buttons.add(elem, buttons.get(elem)+1);
        return buttons.get(elem);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String result() {
        //sample: <<0|2|1|3>>
        final StringBuilder result = new StringBuilder("<<");
        for (final Integer button : buttons) {
            result.append(button).append('|'); 
        }
        result.replace(result.lastIndexOf("|"), result.length(), ">>");
        return result.toString();
    }

    private boolean checkEquals() {
        final int value = buttons.get(0); // we have the 1st, then we 
        for (final Integer button : buttons) {
            if (value == 0 || value != button) {
                return false;
            }
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean toQuit() {
        if (checkEquals()) { //if all values are equals we exit from the program without pintinf anything
            return true;
        }
        //we check if all buttons are diseablead by counting how many of them are disabled
        int reached = 0;
        for (final boolean state : enabledStates()) {
            if (!state) {
                reached++;
            }
        }
        return reached == buttons.size();
    }

}
