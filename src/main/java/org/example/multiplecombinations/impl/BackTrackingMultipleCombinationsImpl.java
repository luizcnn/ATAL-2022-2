package org.example.multiplecombinations.impl;

import org.example.multiplecombinations.MultipleCombinations;

import java.util.Arrays;
import java.util.List;

/**
 * Esta classe implementa o código para obter a combinação de n elementos, de forma que o produto desses
 * n elementes resulte no valor alvo, aplicando a técnica de backtracking. Cada elemento só pode ser usado
 * na multiplicação uma única vez.
 */
public class BackTrackingMultipleCombinationsImpl implements MultipleCombinations {

  @Override
  public void printMultipleSet(List<Integer> values, Integer targetValue) {
    final var solution = new Integer[values.size()];
//    printMultipleSet(values, targetValue, 0);
  }

  private void printMultipleSet(List<Integer> values, Integer targetValue, Integer[] solution, Integer index) {
    if (isValidSolution(values, solution, targetValue)) {
      System.out.println(Arrays.asList(solution));
    } else {

    }
  }

  private boolean isValidSolution(List<Integer> values, Integer[] solution, Integer targetValue) {
    int subtotal = 1;
    for (int i = 0; i < solution.length; i++) {
      if (solution[i] > 0) {
        subtotal *= values.get(i);
      }
    }
    return subtotal == targetValue;
  }

}
