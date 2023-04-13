package org.example;

class ExplorationMap {
    private final int[][] map;
    private final int numRows;
    private final int numCols;

    public ExplorationMap(int numRows, int numCols) {
        this.numRows = numRows;
        this.numCols = numCols;
        this.map = new int[numRows][numCols];
    }

    public boolean isCellVisited(int row, int col) {
        return map[row][col] != 0;
    }

    public void markCellVisited(int row, int col) {
        map[row][col] = 1;
    }

    public int getNumRows() {
        return numRows;
    }

    public int getNumCols() {
        return numCols;
    }
}
