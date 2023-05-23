package org.example.backtracking.nqueens.impl;

import org.example.backtracking.nqueens.NQueens;

import java.util.Arrays;

public class NQueensImpl implements NQueens {

  private final int sizeOfBoard;
  private int[] queensPlace;

  public NQueensImpl(int sizeOfBoard) {
    this.sizeOfBoard = sizeOfBoard;
    this.queensPlace = new int[sizeOfBoard];
  }

  @Override
  public int[] getQueensPosition() {
    /*
    The index of result array represents the line of board, and the value of the int element in array
    is the column of queen's position
    */
    final var tempSolution = new int[sizeOfBoard];
    setQueensPosition(0, tempSolution);
    return queensPlace;
  }

  private void setQueensPosition(int column, int[] solution) {
    if (column == sizeOfBoard) {
      this.queensPlace = Arrays.copyOf(solution, sizeOfBoard);
    } else {
      for (int i = 0; i < solution.length; i++) {
        solution[column] = i;
        if (isBoardValid(solution, column)) {
          setQueensPosition(column + 1, solution);
        }
      }
    }

  }

  private boolean isBoardValid(int[] solution, int lastInsertedColumn) {
    //check if last inserted queens is in the way of any other queen
    for (int i = 0; i < lastInsertedColumn; i++) {
      if (solution[i] == solution[lastInsertedColumn] ||
              Math.abs(solution[i] - solution[lastInsertedColumn]) == Math.abs(lastInsertedColumn - i))
        return false;
    }
    return true;
  }

}
