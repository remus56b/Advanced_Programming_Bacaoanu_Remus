package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.List;

public class DrawingPanel extends JPanel {
    final MainFrame frame;
    final static int W = 800, H = 600;
    List<Point> verticesGlobal;
    int c = 1;
    int numberOfDots;
    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        initPanel();
    }

    private void initPanel() {
        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                for (int i = 0; i < verticesGlobal.size() - 1; i++) {
                    Point p1 = verticesGlobal.get(i);
                    for (int j = i + 1; j < verticesGlobal.size(); j++) {
                        Point p2 = verticesGlobal.get(j);
                        if (isOnLine(e.getPoint(), p1, p2)) {
                            Graphics g = getGraphics();
                            if(c == 1)
                                g.setColor(Color.RED);
                            else g.setColor(Color.BLUE);
                            c = (c + 1) % 2;
                            g.drawLine(p1.x, p1.y, p2.x, p2.y);
                        }
                    }
                }
            }
            private boolean isOnLine(Point p, Point p1, Point p2) {
                double distance = Math.abs((p2.y - p1.y) * p.x - (p2.x - p1.x) * p.y + p2.x * p1.y - p2.y * p1.x) / Math.sqrt(Math.pow(p2.y - p1.y, 2) + Math.pow(p2.x - p1.x, 2));
                return distance <= 1;
            }
        });
    }

    protected void paintComponent(int numVertices, double edgeProbability) {
        Graphics g = getGraphics();
        g.clearRect(0, 0, 800,600);
        List<Point> vertices = new LinkedList<>();
        double boardRadius = H / 2 - 10;
        double diff = 2 * Math.PI / numVertices;
        int centerX = W / 2;
        int centerY = H / 2;

        for (int i = 0; i < numVertices; i++) {
            double angle = i * diff;
            int x = (int) Math.round(centerX + boardRadius * Math.cos(angle));
            int y = (int) Math.round(centerY + boardRadius * Math.sin(angle));
            vertices.add(new Point(x, y));
        }
        verticesGlobal = vertices;
        g.setColor(Color.GRAY);
        int c = 0;

        for (int i = 0; i < numVertices - 1; i++) {
            for (int j = i + 1; j < numVertices; j++) {
                if (Math.random() < edgeProbability) {
                    Point p1 = vertices.get(i);
                    Point p2 = vertices.get(j);
                    c = c + 1;
                    g.drawLine(p1.x, p1.y, p2.x, p2.y);
                    g.drawLine(p1.x, p1.y, p2.x, p2.y);
                }
            }
        }

        this.numberOfDots = c;

        g.setColor(Color.BLACK);
        int nodeSize = 15;
        for (Point vertex : vertices) {
            g.fillOval(vertex.x - nodeSize / 2, vertex.y - nodeSize / 2, nodeSize, nodeSize);
        }
    }


}
