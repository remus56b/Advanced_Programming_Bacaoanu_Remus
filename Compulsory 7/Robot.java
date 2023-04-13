package org.example;

import java.util.List;
import java.util.Random;

class Robot implements Runnable {
    private final String name;
    private final ExplorationMap map;
    private final SharedMemory memory;
    private int row;
    private int col;

    public Robot(String name, ExplorationMap map, SharedMemory memory) {
        this.name = name;
        this.map = map;
        this.memory = memory;
        this.row = new Random().nextInt(map.getNumRows());
        this.col = new Random().nextInt(map.getNumCols());
    }

    private void move() {
        int newRow = row + new Random().nextInt(3) - 1;
        int newCol = col + new Random().nextInt(3) - 1;
        if (newRow >= 0 && newRow < map.getNumRows() && newCol >= 0 && newCol < map.getNumCols() &&
                (newRow != row || newCol != col)) {
            row = newRow;
            col = newCol;
            System.out.println(name + " este pe celula (" + row + ", " + col + ")");
        }
    }

    private void visitCell() {
        if (!map.isCellVisited(row, col)) {
            List<Token> extractedTokens = memory.extractTokens();
            if (!extractedTokens.isEmpty()) {
                map.markCellVisited(row, col);
                memory.markCellVisited();
                memory.addTokens(extractedTokens);
            }
        }
    }

    @Override
    public void run() {
        while (!memory.isComplete(map.getNumRows() * map.getNumCols())) {
            synchronized (memory) {
                if (memory.hasTokens()) {
                    visitCell();
                }
            }
            move();
        }
    }
}
