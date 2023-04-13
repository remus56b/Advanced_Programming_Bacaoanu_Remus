package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ConfigPanel extends JPanel {
    final MainFrame frame;
    private JLabel dotsLabel;
    private JLabel linesLabel;
    JSpinner dotsSpinner;
    JComboBox linesCombo;
    private JButton createButton;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        dotsLabel = new JLabel("Number of dots: ");
        dotsSpinner = new JSpinner(new SpinnerNumberModel(6, 3, 10, 1));

        linesLabel = new JLabel("Line probability: ");
        linesCombo = new JComboBox<>(new String[]{"0.2", "0.4", "0.6", "0.8", "1"});
        createButton = new JButton("Create new game");

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int numVertices = (int) dotsSpinner.getValue();
                String selectedLine = (String) linesCombo.getSelectedItem();
                Double edgeProbability = Double.parseDouble(selectedLine);
                System.out.println(edgeProbability);
                DrawingPanel drawingPanel = frame.canvas;
                drawingPanel.paintComponent(numVertices, edgeProbability);
            }
        });

        setLayout(new FlowLayout());
        add(dotsLabel);
        add(dotsSpinner);
        add(linesLabel);
        add(linesCombo);
        add(createButton);
    }
}
