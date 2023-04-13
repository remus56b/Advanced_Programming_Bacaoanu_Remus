package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Exploration {
    private final ExplorationMap map;
    private final SharedMemory memory;
    private final List<Robot> robots;

    public Exploration(int numRows, int numCols, int numRobots, int numTokensPerCell) {
        this.map = new ExplorationMap(numRows, numCols);
        this.memory = new SharedMemory(numTokensPerCell);
        this.robots = new ArrayList<>();
        for (int i = 1; i <= numRobots; i++) {
            robots.add(new Robot("Robot " + i, map, memory));
        }
        Collections.shuffle(memory.getTokens());
    }

    public void startExploration() {
        List<Thread> threads = new ArrayList<>();
        for (Robot robot : robots) {
            Thread thread = new Thread(robot);
            thread.start();
            threads.add(thread);
        }
        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
