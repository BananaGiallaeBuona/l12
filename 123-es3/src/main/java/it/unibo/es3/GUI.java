package it.unibo.es3;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.Serial;
import java.util.HashMap;
import java.util.Map;

/**
 * GUI for the game.
 */
public final class GUI extends JFrame {

    @Serial
    private static final long serialVersionUID = 1L;
    private final LogicsImpl logic;
    private final Map<Pair<Integer, Integer>, JButton> cells = new HashMap<>();

    /**
     * Constructor.
     *
     * @param width the size of the grid
     */
    public GUI(final int width) {
        this.logic = new LogicsImpl(width);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Create a panel with a grid layout
        final JPanel gridPanel = new JPanel(new GridLayout(width, width));
        final JPanel buttonPanel = new JPanel(new FlowLayout());
        final JPanel macroComponents = new JPanel(new BorderLayout());
        this.getContentPane().add(macroComponents);
        macroComponents.add(gridPanel, BorderLayout.CENTER);
        // Create buttons and add them to the panel
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width; j++) {
                final var pos = new Pair<>(j, i);
                final JButton button = new JButton("");
                this.cells.put(pos, button);
                gridPanel.add(button);
            }
        }
        final JButton next = new JButton(">");
        next.addActionListener(e -> {
                    logic.expansion();
                    //i want to make that foreach element that is true i can get the value
                    reload();
                });
        buttonPanel.add(next);
        macroComponents.add(buttonPanel, BorderLayout.SOUTH);
        pack();
        startingGame();
    }

    private void startingGame() {
        logic.bigBang();
        reload();
        this.setVisible(true);
    }

    private void reload() {
        logic.getExpanded().stream().forEach(k -> cells.get(k).setText("*"));
    }
}
