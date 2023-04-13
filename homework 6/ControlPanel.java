package org.example;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;

class ControlPanel extends JPanel {
    final MainFrame frame;
    final DrawingPanel canvas;

    JButton loadBtn = new JButton("Load");
    JButton saveBtn = new JButton("Save");
    JButton exitBtn = new JButton("Exit");

    public ControlPanel(MainFrame frame, DrawingPanel canvas) {
        this.frame = frame;
        this.canvas = canvas;
        init();
    }

    private void init() {
        setLayout(new GridLayout(1, 3));
        add(loadBtn);
        add(saveBtn);
        add(exitBtn);

        exitBtn.addActionListener(this::exitGame);
        saveBtn.addActionListener(this::saveImage);

    }

    private void exitGame(ActionEvent e) {
        frame.dispose();
    }

    private void saveImage(ActionEvent e) {
        SwingUtilities.invokeLater(() -> {
            Rectangle rect = frame.getContentPane().getBounds();
            BufferedImage image = new BufferedImage(rect.width, rect.height, BufferedImage.TYPE_INT_RGB);
            frame.getContentPane().paint(image.getGraphics());
            try {
                File outputfile = new File("test.png");
                ImageIO.write(image, "png", outputfile);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
    }




}
