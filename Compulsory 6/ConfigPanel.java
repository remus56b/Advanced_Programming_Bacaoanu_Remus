package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ConfigPanel extends JPanel {
    final Main.MainFrame frame;
    JLabel dotsLabel, linesLabel;
    JSpinner dotsSpinner;
    JComboBox linesCombo;
    JButton createButton;
    public ConfigPanel(Main.MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {

        dotsLabel = new JLabel("Number of dots:");
        dotsSpinner = new JSpinner(new SpinnerNumberModel(6, 3, 100, 1));

        linesLabel = new JLabel("Number of lines:");
        linesCombo = new JComboBox<>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9});

        createButton = new JButton("Create new game");
        createButton.addActionListener(this::createGame);

        add(dotsLabel);
        add(dotsSpinner);
        add(linesLabel);
        add(linesCombo);
        add(createButton);
    }
    private void createGame(ActionEvent e) {
        int numDots = (int) dotsSpinner.getValue();
        int numLines = (int) linesCombo.getSelectedItem();
    }
}
