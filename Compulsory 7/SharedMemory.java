package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class SharedMemory {
   private final List<Token> tokens;
   private final int numTokensPerCell;
   private int numCellsVisited;

   public SharedMemory(int numTokensPerCell) {
       this.tokens = new ArrayList<>();
       this.numTokensPerCell = numTokensPerCell;
       this.numCellsVisited = 0;
   }

   public synchronized boolean hasTokens() {
       return tokens.size() >= numTokensPerCell;
   }
    public synchronized List<Token> getTokens() {
        return tokens;
    }

   public synchronized List<Token> extractTokens() {
       if (!hasTokens()) {
           return Collections.emptyList();
       }
       List<Token> extractedTokens = new ArrayList<>(tokens.subList(0, numTokensPerCell));
       tokens.subList(0, numTokensPerCell).clear();
       return extractedTokens;
   }

   public synchronized void addTokens(List<Token> newTokens) {
       tokens.addAll(newTokens);
   }

   public synchronized void markCellVisited() {
       numCellsVisited++;
   }

   public synchronized boolean isComplete(int numCells) {
       return numCellsVisited == numCells;
   }
}
