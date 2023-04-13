package org.example;
import javax.swing.*;
import java.awt.*;

import static javax.swing.SwingConstants.CENTER;

public class Main {
    public static void main(String[] args) {
        new MainFrame().setVisible(true);
    }
    public static class  MainFrame extends JFrame {
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

            controlPanel = new ControlPanel(this);
            add(controlPanel, BorderLayout.SOUTH);

            pack();
        }
    }
}
