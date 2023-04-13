package org.example;

import javax.swing.*;
import java.awt.*;

public class DrawingPanel extends JPanel {
    final Main.MainFrame frame;
    final static int W = 800, H = 600;
    public DrawingPanel(Main.MainFrame frame) {
        this.frame = frame;
        initPanel();
    }

    private void initPanel() {
        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // de facut graful
    }
}
