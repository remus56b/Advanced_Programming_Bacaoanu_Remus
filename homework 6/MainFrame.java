package org.example;

import javax.swing.*;
import java.awt.*;

import static javax.swing.SwingConstants.CENTER;

class MainFrame extends JFrame {
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;

    public MainFrame() {
        super("My Drawing Application");
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        configPanel = new ConfigPanel(this);
        add(configPanel, BorderLayout.NORTH);

        canvas = new DrawingPanel(this);
        add(canvas, CENTER);

        controlPanel = new ControlPanel(this, canvas);
        add(controlPanel, BorderLayout.SOUTH);

        pack();
    }

}
